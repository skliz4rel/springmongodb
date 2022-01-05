package com.example.mongodbrelationship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongodbrelationshipApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbrelationshipApplication.class, args);
    }

}
