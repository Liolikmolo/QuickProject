package com.QuickProject.QuickProjectApp.dao;

import com.QuickProject.QuickProjectApp.entity.Project;
import com.QuickProject.QuickProjectApp.projections.ProjectProjection;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Хранилище для работы с сущностью "project"
 */
@RepositoryRestResource(path="projects",excerptProjection = ProjectProjection.class)
public interface ProjectRepository extends JpaRepository<Project, UUID> {
    @Transactional(readOnly = true)
    List<Project> findByName(String name) throws DataAccessException;

}
