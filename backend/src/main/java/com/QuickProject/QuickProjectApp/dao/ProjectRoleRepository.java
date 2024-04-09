package com.QuickProject.QuickProjectApp.dao;

import java.util.List;
import java.util.UUID;

import com.QuickProject.QuickProjectApp.projections.ProjectRoleProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.QuickProject.QuickProjectApp.entity.ProjectRole;

/**
 * Хранилище для работы с сущностью "project_role"
 */
@RepositoryRestResource(path="project_role",excerptProjection = ProjectRoleProjection.class)
public interface ProjectRoleRepository extends JpaRepository<ProjectRole, UUID> {
    @Query("SELECT pr FROM ProjectRole pr")
    List<ProjectRole> getAll();
}
