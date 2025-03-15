package com.practice.restful_web_services.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "categories")
public class CategoryEntity {

    @Id
    private String id;         // MongoDB-generated unique identifier
    private String name;       // e.g., "FOOD"
    private String iconClass;  // e.g., "fa-solid fa-utensils"

    // Constructor to initialize from the Category enum
    public CategoryEntity(String name, String iconClass) {
        this.name = name;
        this.iconClass = iconClass;
    }

    // Default no-args constructor is required by MongoDB
    public CategoryEntity() {}
}
