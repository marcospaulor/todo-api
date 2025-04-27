package com.marcospaulor.todo_api.service;

import com.marcospaulor.todo_api.model.Task;
import com.marcospaulor.todo_api.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService{

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    public Optional<Task> updateTask(Long id, Task updatedTask){
        return taskRepository.findById(id).map(task -> {
           task.setTitle(updatedTask.getTitle());
           task.setDescription(updatedTask.getDescription());
           task.setCompleted(updatedTask.isCompleted());
           return taskRepository.save(task);
        });
    }

    public boolean deleteTask(Long id){
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

