package com.arcane.pfa.core.personalfinanceapplication.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.arcane.pfa.core.personalfinanceapplication.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{
	List<Expense> findByUserIdAndDateBetween(Long userId, LocalDateTime startDate, LocalDateTime endDate);
	List<Expense> findByUserIdAndDateBetween(Long userId, Date startDate, Date endDate);
	
	List<Expense> findByUserIdAndAmountGreaterThan(Long userId, double threshold);
	
	@Query("SELECT e.category, MONTH(e.date), YEAR(e.date), AVG(e.amount) " +
            "FROM Expense e " +
            "WHERE e.userId = ?1 " +
            "GROUP BY e.category, MONTH(e.date), YEAR(e.date)")
	List<Expense> calculateAverageMonthlyExpenses(Long userId);
	
	List<Expense> findByUserId(long userId);
	
	List<Expense> findByUserIdAndDateBetween(long userId, LocalDate startDate, LocalDate endDate);
	
	@Query("SELECT SUM(e.amount) FROM Expense e WHERE e.userId = :userId AND e.date BETWEEN :startDate AND :endDate")
	Double findByUserIdAndDate(long userId, LocalDate startDate, LocalDate endDate);
	
//	 @Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e WHERE e.user.id = :userId AND YEAR(e.date) = :year AND MONTH(e.date) = :month")
//	Double getTotalExpensesForUserAndMonth(Long userId, YearMonth currentYearMonth);
	
	//List<Expense> findByUserIdAndMonthAndYear(Long userId, int month, int year);
	
	
	//all upcoming budget alerts for a user based on their current spending rate.
	@Query("SELECT COALESCE(SUM(e.amount), 0) FROM Expense e WHERE e.user.id = :userId AND e.budget.id = :budgetId")
    double getTotalSpentForBudget(@Param("userId") long userId, @Param("budgetId") long budgetId);
}
