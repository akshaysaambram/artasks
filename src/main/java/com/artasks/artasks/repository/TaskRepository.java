package com.artasks.artasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.artasks.artasks.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
