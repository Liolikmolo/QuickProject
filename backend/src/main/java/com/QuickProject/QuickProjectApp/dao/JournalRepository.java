package com.QuickProject.QuickProjectApp.dao;

import com.QuickProject.QuickProjectApp.entity.Journal;
import com.QuickProject.QuickProjectApp.projections.JournalProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

/**
 * Хранилище для работы с сущностью "journal"
 */
@RepositoryRestResource(path="journal",excerptProjection = JournalProjection.class)
public interface JournalRepository extends JpaRepository<Journal, UUID> {


}
