package com.QuickProject.QuickProjectApp.dao;

import com.QuickProject.QuickProjectApp.entity.User;
import com.QuickProject.QuickProjectApp.projections.UserProjection;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Хранилище для работы с сущностью "user"
 */
@RepositoryRestResource(path="users",excerptProjection = UserProjection.class)
public interface UserRepository extends JpaRepository<User, UUID> {
    @Transactional(readOnly = true)
    List<User> findByEmail(String email) throws DataAccessException;


}
