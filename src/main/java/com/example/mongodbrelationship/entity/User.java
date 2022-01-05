package com.example.mongodbrelationship.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection="order_DB")
@AllArgsConstructor
public class User {

    @Id
    //@Generated//(strategy = GenerationType.AUTO)
    private String id;

    private String name;

    private String gender;

    //relationships below
    private List<Product> products; //one to many

    //@DBRef
    private Address address;  //One to one
}
