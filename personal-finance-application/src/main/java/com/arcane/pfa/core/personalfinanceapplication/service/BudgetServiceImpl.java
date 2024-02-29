package com.arcane.pfa.core.personalfinanceapplication.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcane.pfa.core.personalfinanceapplication.exception.BudgetNotFoundException;
import com.arcane.pfa.core.personalfinanceapplication.exception.InvalidBudgetException;
import com.arcane.pfa.core.personalfinanceapplication.exception.UserNotFoundException;
import com.arcane.pfa.core.personalfinanceapplication.model.Budget;
import com.arcane.pfa.core.personalfinanceapplication.repository.BudgetRepository;
import com.arcane.pfa.core.personalfinanceapplication.repository.ExpenseRepository;

@Service
public class BudgetServiceImpl implements BudgetService {

	@Autowired
	BudgetRepository budgetRepository;

	@Autowired
	UserService userService;

	@Override
	public Budget addBudget(Budget budget) {
		// TODO Auto-generated method stub
		if (userService.getUser(budget.getUserId()) != null) {
			return budgetRepository.save(budget);
		}
		throw new UserNotFoundException("you are not an Existing user to create an Budget source/Create an user account");
	}

	@Override
	public List<Budget> getAllBudget(Long userId) {
		if (userId != null) {
			return budgetRepository.findByUserId(userId);
		}
		throw new UserNotFoundException("your Budget is not exist, Create an Budget to get information !!!");
	}

	@Override
	public Budget updateBudget(Long budgetId, Budget budget) {
		// TODO Auto-generated method stub
		if (budgetId == null || budget == null) {
			throw new InvalidBudgetException("BudgetId or Budget can not be Null !!!");
		}
		Budget existingBudget = budgetRepository.findById(budgetId).orElse(null);
		if (existingBudget == null) {
			throw new BudgetNotFoundException("your Budget is not exist, Create an Budget to update !!! ");
		}
		existingBudget.setCategory(budget.getCategory());
		existingBudget.setAmount(budget.getAmount());
		existingBudget.setStartDate(budget.getStartDate());
		existingBudget.setEndDate(budget.getEndDate());
		return budgetRepository.save(existingBudget);
	}

	@Override
	public void deleteBudget(Long budgetId) {
		// TODO Auto-generated method stub
		if (budgetId == null) {
			throw new InvalidBudgetException("Id cannot be null, p");
		}
		Budget budget = budgetRepository.findById(budgetId).orElse(null);
		if (budget == null) {

			throw new BudgetNotFoundException("No Expense found using your Id");
		}
		budgetRepository.deleteById(budgetId);
	}
	

	    

}
