package com.artasks.artasks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artasks.artasks.models.Task;
import com.artasks.artasks.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepo;

    public List<Task> getTasks() {
        return taskRepo.findAll();
    }

    public Task createTask(Task task) {
        if (task != null) {
            return taskRepo.save(task);
        }

        return null;
    }

    public Optional<Task> getTaskById(Long id) {
        if (id != null) {
            return taskRepo.findById(id);
        }

        return null;
    }

    public Boolean deleteTaskById(Long id) {
        if (id != null) {
            taskRepo.deleteById(id);
            return true;
        }

        return false;
    }

}
