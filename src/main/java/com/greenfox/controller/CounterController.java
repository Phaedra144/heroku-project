package com.greenfox.controller;

import com.greenfox.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Szilvi on 2017. 05. 15..
 */
@RestController
public class CounterController {

    private AtomicLong counter = new AtomicLong(0);

    @RequestMapping(value="/greeting")
    public Greeting greeting (@RequestParam String name){
        long id = counter.incrementAndGet();
        return new Greeting("Hello " + name + "!");
    }
}
