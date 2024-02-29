package com.arcane.pfa.core.personalfinanceapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcane.pfa.core.personalfinanceapplication.exception.AlertNotFoundException;
import com.arcane.pfa.core.personalfinanceapplication.exception.InvalidAlertException;
import com.arcane.pfa.core.personalfinanceapplication.exception.UserNotFoundException;
import com.arcane.pfa.core.personalfinanceapplication.model.Alert;
import com.arcane.pfa.core.personalfinanceapplication.repository.AlertRepository;

@Service
public class AlertServiceImpl implements AlertService{
	
	@Autowired
	AlertRepository alertRepository;
	
	@Autowired
	UserService userService;

	@Override
	public Alert createAlert(Alert alert) {
		// TODO Auto-generated method stub
		if(userService.getUser(alert.getUserId()) == null) {
			throw new UserNotFoundException("you are not an Existing user to create an Alert source/Create an user account");
		}
		return alertRepository.save(alert);
	}

	@Override
	public List<Alert> getAllAlert(Long userId) {
		// TODO Auto-generated method stub
		if(userId != null) {
			return alertRepository.findByUserId(userId);	
		}
		throw new UserNotFoundException("you are not an Existing user to get an Alert source/Create an user account");
	}

	@Override
	public Alert updateAlert(Long alertId, Alert alert) {
		// TODO Auto-generated method stub
		if(alertId == null || alert == null) {
			throw new InvalidAlertException("alertId and alert does not be null !!");
		}
		if(userService.getUser(alert.getUserId()) == null) {
			throw new UserNotFoundException("uSER not found!!");
		}
		Alert existingAlert = alertRepository.findById(alertId).orElse(null);
		if(existingAlert != null) {
			existingAlert.setBudgetLimit(alert.getBudgetLimit());
			existingAlert.setMessage(alert.getMessage());
			existingAlert.setThreshold(alert.getThreshold());
			return alertRepository.save(existingAlert);
		}
		throw new AlertNotFoundException("Alert not found !!");
	}

	@Override
	public void deleteAlert(Long alertId) {
		// TODO Auto-generated method stub
		if(alertId != null) {
			alertRepository.deleteById(alertId);
		}
		throw new AlertNotFoundException("Alert not found");
		
		
	}
}
