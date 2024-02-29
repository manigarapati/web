package com.arcane.pfa.core.personalfinanceapplication.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcane.pfa.core.personalfinanceapplication.exception.GoalNotFoundException;
import com.arcane.pfa.core.personalfinanceapplication.exception.InvalidGoalException;
import com.arcane.pfa.core.personalfinanceapplication.exception.UserNotFoundException;
import com.arcane.pfa.core.personalfinanceapplication.model.Goal;
import com.arcane.pfa.core.personalfinanceapplication.model.GoalProgress;
import com.arcane.pfa.core.personalfinanceapplication.repository.GoalRepository;

@Service
public class GoalServiceImpl implements GoalService {

	@Autowired
	GoalRepository goalRepository;

	@Autowired
	UserService userService;

	@Override
	public Goal createGoal(Goal goal) {
		// TODO Auto-generated method stub
		if (userService.getUser(goal.getUserId()) != null) {
			return goalRepository.save(goal);
		}
		throw new UserNotFoundException("User not exist !!");
	}

	@Override
	public List<Goal> getAllGoal(Long userId) {
		// TODO Auto-generated method stub
		if (userId != null) {
			return goalRepository.findByUserId(userId);
		}
		throw new UserNotFoundException("you are not an Authorised User to access to get information Goals !!");
	}

	@Override
	public Goal updateGoal(Long goalId, Goal goal) {
		// TODO Auto-generated method stub
		if (goalId == null || goal == null) {
			throw new InvalidGoalException("GoalId and Goals cannot be null,please provide an valied inputs !!! ");
		}
		Goal existingGoal = goalRepository.findById(goalId).orElse(null);
		if (existingGoal != null) {
			existingGoal.setTittle(goal.getTittle());
			existingGoal.setDescription(goal.getDescription());
			existingGoal.setTargetAmount(goal.getTargetAmount());
			existingGoal.setCurrentAmount(goal.getCurrentAmount());
			existingGoal.setStartDate(goal.getStartDate());
			existingGoal.setEndDate(goal.getEndDate());
			return goalRepository.save(existingGoal);
		}
		throw new GoalNotFoundException(" your Goal is not exist, Create an Goal to update !!!");
	}

	@Override
	public void deleteGoal(Long goalId) {
		// TODO Auto-generated method stub
		if (goalId != null) {
			goalRepository.deleteById(goalId);
		}
		throw new GoalNotFoundException("your Goal is not exist to delete, please provide valied inputs!!");
	}

	@Override
	public List<GoalProgress> getGoalProgress(long userId) {
		List<Goal> goals = goalRepository.findByUserId(userId);
		List<GoalProgress> goalProgressList = new ArrayList<>();

		for (Goal goal : goals) {
			
			double progress = calculateProgressForGoal(goal);
			goalProgressList.add(new GoalProgress(goal.getTittle(), progress));
		}

		return goalProgressList;
	}

	private double calculateProgressForGoal(Goal goal) {
		
		double amountSaved = goal.getCurrentAmount();
		double targetAmount = goal.getTargetAmount();
		return (amountSaved / targetAmount) * 100;
	}
	
	
	@Override
	 public List<Goal> getAchievedGoals(long userId) {
	        
	        LocalDate oneYearAgo = LocalDate.now().minusYears(1);

	        
	        return goalRepository.findByUserIdAndCompletionDateAfter(userId, oneYearAgo);
	    }
}
