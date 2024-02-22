package com.arcane.pfa.core.personalfinanceapplication.service;

import java.time.LocalDate;
import java.util.List;

import com.arcane.pfa.core.personalfinanceapplication.model.Expense;

public interface ExpenseService {
	Expense createExpense(Expense expense);
	 public List<Expense> getExpenses(Long userId, LocalDate startDate, LocalDate endDate);
	Expense updateExpense(Long expenseId, Expense expense);
	public void deleteExpense(Long expenseId);
}
