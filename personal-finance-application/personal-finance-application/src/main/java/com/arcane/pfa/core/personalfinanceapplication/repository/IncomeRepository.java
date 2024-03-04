package com.arcane.pfa.core.personalfinanceapplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arcane.pfa.core.personalfinanceapplication.model.Income;

public interface IncomeRepository extends JpaRepository<Income, Long> {
	List<Income> findByUserId(Long userId);
}
