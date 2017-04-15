package se.lars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
public class TaskController {
    private TaskRepository repository;

    @Autowired
    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tasks")
    Flux<Task> getTasks() {
        return this.repository.tasks();
    }

    @GetMapping("/tasks/{id}")
    Mono<Task> getTask(@PathVariable long id) {
        return this.repository.task(id);
    }

    @GetMapping("/create")
    Mono<Task> create() {
        return repository.newTask();
    }

    @PostMapping("/update")
    Mono<Void> update(@RequestBody Task task) {
        return repository.update(task);
    }

    @DeleteMapping("/tasks/{id}")
    Mono<Void> delete(@PathVariable long id) {
        return repository.delete(id);
    }
}

