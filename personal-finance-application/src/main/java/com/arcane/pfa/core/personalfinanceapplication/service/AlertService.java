package com.arcane.pfa.core.personalfinanceapplication.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.arcane.pfa.core.personalfinanceapplication.model.Alert;

public interface AlertService {
	Alert createAlert(Alert alert);
	List<Alert> getAllAlert(Long userId);
	Alert updateAlert(Long alertId, Alert alert);
	void deleteAlert(Long alertId);
}
