package com.QuickProject.QuickProjectApp.projections;

import com.QuickProject.QuickProjectApp.entity.Journal;
import com.QuickProject.QuickProjectApp.entity.Project;
import com.QuickProject.QuickProjectApp.entity.User;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * The interface User projection.
 */
@Projection(name = "full-user", types = {User.class})
public interface UserProjection {
    /**
     * Gets id.
     *
     * @return the id
     */
    UUID getId();

    /**
     * Gets nickname.
     *
     * @return the nickname
     */
    String getNickname();

    /**
     * Gets email.
     *
     * @return the email
     */
    String getEmail();

    /**
     * Gets telegram.
     *
     * @return the telegram
     */
    String getTelegram();

    /**
     * Gets phone.
     *
     * @return the phone
     */
    String getPhone();

    /**
     * Gets user created time.
     *
     * @return the created time
     */
    LocalDateTime getCreated_at();

    /**
     * Gets time zone.
     *
     * @return the time zone
     */
    String getTz();

    /**
     * Gets enable user (deleted or not).
     *
     * @return to enable
     */
    Boolean getEnable();

    /**
     * Gets project role.
     *
     * @return the project role
     */
    String getProject_role();

    /**
     * Gets portfolio link.
     *
     * @return the portfolio link
     */
    String getPortfolio_link();

    /**
     * Get photo.
     *
     * @return the byte [ ]
     */
    byte[] getPhoto();

    /**
     * Gets journal.
     *
     * @return the journal
     */
    List<Journal> getJournal();

    /**
     * Gets project.
     *
     * @return the project
     */
    Project getProject();
}
