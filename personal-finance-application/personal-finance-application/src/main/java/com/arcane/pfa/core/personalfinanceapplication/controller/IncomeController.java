package com.arcane.pfa.core.personalfinanceapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arcane.pfa.core.personalfinanceapplication.model.Income;
import com.arcane.pfa.core.personalfinanceapplication.model.IncomeProjection;
import com.arcane.pfa.core.personalfinanceapplication.service.IncomeService;

@RestController
@RequestMapping("/income")
public class IncomeController {
	
	@Autowired
	IncomeService incomeService;
	
	@PostMapping
	public ResponseEntity<Income> createIncome(@RequestBody Income income) {
		Income newIncome = incomeService.addIncome(income);
		if(newIncome != null) {
			return ResponseEntity.ok(newIncome);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<Income>> getIncome(@PathVariable Long userId){
		if(userId != null) {
		List<Income> income = incomeService.getIncome(userId);
			return ResponseEntity.ok(income);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/incomeProjection")
    public ResponseEntity<List<IncomeProjection>> calculateIncomeProjection(@RequestParam Long userId,
                                                                @RequestParam int years) {
        // Add validation here if necessary
        List<IncomeProjection> projectedIncome = incomeService.calculateIncomeProjection(userId, years);
        return ResponseEntity.ok(projectedIncome);
    }

}
