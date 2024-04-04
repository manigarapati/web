package com.arcane.pfa.core.personalfinanceapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arcane.pfa.core.personalfinanceapplication.model.Budget;
import com.arcane.pfa.core.personalfinanceapplication.service.BudgetService;

@RestController
@RequestMapping("/budget")
@CrossOrigin("*") 
public class BudgetController {
	
	@Autowired
	BudgetService budgetService;
	
	@PostMapping
	public ResponseEntity<Budget> createBudget(@RequestBody Budget budget){
		Budget newBudget = budgetService.addBudget(budget);
		if(budget != null) {
			return ResponseEntity.ok(newBudget);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<Budget>> getBudget(@PathVariable Long userId){
		List<Budget> budgets = budgetService.getAllBudget(userId);
		if(userId != null) {
			return ResponseEntity.ok(budgets);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{budgetId}")
	public ResponseEntity<Budget> updateBudget(@PathVariable Long budgetId, @RequestBody Budget budget){
		Budget b =  budgetService.updateBudget(budgetId, budget);
		if(b != null) {
		return ResponseEntity.ok(b);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{budgetId}")
	public ResponseEntity<Object> deleteBudget(@PathVariable Long budgetId){
		 budgetService.deleteBudget(budgetId);
		 return ResponseEntity.noContent().build();
	}
	

	
}
