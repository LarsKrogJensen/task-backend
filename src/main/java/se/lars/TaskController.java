package se.lars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TaskController {
    private MongoTaskRepository repository;
//    private PgTaskRepository repository;

    @Autowired
    public TaskController(MongoTaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tasks")
    Flux<Task> getTasks() {
        return this.repository.findAll();
    }

    @GetMapping("/tasks/{id}")
    Mono<Task> getTask(@PathVariable long id) {
        return this.repository.findOne(id);
    }

    @GetMapping("/create")
    Mono<Task> create() {
        Task task = new Task(System.currentTimeMillis());
        return repository.save(task);
    }

    @PostMapping("/update")
    Mono<Task> update(@RequestBody Task task) {
        return repository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    Mono<Void> delete(@PathVariable long id) {
        return repository.delete(id);
    }
}

