package com.practice.restful_web_services.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection="Category_Budgets")
public class CategoryBudget {
    @Id
    private String id;
    private Category category;
    private double CategoryBudgetAmount;
    private double CategorySpentAmount;
}