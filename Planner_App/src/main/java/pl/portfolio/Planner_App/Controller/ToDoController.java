package pl.portfolio.Planner_App.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.portfolio.Planner_App.Model.Dto.CreateToDoDto;
import pl.portfolio.Planner_App.Service.ToDoService;

@RestController
@RequestMapping("api/v1/todos")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping("/all")
    public ResponseEntity getAllToDos() {
        return ResponseEntity.ok(toDoService.getAllToDos());
    }

    @GetMapping("/done")
    public ResponseEntity getDoneToDos() {
        return ResponseEntity.ok(toDoService.getToDosByStatus("done"));
    }

    @GetMapping("/doing")
    public ResponseEntity getUndoneToDos() {
        return ResponseEntity.ok(toDoService.getToDosByStatus("doing"));
    }

    @GetMapping("/todo")
    public ResponseEntity getToDoToDos() {
        return ResponseEntity.ok(toDoService.getToDosByStatus("todo"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteToDoById(Long id) {
        toDoService.deleteToDo(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getToDoById(Long id) {
        return ResponseEntity.ok(toDoService.getToDoById(id));
    }

    @GetMapping("/create")
    public ResponseEntity createToDo(@RequestBody CreateToDoDto createToDoDto) {
        return ResponseEntity.ok(toDoService.createToDo(createToDoDto));
    }
}
