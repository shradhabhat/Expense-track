package com.practice.restful_web_services.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.restful_web_services.entity.Budget;
import com.practice.restful_web_services.entity.Category;
import com.practice.restful_web_services.entity.CategoryBudget;
@Repository
public interface CategoryBudgetRepository extends MongoRepository<CategoryBudget, String> {
	void deleteByCategory(Category category);
}