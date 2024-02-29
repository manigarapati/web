package com.arcane.pfa.core.personalfinanceapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "alert")
public class Alert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long alertId;
	private Long userId;
	private String budgetLimit;
	private Double threshold;
	private String message;

	public Long getAlertId() {
		return alertId;
	}

	public void setAlertId(Long alertId) {
		this.alertId = alertId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getBudgetLimit() {
		return budgetLimit;
	}

	public void setBudgetLimit(String budgetLimit) {
		this.budgetLimit = budgetLimit;
	}

	public Double getThreshold() {
		return threshold;
	}

	public void setThreshold(Double threshold) {
		this.threshold = threshold;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
