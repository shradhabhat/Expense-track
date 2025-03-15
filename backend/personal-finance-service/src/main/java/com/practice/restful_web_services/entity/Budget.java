package com.practice.restful_web_services.entity;
import java.time.YearMonth;
import java.util.List;

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
@Document(collection="budgets")
public class Budget {
    @Id
    private String id;
    private String userId;
    private double totalLimitAmount; 
    private double totalSpentAmount;
    private String yearMonth; 
    private List<CategoryBudget> categoryBudgets;
}
