package com.QuickProject.QuickProjectApp.dao;

import com.QuickProject.QuickProjectApp.entity.Queue;
import com.QuickProject.QuickProjectApp.projections.QueueProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

/**
 * Хранилище для работы с сущностью "queue"
 */
@RepositoryRestResource(path="queue",excerptProjection = QueueProjection.class)
public interface QueueRepository extends JpaRepository<Queue, UUID> {
}
