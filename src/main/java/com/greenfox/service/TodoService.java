package com.greenfox.service;

import com.greenfox.model.Todo;
import com.greenfox.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Szilvi on 2017. 05. 05..
 */
@Component
public class TodoService {

    @Autowired
    TodoRepo todoRepo;

    public void updateTodosInfo(long id, String title, boolean isUrgent, boolean isDone) {
        Todo todo = todoRepo.findOne(id);
        todo.setTitle(title);
        todo.setDone(isDone);
        todo.setUrgent(isUrgent);
        todoRepo.save(todo);
    }
}
