package com.example.tasks.services;

import com.example.tasks.domain.entities.TaskList;
import com.example.tasks.repositories.TaskListRepository;

import java.util.List;

public interface TaskListService {
    List<TaskList> listTaskLists();
}
