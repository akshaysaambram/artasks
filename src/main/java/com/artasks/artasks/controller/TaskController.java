package com.artasks.artasks.controller;

import org.springframework.web.bind.annotation.RestController;

import com.artasks.artasks.models.Task;
import com.artasks.artasks.service.TaskService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    @ResponseBody
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("/tasks")
    @ResponseBody
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/tasks/{id}")
    @ResponseBody
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/tasks")
    @ResponseBody
    public Task updateTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PatchMapping("/tasks/{id}")
    @ResponseBody
    public Task patchTask(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Task task = taskService.getTaskById(id).orElse(null);

        if (task != null) {
            if (updates.containsKey("title")) {
                task.setTitle(updates.get("title").toString());
            }
            if (updates.containsKey("completed")) {
                task.setCompleted((Boolean) updates.get("completed"));
            }

            return taskService.createTask(task);
        }

        return null;
    }

    @DeleteMapping("/tasks/{id}")
    @ResponseBody
    public Boolean deleteTaskById(@PathVariable Long id) {
        return taskService.deleteTaskById(id);
    }

}
