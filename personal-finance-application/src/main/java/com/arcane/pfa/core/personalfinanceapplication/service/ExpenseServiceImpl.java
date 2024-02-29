package com.arcane.pfa.core.personalfinanceapplication.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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

	@Override //create
	public Expense createExpense(Expense expense) {
		// TODO Auto-generated method stub

		if (expense != null) {
			if (userService.getUser(expense.getUserId()) != null) {
				return expenseRepository.save(expense);
			}
			throw new UserNotFoundException(
					"you are not an Existing user to create an Expense source/Create an user account");
		}
		throw new InvalidExpenseException("Expense object cannot be null");
	}

	@Override //get expense from a range
	public List<Expense> getExpenses(Long userId, String startDateStr, String endDateStr) {
		if (userId == null || startDateStr == null || endDateStr == null) {
			throw new InvalidExpenseException("UserId, startDate, and endDate cannot be null");
		}
		LocalDate startDate = LocalDate.parse(startDateStr);
		LocalDate endDate = LocalDate.parse(endDateStr);

		// Convert LocalDate to LocalDateTime (with time at start of day)
		LocalDateTime startDateTime = startDate.atStartOfDay();
		LocalDateTime endDateTime = endDate.atStartOfDay().plusDays(1);
		return expenseRepository.findByUserIdAndDateBetween(userId, startDateTime, endDateTime);
	}

	public Optional<Expense> getExpense(Long expenseId) {
		return expenseRepository.findById(expenseId);
	}

	@Override // update expense
	public Expense updateExpense(Long expenseId, Expense updatedExpense) {
		if (expenseId == null || updatedExpense == null) {
			throw new InvalidExpenseException("ExpenseId and updatedExpense cannot be null");
		}
		Expense existingExpense = expenseRepository.findById(expenseId).orElse(null);
		if (existingExpense == null) {
			throw new ExpenseNotFoundException("your Expense is not exist, Create an expense to update !!!");
		}
		existingExpense.setCategory(updatedExpense.getCategory());
		existingExpense.setAmount(updatedExpense.getAmount());
		existingExpense.setDate(updatedExpense.getDate());
		existingExpense.setDescription(updatedExpense.getDescription());
		return expenseRepository.save(existingExpense);
	}
	 @Override // delete
	public void deleteExpense(Long expenseId) {
		if (expenseId == null) {
			throw new InvalidExpenseException("ExpenseId cannot be null");
		}
		Expense expense = expenseRepository.findById(expenseId).orElse(null);
		if (expense == null) {

			throw new ExpenseNotFoundException("your expense is not exist to delete, please provide valied inputs!!");
		}
		expenseRepository.deleteById(expenseId);
	}

	@Override  //monthly expense summary
	public List<Expense> getMonthlyExpenseSummary(Long userId) {
		LocalDate currentDate = LocalDate.now();
		LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
		LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());

		LocalDateTime startDateTime = firstDayOfMonth.atStartOfDay();
		LocalDateTime endDateTime = lastDayOfMonth.atStartOfDay().plusDays(1);
		if (userId == null) {
			throw new UserNotFoundException(
					"you are not an Existing user to get an Expense source/Create an user account");
		}

		return expenseRepository.findByUserIdAndDateBetween(userId, startDateTime, endDateTime);
	}

	@Override // expense above certain amount
	public List<Expense> getExpensesAboveThreshold(Long userId, Double amount) {
		if (userId == null || amount == null) {
			throw new UserNotFoundException(
					"you are not an Existing user to get an Expense source/Create an user account");
		}
		return expenseRepository.findByUserIdAndAmountGreaterThan(userId, amount);
	}
	
	
	
	
	
	

	@Override // average monthly expense
	public Map<String, Double> calculateAverageMonthlyExpenses(Long userId) {
        List<Expense> expenses = expenseRepository.findByUserId(userId);

        // Calculate total expenses per category
        Map<String, Double> totalExpensesPerCategory = new HashMap<>();
        for (Expense expense : expenses) {
            String category = expense.getCategory();
            double amount = expense.getAmount();

            totalExpensesPerCategory.put(category, totalExpensesPerCategory.getOrDefault(category, 0.0) + amount);
        }

        // Calculate average monthly expenses per category
        Map<String, Double> averageMonthlyExpensesPerCategory = new HashMap<>();
        int totalMonths = getTotalMonths(expenses);
        for (Map.Entry<String, Double> entry : totalExpensesPerCategory.entrySet()) {
            String category = entry.getKey();
            double totalExpense = entry.getValue();

            double averageMonthlyExpense = totalExpense / totalMonths;
            averageMonthlyExpensesPerCategory.put(category, averageMonthlyExpense);
        }

        return averageMonthlyExpensesPerCategory;
    }
	// get total months to get average month
    private int getTotalMonths(List<Expense> expenses) {
        Set<YearMonth> uniqueYearMonths = new HashSet<>();
        for (Expense expense : expenses) {
            YearMonth yearMonth = YearMonth.from(expense.getDate());
            uniqueYearMonths.add(yearMonth);
        }
        return uniqueYearMonths.size();
    }
    
    
   @Override // get to expense category
	public List<String> getTopExpenseCategories(long userId) {
		List<Expense> userExpenses = expenseRepository.findByUserId(userId);

		Map<String, Double> categoryTotalAmountMap = userExpenses.stream()
				.collect(Collectors.groupingBy(Expense::getCategory, Collectors.summingDouble(Expense::getAmount)));

		return categoryTotalAmountMap.entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
				.map(Map.Entry::getKey).limit(5).collect(Collectors.toList());
	}

	
	
	
   @Override
   public Map<Integer, Double> getWeeklyExpenseBreakdown(long userId, int month, int year) {
       // Check if the month is within the valid range
       if (month < 1 || month > 12) {
           throw new IllegalArgumentException("Invalid value for month: " + month);
       }
       
       LocalDateTime startDate = LocalDateTime.of(year, month, 1, 0, 0); // Start of the month
       LocalDateTime endDate = startDate.plusMonths(1).minusSeconds(1); // End of the month

       List<Expense> userExpenses = expenseRepository.findByUserIdAndDateBetween(userId, startDate, endDate);

       Map<Integer, Double> weeklyBreakdown = new HashMap<>();
       for (Expense expense : userExpenses) {
           int weekOfMonth = expense.getDate().get(WeekFields.ISO.weekOfMonth());
           double totalExpense = weeklyBreakdown.getOrDefault(weekOfMonth, 0.0);
           totalExpense += expense.getAmount();
           weeklyBreakdown.put(weekOfMonth, totalExpense);
       }

       return weeklyBreakdown;
   }
	
	
	
	@Override // get display if their is any change in month to month expense
	public double getExpensesForMonthAndYear(long userId, int month, int year) {
	    LocalDateTime startDateTime = LocalDateTime.of(year, month,1, 1, 1);
	    LocalDateTime endDateTime = startDateTime.plusMonths(1).minusDays(1);

	    List<Expense> userExpenses = expenseRepository.findByUserIdAndDateBetween(userId, startDateTime, endDateTime);

	    return userExpenses.stream()
	            .mapToDouble(Expense::getAmount)
	            .sum();
	}
	
	@Override  // get display if their is any change in month to month expense
	public double getMonthOverMonthChange(long userId) {

		LocalDateTime currentDateTime = LocalDateTime.now();
		LocalDateTime previousMonthDate = currentDateTime.minus(1, ChronoUnit.MONTHS);

		double currentMonthExpenses = getExpensesForMonthAndYear(userId, currentDateTime.getMonthValue(),
				currentDateTime.getYear());

		double previousMonthExpenses = getExpensesForMonthAndYear(userId, previousMonthDate.getMonthValue(),
				previousMonthDate.getYear());

		return currentMonthExpenses - previousMonthExpenses;
	}

}
