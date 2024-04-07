package com.QuickProject.QuickProjectApp.projections;

import com.QuickProject.QuickProjectApp.entity.Journal;
import com.QuickProject.QuickProjectApp.entity.ProjectRole;
import com.QuickProject.QuickProjectApp.entity.User;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * The interface Project projection.
 */
@Projection(name = "full-project", types = {ProjectRole.class})
public interface ProjectProjection {
    /**
     * Gets id.
     *
     * @return the id
     */
    UUID getId();

    /**
     * Gets user (project creator).
     *
     * @return the user
     */
    User getCreator();

    /**
     * Gets name.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets description.
     *
     * @return the description
     */
    String getDescription();

    /**
     * Gets enable.
     *
     * @return the enable
     */
    Boolean getEnable();

    /**
     * Gets project time created.
     *
     * @return the time created
     */
    LocalDateTime getCreated_at();

    /**
     * Gets closed time.
     *
     * @return the closed time
     */
    LocalDateTime getClosed_at();

    /**
     * Gets journal.
     *
     * @return the journal
     */
    List<Journal> getJournal();

    /**
     * Gets project roles.
     *
     * @return the project roles
     */
    List<ProjectRole> getProjectRoles();
}
