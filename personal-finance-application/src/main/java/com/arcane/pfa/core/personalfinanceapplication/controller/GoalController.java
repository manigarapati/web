package com.arcane.pfa.core.personalfinanceapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arcane.pfa.core.personalfinanceapplication.model.Goal;
import com.arcane.pfa.core.personalfinanceapplication.model.GoalProgress;
import com.arcane.pfa.core.personalfinanceapplication.service.GoalService;

@RestController
@RequestMapping("/goal")
@CrossOrigin("*") 
public class GoalController {

	@Autowired
	GoalService goalService;

	@PostMapping
	public Goal createGoal(@RequestBody Goal goal) {
		return goalService.createGoal(goal);
	}

	@GetMapping("/{userId}")
	public List<Goal> getGoal(@PathVariable Long userId) {
		return goalService.getAllGoal(userId);
	}

	@PutMapping("/{goalId}")
	public ResponseEntity<Goal> updateGoal(@PathVariable Long goalId, @RequestBody Goal goal) {
		Goal newGoal = goalService.updateGoal(goalId, goal);
		if (newGoal != null) {
			return ResponseEntity.ok(newGoal);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{goalId}")
	public ResponseEntity<Object> deleteGoal(@PathVariable Long goalId) {
		goalService.deleteGoal(goalId);
		return ResponseEntity.noContent().build();
	}
	
	 @GetMapping("/progress/{userId}")
	    public ResponseEntity<List<GoalProgress>> getGoalProgress(@PathVariable long userId) {
	        List<GoalProgress> goalProgressList = goalService.getGoalProgress(userId);
	        return ResponseEntity.ok(goalProgressList);
	    }
	 
	  @GetMapping("/achieved/{userId}")
	    public ResponseEntity<List<Goal>> getAchievedGoals(@PathVariable long userId) {
	        List<Goal> achievedGoals = goalService.getAchievedGoals(userId);
	        return ResponseEntity.ok(achievedGoals);
	    }

}
