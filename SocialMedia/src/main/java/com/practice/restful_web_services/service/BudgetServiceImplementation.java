package com.practice.restful_web_services.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import com.practice.restful_web_services.entity.Budget;
import com.practice.restful_web_services.entity.CategoryBudget;
import com.practice.restful_web_services.exception.ApplicationException;
import com.practice.restful_web_services.repository.BudgetRepository;
import com.practice.restful_web_services.repository.CategoryBudgetRepository;
@Service
public class BudgetServiceImplementation implements BudgetService{
	@Autowired
	BudgetRepository budgetRepository;
	
	@Autowired
	CategoryBudgetRepository categoryBudgetRepository;
	
	@Override
	public Budget saveMonthlyBudget(Budget budget) {
		budgetRepository.save(budget);
		return budget;
	}

	@Override
	public Budget getMonthlyBudget(String id) {
		return budgetRepository.findById(id).orElseThrow(()->new ApplicationException("Budget Not Found"));
	}

	@Override
	public Budget getBudgetByUserAndMonth(String userId, String yearMonth) {
		return budgetRepository.findBudgetByUserIdAndYearMonth(userId,yearMonth);
	}

	@Override
	public Budget addOrupdadteMonthlyBudget(Budget newBudget) {
//	   if (newBudget.getId() == null) {
//	        return budgetRepository.save(newBudget);
//	    }
		Budget existingBudget= budgetRepository.findBudgetByUserIdAndYearMonth(newBudget.getUserId(),newBudget.getYearMonth());
		if(existingBudget!=null) {
			existingBudget.setUserId(newBudget.getUserId());
			existingBudget.setYearMonth(newBudget.getYearMonth());
			existingBudget.setTotalLimitAmount(newBudget.getTotalLimitAmount());
			existingBudget.setTotalSpentAmount(newBudget.getTotalSpentAmount());
			existingBudget.setCategoryBudgets(newBudget.getCategoryBudgets());
			return budgetRepository.save(existingBudget);
		}
		else {
			return budgetRepository.save(newBudget);
		}
		
	}

	@Override
	public void deleteBudget(String id) {
		Budget existingBudget=budgetRepository.findById(id).orElseThrow(()->new ApplicationException("Budget Not Found"));
		budgetRepository.delete(existingBudget);
	}

	@Override
	public Budget addOrUpdateCategoryBudget(String budgetId, CategoryBudget newCategoryBudget) {
	    Budget budget = budgetRepository.findById(budgetId)
	            .orElseThrow(() -> new RuntimeException("Budget not found"));
	    
	    // Initialize the categoryBudgets list if it's null
	    if (budget.getCategoryBudgets() == null) {
	        budget.setCategoryBudgets(new ArrayList<>());
	    }
	    
	    // Check if a category budget with the same category exists
	    Optional<CategoryBudget> existing = budget.getCategoryBudgets().stream()
	            .filter(cb -> cb.getCategory().equals(newCategoryBudget.getCategory()))
	            .findFirst();
	    
	    if (existing.isPresent()) {
	        // Update the existing entry
	        CategoryBudget updated = existing.get();
	        updated.setCategoryBudgetAmount(newCategoryBudget.getCategoryBudgetAmount());
	        updated.setCategorySpentAmount(newCategoryBudget.getCategorySpentAmount());
	    } else {
	        // Add new category budget
	        budget.getCategoryBudgets().add(newCategoryBudget);
	    }
	    
	    return budgetRepository.save(budget);
	}
	

	@Override
	public void deleteCategoryBudget(String budgetId, CategoryBudget categoryBudget) {
		  String categoryName=categoryBudget.getCategory().toString();
		  Budget budget = budgetRepository.findById(budgetId)
		            .orElseThrow(() -> new RuntimeException("Budget not found"));
		    
		    // Ensure the list is initialized
		    if (budget.getCategoryBudgets() == null) {
		        throw new RuntimeException("No category budgets to delete.");
		    }
		    
		    // Remove the CategoryBudget that matches the given category name.
		    boolean removed = budget.getCategoryBudgets().removeIf(
		            cb -> cb.getCategory().name().equalsIgnoreCase(categoryName)
		    );
		    
		    if (!removed) {
		        throw new RuntimeException("Category budget not found for category: " + categoryName);
		    }
		    
		     budgetRepository.save(budget);
	}
}
