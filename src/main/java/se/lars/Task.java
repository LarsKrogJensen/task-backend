package se.lars;

import java.io.Serializable;

public class Task implements Serializable{
    private long id;
    private boolean completed;
    private String title;

    // required by jackson
    public Task() {
    }

    public Task(long id, boolean completed, String title) {
        this.id = id;
        this.completed = completed;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getTitle() {
        return title;
    }
}
//
//class CustomSerializer implements Serializer<Task>, Serializable {
//
//    @Override
//    public void serialize(DataOutput out, Task value) throws IOException {
//        out.writeUTF(value.getName());
//        out.writeUTF(value.getCity());
//    }
//
//    @Override
//    public Task deserialize(DataInput in, int available) throws IOException {
//        return new Task(in.readUTF(), in.readUTF());
//    }
//}