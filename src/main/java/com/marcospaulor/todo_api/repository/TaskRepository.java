package com.marcospaulor.todo_api.repository;

import com.marcospaulor.todo_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long>{
}
