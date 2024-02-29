package com.arcane.pfa.core.personalfinanceapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcane.pfa.core.personalfinanceapplication.exception.UserNotFoundException;
import com.arcane.pfa.core.personalfinanceapplication.model.Income;
import com.arcane.pfa.core.personalfinanceapplication.model.IncomeProjection;
import com.arcane.pfa.core.personalfinanceapplication.repository.IncomeRepository;

@Service
public class IncomeServiceImpl implements IncomeService{
	
	@Autowired
	IncomeRepository incomeRepository;
	@Autowired
	UserService userService;
	@Override
	public Income addIncome(Income income) {
		// TODO Auto-generated method stub
		if(userService.getUser(income.getUserId()) != null) {
			return incomeRepository.save(income);
		}
		throw new UserNotFoundException("you are not an Existing user to create an income source/Create an user account");
	}
	@Override
	public List<Income> getIncome(Long userId) {
		// TODO Auto-generated method stub
		return incomeRepository.findByUserId(userId);
	}
	@Override
	public List<IncomeProjection> calculateIncomeProjection(Long userId, int years) {
		// TODO Auto-generated method stub
		List<IncomeProjection> projections = new ArrayList<>();
		List<Income> incomes = getIncome(userId);
		Double totalIncome = 0d;
		for(Income income:incomes) {
			if("Annually".equals(income.getFrequency())) {
			totalIncome = totalIncome + income.getAmount();
			} 
			if("Monthly".equals(income.getFrequency())) {
				totalIncome = totalIncome + (income.getAmount()*12);
			}
		}
		
		for(int i=1;i<=years;i++) {
			IncomeProjection projection = new IncomeProjection();
			projection.setYear(i);
			projection.setGrowthRate(3d);
			 totalIncome = totalIncome * 1.03;
			 projection.setProjectedAmount(totalIncome);
			 projections.add(projection);
		}
		
		return projections;
	}
	
	

}
