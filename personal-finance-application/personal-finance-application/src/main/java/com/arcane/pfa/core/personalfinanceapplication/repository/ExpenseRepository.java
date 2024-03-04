package com.arcane.pfa.core.personalfinanceapplication.repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arcane.pfa.core.personalfinanceapplication.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{
	List<Expense> findByUserIdAndDateBetween(Long userId, Timestamp startDate, Timestamp endDate);
}
