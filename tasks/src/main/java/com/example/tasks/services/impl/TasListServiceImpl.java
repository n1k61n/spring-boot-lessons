package com.example.tasks.services.impl;

import com.example.tasks.domain.entities.TaskList;
import com.example.tasks.repositories.TaskListRepository;
import com.example.tasks.services.TaskListService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TasListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    public TasListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepository.findAll();
    }
}
