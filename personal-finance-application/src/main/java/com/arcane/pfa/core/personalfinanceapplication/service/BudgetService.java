package com.arcane.pfa.core.personalfinanceapplication.service;

import java.util.List;

import com.arcane.pfa.core.personalfinanceapplication.model.Budget;

public interface BudgetService {
	Budget addBudget(Budget budget);
	List<Budget> getAllBudget(Long userId);
	Budget updateBudget(Long budgetId, Budget budget);
	void deleteBudget(Long budgetId);
	//List<Long> findUsersWithExceededBudget();
}
