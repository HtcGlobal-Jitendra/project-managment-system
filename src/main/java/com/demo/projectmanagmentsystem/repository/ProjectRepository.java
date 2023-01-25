package com.demo.projectmanagmentsystem.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.projectmanagmentsystem.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, UUID> {

	List<Project> findAllByUserId(UUID userId);
}

