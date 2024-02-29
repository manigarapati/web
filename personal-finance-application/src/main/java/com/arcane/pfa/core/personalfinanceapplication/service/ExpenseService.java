package com.arcane.pfa.core.personalfinanceapplication.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.cglib.core.Local;

import com.arcane.pfa.core.personalfinanceapplication.model.Expense;

public interface ExpenseService {
	Expense createExpense(Expense expense);
	List<Expense> getExpenses(Long userId, String startDate, String endDate);
	Expense updateExpense(Long expenseId, Expense expense);
    void deleteExpense(Long expenseId);
    List<Expense> getMonthlyExpenseSummary(Long userId);
    List<Expense> getExpensesAboveThreshold(Long userId, Double amount);
	Map<String, Double> calculateAverageMonthlyExpenses(Long userId);
	List<String> getTopExpenseCategories(long userId);
	Map<Integer, Double> getWeeklyExpenseBreakdown(long userId, int year, int month);
	double getExpensesForMonthAndYear(long userId, int month, int year);
	double getMonthOverMonthChange(long userId);
}
