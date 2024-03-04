package com.arcane.pfa.core.personalfinanceapplication.service;

import java.util.List;

import com.arcane.pfa.core.personalfinanceapplication.model.Income;
import com.arcane.pfa.core.personalfinanceapplication.model.IncomeProjection;

public interface IncomeService {
	Income addIncome(Income income);
	List<Income> getIncome(Long userId);
	List<IncomeProjection> calculateIncomeProjection(Long userId, int years);
}
