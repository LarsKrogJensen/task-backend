package se.lars;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TaskRepository {

    private Map<Long, Task> tasks = new HashMap<>();
    private final DB db;

    public TaskRepository() {
        db = DBMaker.fileDB("file.db").make();
        tasks = (Map<Long, Task>) db.hashMap("tasks")
//                  .keySerializer(Serializer.LONG)
//                  .valueSerializer()
                                    .createOrOpen();
    }

    @PreDestroy
    public void close() {
        db.close();
    }

    public Mono<Task> newTask() {
        Task task = new Task(System.currentTimeMillis(), false, null);
        tasks.put(task.getId(), task);
        return Mono.just(task);
    }

    public Flux<Task> tasks() {
        return Flux.fromIterable(tasks.values());
    }

    public Mono<Void> update(Task task) {
        if (tasks.containsKey(task.getId()))
            tasks.put(task.getId(), task);
        return Mono.empty();
    }

    public Mono<Void> delete(long id) {
        tasks.remove(id);
        return Mono.empty();
    }

    public Mono<Task> task(long id) {
        Task task = tasks.get(id);

        return task != null ? Mono.just(task) : Mono.empty();
    }
}
