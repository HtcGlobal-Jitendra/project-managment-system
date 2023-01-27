package com.demo.projectmanagmentsystem.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.demo.projectmanagmentsystem.model.Task;
import com.demo.projectmanagmentsystem.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTaskById(UUID id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task updateTask(UUID id, Task updatedTask) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            task.setProject(updatedTask.getProject());
            task.setUser(updatedTask.getUser());
            return taskRepository.save(task);
        }
		return task;
    }
    public void deleteTask(UUID id) {
        taskRepository.deleteById(id);
    }
}
