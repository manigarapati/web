package com.arcane.pfa.core.personalfinanceapplication.model;

public class GoalProgress {
	private String name;
	private double progress;
	
	

	public GoalProgress(String name, double progress) {
		this.name = name;
		this.progress = progress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getProgress() {
		return progress;
	}

	public void setProgress(double progress) {
		this.progress = progress;
	}

}
