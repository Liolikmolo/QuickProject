package com.QuickProject.QuickProjectApp.entity;

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
 * Класс для работы с сущностью "project_role"
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects_roles")
@Data
public class ProjectRole {

    @Id
    @Column(name = "id")
    @NotNull
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    @NotNull
    @Size(min=5,max = 100)
    private String name;

    @Column(name = "description")
    @Size(min=5,max = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @NotNull
    private Project project;

    @Builder.Default
    @OneToMany(mappedBy = "projectRole")
    private List<Journal> journal = new ArrayList<>();

    @OneToOne(mappedBy = "projectRole")
    private Queue queue;
}
