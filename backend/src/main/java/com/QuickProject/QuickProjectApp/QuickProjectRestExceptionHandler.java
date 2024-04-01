package com.QuickProject.QuickProjectApp;

import jakarta.persistence.RollbackException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class QuickProjectRestExceptionHandler extends ResponseEntityExceptionHandler {
    private static final System.Logger SYSTEM_LOGGER = System.getLogger(QuickProjectRestExceptionHandler.class.getName());

    private static final String VALIDATION_ERROR = "Validation error";

    private static final String INVALID_PARAMS = "invalidParams";

    private static final String NAME = "name";

    private static final String REASON = "reason";

    /**
     * Handles all unhandled exceptions.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception exception) {
        SYSTEM_LOGGER.log(System.Logger.Level.ERROR, "Unhandled exception", exception);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(TransactionSystemException.class)
    protected ResponseEntity<Object> handleConstraintViolationException(TransactionSystemException exception, WebRequest request) {

        if (exception.getCause() instanceof RollbackException) {
            if (exception.getCause().getCause() instanceof ConstraintViolationException) {
                var validationException = (ConstraintViolationException) exception.getCause().getCause();
                var problem = Problem.create()
                        .withTitle(VALIDATION_ERROR)
                        .withStatus(HttpStatus.CONFLICT)
                        .withProperties(Map.of(INVALID_PARAMS,
                                List.of(validationException.getConstraintViolations().stream()
                                        .collect(Collectors.toMap(
                                                violation -> violation.getPropertyPath().toString(),
                                                ConstraintViolation::getMessage)))));
                return createProblemResponse(exception, request, problem);
            }
        }
        return null;
    }

    Map<String, String> convertViolationStrings(ConstraintViolationException validationException) {
        return validationException.getConstraintViolations().stream()
                .collect(Collectors.toMap(
                        violation -> violation.getPropertyPath().toString(),
                        ConstraintViolation::getMessage));
    }

    private ResponseEntity<Object> createProblemResponse(Exception exception, WebRequest request, Problem problem) {
        var httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_PROBLEM_JSON);
        return handleExceptionInternal(exception, problem, httpHeaders, problem.getStatus(), request);
    }

}
