package com.greenfox.repository;

import com.greenfox.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Szilvi on 2017. 05. 09..
 */
public interface UserRepo extends CrudRepository<User,Long> {
}
