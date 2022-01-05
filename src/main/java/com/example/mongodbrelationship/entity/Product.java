package com.example.mongodbrelationship.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private int quantity;
    private BigDecimal price;
}
