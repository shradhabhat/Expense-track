package com.practice.restful_web_services.service;

import org.springframework.stereotype.Service;

import com.practice.restful_web_services.entity.Budget;
import com.practice.restful_web_services.entity.CategoryBudget;
@Service
public interface BudgetService {
	public Budget saveMonthlyBudget(Budget budget);
	public Budget getMonthlyBudget(String id);
	public Budget getBudgetByUserAndMonth(String userId,String yearMonth);
	public void deleteBudget(String id);
	Budget addOrUpdateCategoryBudget(String budgetId, CategoryBudget categoryBudget);
	public void deleteCategoryBudget(String budgetId, CategoryBudget categoryBudget);
	Budget addOrupdadteMonthlyBudget(Budget budget);
}
