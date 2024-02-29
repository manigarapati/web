package com.arcane.pfa.core.personalfinanceapplication.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.arcane.pfa.core.personalfinanceapplication.model.Budget;
@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long>{
	List<Budget> findByUserId(Long userId);

	
	
}
