package com.QuickProject.QuickProjectApp.entity;

import java.util.UUID;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс для работы с сущностью "queue"
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "queue")
public class Queue {

    @Id
    @Column(name = "id")
    @NotNull
    private UUID id = UUID.randomUUID();

    @OneToOne
    @PrimaryKeyJoinColumn
    @NotNull
    private User user;

    @OneToOne
    @JoinColumn(name = "project_role_id")
    @NotNull
    private ProjectRole projectRole;

    @Column(name = "checked")
    private Boolean checked;

}
