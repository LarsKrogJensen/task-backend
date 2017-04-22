//package se.lars;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Repository;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//@Repository
//public class PgTaskRepository {
//    private final NamedParameterJdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public PgTaskRepository(NamedParameterJdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//
//    public Flux<Task> findAll() {
//        return null;
//    }
//
//    public Mono<Task> findOne(long id) {
//        return null;
//    }
//
//    public Mono<Task> save(Task task) {
//        return null;
//    }
//
//    public Mono<Void> delete(long id) {
//        return null;
//    }
//}
