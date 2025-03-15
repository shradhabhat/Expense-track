package com.practice.restful_web_services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.practice.restful_web_services.entity.Budget;
@Repository
public interface BudgetRepository extends MongoRepository<Budget, String> {
	//@Query("{'userId':?0,'yearMonth':?1}")
	Budget findBudgetByUserIdAndYearMonth(String userId, String yearMonth);
}