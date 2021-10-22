package com.wimdeblauwe.examples.todomvcthymeleaf.controller;

import com.wimdeblauwe.examples.todomvcthymeleaf.entity.TodoItem;
import com.wimdeblauwe.examples.todomvcthymeleaf.entity.TodoItemFormData;
import com.wimdeblauwe.examples.todomvcthymeleaf.entity.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @GetMapping("/index")
    public String index() {
        return "redirect:/";
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("newitem", new TodoItemFormData());
        model.addAttribute("todos", getTodoItems());
        model.addAttribute("totalNumberOfItems", todoRepository.count());
        model.addAttribute("numberOfActiveItems", getNumberOfActiveItems());
        return "index";
    }

    @PostMapping
    public String addNewTodoItem(@Valid @ModelAttribute("item") TodoItemFormData formData) {
        todoRepository.save(new TodoItem(formData.getTitle(), false));

        return "redirect:/";
    }

    @PutMapping("/{id}/toggle")
    public String toggleSelection(@PathVariable("id") Long id) throws Exception {
        TodoItem todoItem = todoRepository.findById(id)
                .orElseThrow(() -> new Exception());

        todoItem.setCompleted(!todoItem.isCompleted());
        todoRepository.save(todoItem);
        return "redirect:/";
    }

    @DeleteMapping("/")
    public String deleteTodoItem(@RequestParam("id") Long id) {
        todoRepository.deleteById(id);

        return "redirect:/";
    }

    private List<TodoItem> getTodoItems() {
        return todoRepository.findAll();
    }

    private int getNumberOfActiveItems() {
        return todoRepository.countAllByCompleted(false);
    }
}
