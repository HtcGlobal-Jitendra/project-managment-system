package com.demo.projectmanagmentsystem.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.projectmanagmentsystem.model.Project;
import com.demo.projectmanagmentsystem.repository.ProjectRepository;

import java.util.List;


@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    public List<Project> findProjectsByUserId(UUID userId) {
        return projectRepository.findAllByUserId(userId);
    }

    public Project findProjectById(UUID id) {
        return projectRepository.findById(id).orElse(null);
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(UUID id, Project project) {
        Project existingProject = projectRepository.findById(id).orElse(null);
        if (existingProject != null) 
        {
            existingProject.setName(project.getName());
            return projectRepository.save(existingProject);
        }
		return existingProject;
    }
}
