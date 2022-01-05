package com.example.mongodbrelationship.repository;

import com.example.mongodbrelationship.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    List<User> findByName(String name);

    @Query("{'Address.city':?0}")
    List<User> findByCity(String city);
}