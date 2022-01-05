package com.example.mongodbrelationship.config;

import com.example.mongodbrelationship.entity.Address;
import com.example.mongodbrelationship.entity.Gender;
import com.example.mongodbrelationship.entity.Student;
import com.example.mongodbrelationship.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Configuration
public class BoostrapData {

    @Bean
    CommandLineRunner runner  (StudentRepository studentRepository, MongoTemplate mongoTemplate){


        return args -> {
            String email = "skliz4rel@gmail.com";

            Address address = new Address("England", "London", "NW9");

            Student student = new Student(
                    "Jamila", "Ahmed",email, Gender.FEMALE,address,
                    List.of("Computer Science"), BigDecimal.TEN, LocalDateTime.now()
            );


            Query query = new Query();
            query.addCriteria(Criteria.where("email").is(email));

            List<Student> students = mongoTemplate.find(query, Student.class);

            if(students.size() > 1){
                throw new IllegalStateException("found many students with email "+email);
            }

            if(students.isEmpty()){

                System.out.println("inserting students");
                studentRepository.insert(student);
            }
            else{
                System.out.println("Student already exits");
            }

        };

    }


    public void approach2(String email, StudentRepository studentRepository, Student student){

        studentRepository.findStudentByEmail(email)
                .ifPresentOrElse(s-> {
                            System.out.println(s + "already exits ");
                        },
                        () -> {

                            System.out.println("Inserting student "+student);
                            studentRepository.insert(student);

                        });
    }
}
