package com.arcane.pfa.core.personalfinanceapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arcane.pfa.core.personalfinanceapplication.model.Alert;
@Repository
public interface AlertRepository extends JpaRepository<Alert, Long>{
	List<Alert> findByUserId(Long userId);
}
