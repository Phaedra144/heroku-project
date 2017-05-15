package com.greenfox.controller;

import com.greenfox.model.Todo;
import com.greenfox.repository.TodoRepo;
import com.greenfox.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ${SzilviaB} on 2016. 12. 20..
 */
@Controller
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    private TodoService todoService;

    private TodoRepo todoRepo;

    @Autowired
    public ToDoController(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    @RequestMapping(value = {"/", "/list"})
    public String list(Model model, @RequestParam(name = "isActive", defaultValue = "false") String isActive) {
        if (isActive != null && isActive.equalsIgnoreCase("true")) {
            model.addAttribute("todos", todoRepo.findAllByIsDoneIsFalse());
        } else if (isActive != null && isActive.equalsIgnoreCase("false")) {
            model.addAttribute("todos", todoRepo.findAllByIsDoneIsTrue());
        } else {
            model.addAttribute("todos", todoRepo.findAll());
        }
        return "todoslist";
    }

    @GetMapping("/add")
    public String addToDoForm(Model model) {
        model.addAttribute("addedTodo", new Todo());
        return "addTodo";
    }

    @PostMapping("/add2")
    public String todoSubmit(@ModelAttribute Todo todo) {
        todoRepo.save(todo);
        return "redirect:/todo/";
    }

    @RequestMapping(value = "/{id}/delete/", method = RequestMethod.GET)
    public String delete(@PathVariable long id) {
        todoRepo.delete(id);
        return "redirect:/todo/";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable long id,
                       Model model) {
        model.addAttribute("editedTodo", todoRepo.findOne(id));
        return "edittodo";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String saveAfterEdit(@PathVariable long id, String title,
                                 boolean isUrgent, boolean isDone) {
        todoService.updateTodosInfo(id, title, isUrgent, isDone);
        return "redirect:/todo/";
    }
}
