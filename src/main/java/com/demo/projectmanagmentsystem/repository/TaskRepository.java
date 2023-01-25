package com.demo.projectmanagmentsystem.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.projectmanagmentsystem.model.Task;

import antlr.collections.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    List findAllByProjectId(UUID projectId);
    List findAllByUserId(UUID userId);
}
