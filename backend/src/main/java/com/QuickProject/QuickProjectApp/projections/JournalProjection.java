package com.QuickProject.QuickProjectApp.projections;

import com.QuickProject.QuickProjectApp.entity.Journal;
import com.QuickProject.QuickProjectApp.entity.Project;
import com.QuickProject.QuickProjectApp.entity.ProjectRole;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * The interface Journal projection.
 */
@Projection(name = "full-journal", types = {Journal.class})
public interface JournalProjection {
    /**
     * Gets id.
     *
     * @return the id
     */
    UUID getId();

    /**
     * Gets project.
     *
     * @return the project
     */
    Project getProject();

    /**
     * Gets project role.
     *
     * @return the project role
     */
    ProjectRole getProjectRole();

    /**
     * Gets time adding.
     *
     * @return the time adding
     */
    LocalDateTime getAdding_at();

    /**
     * Gets finished time.
     *
     * @return the time finished
     */
    LocalDateTime getFinished_at();
}
