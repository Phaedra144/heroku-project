package com.greenfox.repository;

import com.greenfox.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Szilvi on 2017. 05. 04..
 */
@Component
public interface TodoRepo extends CrudRepository<Todo, Long> {
    List<Todo>findAllByIsDoneIsFalse();
    List<Todo>findAllByIsDoneIsTrue();
}
