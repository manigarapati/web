package com.arcane.pfa.core.personalfinanceapplication.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arcane.pfa.core.personalfinanceapplication.model.Expense;
import com.arcane.pfa.core.personalfinanceapplication.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;
	
	@PostMapping
	public ResponseEntity<Expense> createExpense(@RequestBody  Expense expense){
		Expense newExpense = expenseService.createExpense(expense);
		if(newExpense != null) {
			return ResponseEntity.ok(newExpense);
		}
		return ResponseEntity.badRequest().build();
	}
	
	 @GetMapping
	    public ResponseEntity<List<Expense>> getExpenses(@RequestParam Long userId,
	                                                     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
	                                                     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
	        List<Expense> expenses = expenseService.getExpenses(userId, startDate, endDate);
	        if(expenses != null) {
		        return ResponseEntity.ok(expenses);
		        }
		        return ResponseEntity.notFound().build();
	    }
	
	
	 @PutMapping("/{expenseId}")
	    public ResponseEntity<Expense> updateExpense(@PathVariable Long expenseId,
	                                                 @RequestBody Expense expense) {
	        Expense newExpense = expenseService.updateExpense(expenseId, expense);
	        if(newExpense != null) {
	        return ResponseEntity.ok(newExpense);
	        }
	        return ResponseEntity.notFound().build();
	    }
	 
	 @DeleteMapping("/{expenseId}")
	    public ResponseEntity<Void> deleteExpense(@PathVariable Long expenseId) {
	        expenseService.deleteExpense(expenseId);
	        return ResponseEntity.noContent().build();
	    }
}
