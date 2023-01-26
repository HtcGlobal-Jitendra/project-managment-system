package com.demo.projectmanagmentsystem.service;

import java.util.UUID;
import org.springframework.stereotype.Service;

import com.demo.projectmanagmentsystem.model.Project;
import com.demo.projectmanagmentsystem.repository.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project getProjectById(UUID id) {
        return projectRepository.findById(id).orElse(null);
    }

    public Project updateProject(UUID id, Project updatedProject) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project != null) {
            project.setName(updatedProject.getName());
            return projectRepository.save(project);
        }
        return null;
    }

    public void deleteProject(UUID id) {
        projectRepository.deleteById(id);
    }
}

