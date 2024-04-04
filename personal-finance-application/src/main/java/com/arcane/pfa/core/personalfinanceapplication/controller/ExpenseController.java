package com.arcane.pfa.core.personalfinanceapplication.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.arcane.pfa.core.personalfinanceapplication.model.Expense;
import com.arcane.pfa.core.personalfinanceapplication.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
@CrossOrigin("*") 
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
	
	 @GetMapping("/range/{userId}")
	    public ResponseEntity<List<Expense>> getExpenses(@PathVariable Long userId,
	    		@RequestParam(name =  "startDate", required = true)  String startDate,
	    		@RequestParam(name = "endDate", required = true)  String endDate) {
		 LocalDateTime startDateTime = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE).atStartOfDay();
	        LocalDateTime endDateTime = LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE).atTime(LocalTime.MAX);
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
	 
	 @GetMapping("/monthly-summary/{userId}")
	 public ResponseEntity<List<Expense>> getExpenses(@PathVariable Long userId) {
		 List<Expense> expenses = expenseService.getMonthlyExpenseSummary(userId);
	        if(expenses != null) {
		        return ResponseEntity.ok(expenses);
		        }
		        return ResponseEntity.notFound().build();
	 }
	 
	 @GetMapping("/threshold/{userId}")
	    public List<Expense> getExpensesAboveThreshold(
	            @PathVariable Long userId,
	            @RequestParam Double amount) {
	        return expenseService.getExpensesAboveThreshold(userId,amount );
	    }
	 
	 @GetMapping("/average-monthly/{userId}")
	    public ResponseEntity<Map<String, Double>> getAverageMonthlyExpenses(@PathVariable Long userId) {
	        Map<String, Double> averageMonthlyExpenses = expenseService.calculateAverageMonthlyExpenses(userId);
	        return ResponseEntity.ok().body(averageMonthlyExpenses);
	    }
	 
	 @GetMapping("/top-categories/{userId}")
	    public ResponseEntity<List<String>> getTopExpenseCategories(@PathVariable long userId) {
	        List<String> topCategories = expenseService.getTopExpenseCategories(userId);
	        return new ResponseEntity<>(topCategories, HttpStatus.OK);
	    }
	 
	 @GetMapping("/weekly-breakdown/{userId}")
	    public ResponseEntity<Map<Integer, Double>> getWeeklyExpenseBreakdown(
	            @PathVariable long userId,
	            @RequestParam int month,
	            @RequestParam int year) {
	        
	        Map<Integer, Double> weeklyBreakdown = expenseService.getWeeklyExpenseBreakdown(userId, year, month);
	        return new ResponseEntity(weeklyBreakdown, HttpStatus.OK);
	    }
	 
	 @GetMapping("/month-over-month-change/{userId}")
	    public ResponseEntity<Double> getMonthOverMonthChange(@PathVariable long userId) {
	        double monthOverMonthChange = expenseService.getMonthOverMonthChange(userId);
	        return new ResponseEntity<>(monthOverMonthChange, HttpStatus.OK);
	    }
}
