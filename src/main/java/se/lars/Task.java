package se.lars;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
public class Task {
    @Id
    private long id;
    private String title;
    private boolean completed;

    public Task() {
    }

    public Task(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }
}
//@Value.Immutable
//@Document(collection = "tasks")
//@JsonSerialize(as = ImmutableTask.class)
//@JsonDeserialize(as = ImmutableTask.class)
//public interface Task {
//    @Id
//    @Value.Parameter
//    String id();
//
//    @Value.Parameter
//    boolean completed();
//
//    Optional<String> title();
//}
