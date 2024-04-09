package com.QuickProject.QuickProjectApp.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс для работы с сущностью "project"
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "projects")
public class Project {

    @Id
    @Column(name = "id")
    @NotNull
    private UUID id = UUID.randomUUID();

    @OneToOne
    @JoinColumn(name = "creator_id") //айди владельца(создателя проекта)
    @NotNull
    private User creator;

    @Column(name = "name")
    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @Column(name = "description")
    @NotNull
    @Size(min = 10, max = 1000)
    private String description;

    @Column(name = "enable")
    @NotNull
    private Boolean enable;

    @Column(name = "created_at")
    @NotNull
    private LocalDateTime created_at;

    @Column(name = "closed_at")
    private LocalDateTime closed_at;

    @Builder.Default
    @OneToMany(mappedBy = "project")
    private List<Journal> journal = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "project")
    private List<ProjectRole> projectRoles = new ArrayList<>();
}
