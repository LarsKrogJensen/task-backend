package se.lars;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .registerModule(new Jdk8Module());
    }

//    @Bean(initMethod = "migrate")
//    public Flyway flyway(DataSource dataSource) {
//        final Flyway flyway = new Flyway();
//        flyway.setDataSource(dataSource);
//        return flyway;
//    }
}

