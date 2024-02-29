package com.arcane.pfa.core.personalfinanceapplication.service;

import java.util.List;

import com.arcane.pfa.core.personalfinanceapplication.model.Goal;
import com.arcane.pfa.core.personalfinanceapplication.model.GoalProgress;

public interface GoalService {
	Goal createGoal(Goal goal);
	List<Goal> getAllGoal(Long userId);
	Goal updateGoal(Long goalId, Goal goal);
	void deleteGoal(Long goalId);
	
	List<GoalProgress> getGoalProgress(long userId);
	
	List<Goal> getAchievedGoals(long userId);
}
