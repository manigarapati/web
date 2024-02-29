package com.arcane.pfa.core.personalfinanceapplication.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arcane.pfa.core.personalfinanceapplication.model.Goal;
@Repository
public interface GoalRepository extends JpaRepository<Goal, Long>{
	List<Goal> findByUserId(Long userId);
	 
	 @Query(value = "SELECT * FROM goal WHERE user_id = :userId AND end_date > :date", nativeQuery = true)
	    List<Goal> findByUserIdAndCompletionDateAfter(@Param("userId") long userId, @Param("date") LocalDate date);
	 
}
