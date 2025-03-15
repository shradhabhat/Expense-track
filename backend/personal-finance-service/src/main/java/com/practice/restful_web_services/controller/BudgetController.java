package com.practice.restful_web_services.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.practice.restful_web_services.entity.Budget;
import com.practice.restful_web_services.entity.CategoryBudget;
import com.practice.restful_web_services.service.BudgetService;

@RestController
@RequestMapping("/budget")
public class BudgetController {
	@Autowired
	private BudgetService service;

	public BudgetController(BudgetService service) {
		this.service = service;
	}
	@PostMapping
	public Budget createBudget(@RequestBody Budget budget,@RequestHeader("loggedInUser") String id) {
		budget.setUserId(id);
		return service.addOrupdadteMonthlyBudget(budget);
	}
	@PostMapping("/{budgetid}")
	public Budget addOrUpdatecategorybudget(@PathVariable String budgetid,@RequestBody CategoryBudget categoryBudget) {
		return service.addOrUpdateCategoryBudget(budgetid, categoryBudget);
	}

	@GetMapping("/getbymonth/{yearmonth}")
	public Budget getBudgetByMonth(@RequestHeader("loggedInUser") String id,@PathVariable String yearmonth){
		return service.getBudgetByUserAndMonth(id, yearmonth);
	}

	@DeleteMapping("/{id}")
	public void  deleteBudget(@PathVariable String id) {
		service.deleteBudget(id);
	}
	@PutMapping("/updatebudgetamount")
	public Budget updateBudgetAmount(@RequestBody Budget budget,@RequestHeader("loggedInUser") String id) {
		budget.setUserId(id);
		return service.addOrupdadteMonthlyBudget(budget);
	}
//	@PutMapping("/updatecategorybudget/{budgetid}")
//	public Budget updateTransaction(@PathVariable String budgetid,@RequestBody CategoryBudget categoryBudget) {
//		return service.addOrUpdateCategoryBudget(budgetid,categoryBudget);
//	}
	@DeleteMapping("/deletCategory/{budgetId}")
	public void  deleteBudget(@PathVariable String budgetId,@RequestBody CategoryBudget categoryBudget) {
		service.deleteCategoryBudget(budgetId, categoryBudget);
	}
	
	
}
