package com.QuickProject.QuickProjectApp.projections;

import com.QuickProject.QuickProjectApp.entity.*;
import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

/**
 * The interface Queue projection.
 */
@Projection(name = "full-queue", types = {Queue.class})
public interface QueueProjection {
    /**
     * Gets id.
     *
     * @return the id
     */
    UUID getId();

    /**
     * Gets user.
     *
     * @return the user
     */
    User getUser();

    /**
     * Gets project role.
     *
     * @return the project role
     */
    ProjectRole getProjectRole();

    /**
     * Gets checked.
     *
     * @return the checked
     */
    Boolean getChecked();
}
