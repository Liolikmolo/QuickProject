package com.QuickProject.QuickProjectApp.projections;

import com.QuickProject.QuickProjectApp.entity.*;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;
import java.util.UUID;

/**
 * The interface Project role projection.
 */
@Projection(name = "full-project-role", types = {ProjectRole.class})
public interface ProjectRoleProjection {
    /**
     * Gets id.
     *
     * @return the id
     */
    UUID getId();

    /**
     * Gets description.
     *
     * @return the description
     */
    String getDescription();

    /**
     * Gets project.
     *
     * @return the project
     */
    Project getProject();

    /**
     * Gets journal.
     *
     * @return the journal
     */
    List<Journal>  getJournal();

    /**
     * Gets queue.
     *
     * @return the queue
     */
    Queue getQueue();
}
