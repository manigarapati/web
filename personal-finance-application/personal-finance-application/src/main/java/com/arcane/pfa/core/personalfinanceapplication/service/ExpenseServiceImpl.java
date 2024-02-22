package com.arcane.pfa.core.personalfinanceapplication.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcane.pfa.core.personalfinanceapplication.exception.ExpenseNotFoundException;
import com.arcane.pfa.core.personalfinanceapplication.exception.InvalidExpenseException;
import com.arcane.pfa.core.personalfinanceapplication.exception.UserNotFoundException;
import com.arcane.pfa.core.personalfinanceapplication.model.Expense;
import com.arcane.pfa.core.personalfinanceapplication.repository.ExpenseRepository;


@Service
public class ExpenseServiceImpl implements ExpenseService {
	@Autowired
	ExpenseRepository expenseRepository;
	
	@Autowired
	UserService userService;
	
	@Override
	public Expense createExpense(Expense expense) {
		// TODO Auto-generated method stub
		
		if (expense != null) {
			if(userService.getUser(expense.getUserId()) != null) {
			return expenseRepository.save(expense);
			}
			throw new UserNotFoundException("User not found!!1");
		}
		throw new InvalidExpenseException("Expense object cannot be null");
	}

	public List<Expense> getExpenses(Long userId, LocalDate startDate, LocalDate endDate) {
		if (userId == null || startDate == null || endDate == null) {
			throw new InvalidExpenseException("UserId, startDate, and endDate cannot be null");
		}
		Timestamp startTimestamp = new Timestamp(startDate.atStartOfDay().getNano());
		Timestamp endTimestamp = new Timestamp(endDate.atStartOfDay().getNano());
			return expenseRepository.findByUserIdAndDateBetween(userId, startTimestamp, endTimestamp);
		
	}

	public Optional<Expense> getExpense(Long expenseId) {
		return expenseRepository.findById(expenseId);
	}

	@Override
	public Expense updateExpense(Long expenseId, Expense updatedExpense) {
		if (expenseId == null || updatedExpense == null) {
			throw new InvalidExpenseException("ExpenseId and updatedExpense cannot be null");
		}
		Expense existingExpense = expenseRepository.findById(expenseId).orElse(null);
			if(existingExpense == null)	{
				throw new ExpenseNotFoundException("Expense not found !!");
			}
		existingExpense.setCategory(updatedExpense.getCategory());
		existingExpense.setAmount(updatedExpense.getAmount());
		existingExpense.setDate(updatedExpense.getDate());
		existingExpense.setDescription(updatedExpense.getDescription());
		return expenseRepository.save(existingExpense);
	}

	public void deleteExpense(Long expenseId) {
		if (expenseId == null) {
			throw new InvalidExpenseException("ExpenseId cannot be null");
		}
		Expense expense = expenseRepository.findById(expenseId).orElse(null);
		if(expense == null) {
			
			throw new ExpenseNotFoundException("No Expense found using the ExpenseId");
		}
		expenseRepository.deleteById(expenseId);
	}

}
