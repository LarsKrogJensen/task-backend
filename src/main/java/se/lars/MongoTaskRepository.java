package se.lars;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface MongoTaskRepository extends ReactiveMongoRepository<Task, Long> {
}
