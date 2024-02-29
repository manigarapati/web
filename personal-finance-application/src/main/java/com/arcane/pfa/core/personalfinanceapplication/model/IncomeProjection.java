package com.arcane.pfa.core.personalfinanceapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class IncomeProjection {
	private Double projectedAmount;
    private int year;
    private Double growthRate;
    
	public Double getProjectedAmount() {
		return projectedAmount;
	}
	public void setProjectedAmount(Double projectedAmount) {
		this.projectedAmount = projectedAmount;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Double getGrowthRate() {
		return growthRate;
	}
	public void setGrowthRate(Double growthRate) {
		this.growthRate = growthRate;
	}
}
