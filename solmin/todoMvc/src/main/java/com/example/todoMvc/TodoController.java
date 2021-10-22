package com.example.todoMvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class TodoController {
    private final TodoItemRepository repository;

    public TodoController(TodoItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String index(Model model){  //
        model.addAttribute("item",new TodoItemFormData());
        model.addAttribute("todos",getTodoItems());
        model.addAttribute("totalNumberOfItems",repository.count());
        model.addAttribute("numberOfActiveItems",getNumberOfActiveItems());
        return "index";
    }

    private List<TodoItemDto> getTodoItems(){
        return repository.findAll()
                .stream()
                .map(todoItem -> new TodoItemDto(todoItem.getId(),
                                    todoItem.getTitle(),
                                    todoItem.isComleted()))
                .collect(Collectors.toList());
    }

    public static record TodoItemDto(long id, String title, boolean completed){

    }

    @PostMapping
    public String addNewTodoItem(@Valid @ModelAttribute("item") TodoItemFormData formData){
        repository.save(new TodoItem(formData.getTitle(),false));
        return "redirect:/";
    }

    @PutMapping("/{id}/toggle")
    public String toggleSelection(@PathVariable("id") Long id){
        TodoItem todoItem = repository.findById(id)
                .orElseThrow(()-> new TodoItemNotFoundException(id));
        todoItem.setComleted(!todoItem.isComleted());
        repository.save(todoItem);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteTodoItem(@PathVariable Long id){
        repository.deleteById(id);
        return "redirect:/";
    }

    private int getNumberOfActiveItems(){
        return repository.countAllByCompleted(false);
    }
}
