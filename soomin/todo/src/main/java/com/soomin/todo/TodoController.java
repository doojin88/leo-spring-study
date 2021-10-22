package com.soomin.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class TodoController {
    private final TodoItemRepository repository;

    public TodoController(TodoItemRepository repository){
        this.repository=repository;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("item",new TodoItemFormData());
        model.addAttribute("totalNumberOfItems",repository.count());
        return "index";
    }


    @PostMapping
    public String addNewTodoItem(@Valid @ModelAttribute("item") TodoItemFormData formData){
        repository.save(new TodoItem(formData.getTitle(),false));
        return "redirect:/";
    }
}


