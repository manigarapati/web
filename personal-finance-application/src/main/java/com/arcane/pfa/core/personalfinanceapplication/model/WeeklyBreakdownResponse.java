package com.arcane.pfa.core.personalfinanceapplication.model;

import java.math.BigDecimal;
import java.util.Map;

public class WeeklyBreakdownResponse {

	private int month;
	private int year;
	private Map<Integer, BigDecimal> weeklyBreakdown;

	public WeeklyBreakdownResponse(int month, int year, Map<Integer, BigDecimal> weeklyBreakdown) {
		super();
		this.month = month;
		this.year = year;
		this.weeklyBreakdown = weeklyBreakdown;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Map<Integer, BigDecimal> getWeeklyBreakdown() {
		return weeklyBreakdown;
	}

	public void setWeeklyBreakdown(Map<Integer, BigDecimal> weeklyBreakdown) {
		this.weeklyBreakdown = weeklyBreakdown;
	}

}
