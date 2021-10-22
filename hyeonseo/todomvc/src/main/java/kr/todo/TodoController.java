package kr.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("totalNumberOfItems", todoRepository.count());
        model.addAttribute("itemform", new TodoItemForm());
        model.addAttribute("totalItemList", todoRepository.findAll());
        return "index";
    }

    @PostMapping
    public String addTodo(@ModelAttribute("itemform") TodoItemForm itemForm){
        todoRepository.save(new TodoItem(itemForm.getTitle(), false));
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTodo(@PathVariable("id") Long id) {
        TodoItem todoItem = todoRepository.getById(id);
        todoItem.setCompleted(!todoItem.isCompleted());
        todoRepository.save(todoItem);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable("id") Long id) {
        todoRepository.deleteById(id);
        return "redirect:/";
    }

}
