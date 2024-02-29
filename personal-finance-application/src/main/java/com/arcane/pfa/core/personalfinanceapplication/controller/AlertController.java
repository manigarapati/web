package com.arcane.pfa.core.personalfinanceapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arcane.pfa.core.personalfinanceapplication.model.Alert;
import com.arcane.pfa.core.personalfinanceapplication.service.AlertService;

@RestController
@RequestMapping("/alert")
public class AlertController {
	
	@Autowired
	AlertService alertService;
	
	@PostMapping
	public Alert createAlert(@RequestBody Alert alert) {
		return alertService.createAlert(alert);
	}
	
	@GetMapping("/{userId}")
	public List<Alert> getAlert(@PathVariable Long userId){
		return alertService.getAllAlert(userId);
	}
	
	@PutMapping("/{alertId}")
	public Alert updateAlert(@PathVariable Long alertId, @RequestBody Alert alert){
		return alertService.updateAlert(alertId, alert);
	}
	
	@DeleteMapping("/{alertId}")
	public ResponseEntity<Object> deleteAlert(@PathVariable Long alertId){
		alertService.deleteAlert(alertId);
		return ResponseEntity.noContent().build();
	}

}
