package com.arcane.pfa.core.personalfinancecore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arcane.pfa.core.personalfinancecore.dto.AccountDetailsResponse;
import com.arcane.pfa.core.personalfinancecore.model.AccountDetails;
import com.arcane.pfa.core.personalfinancecore.model.Transaction;
import com.arcane.pfa.core.personalfinancecore.service.AccountDetailsService;

@RestController
@RequestMapping("/accounts")
public class AccountDetailsController {
    
    @Autowired
    private AccountDetailsService accountDetailsService;

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountDetails> checkBalance(@PathVariable Long accountNumber) {
        AccountDetails account = accountDetailsService.checkBalance(accountNumber);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/deposit")
    public ResponseEntity<Double> depositFunds(@RequestBody Transaction transaction) {
        double newBalance = accountDetailsService.depositFunds(transaction.getAccountNumber(), transaction.getAmount());
        if (newBalance >= 0) {
            return ResponseEntity.ok(newBalance);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Double> withdrawFunds( @RequestBody Transaction transaction ) {
        double newBalance = accountDetailsService.withdrawFunds(transaction.getAccountNumber(), transaction.getAmount());
        if (newBalance >= 0) {
            return ResponseEntity.ok(newBalance);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<AccountDetails> addAccount(@RequestBody AccountDetails accountDetails) {
    	AccountDetails ad = accountDetailsService.addAccount(accountDetails);
    	if(ad != null) {
        return  ResponseEntity.ok(ad);
    	} 
    	return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<AccountDetails> updateAccount(@RequestBody AccountDetails accountDetails) {
        AccountDetails updatedAccount = accountDetailsService.updateAccount(accountDetails);
        if (updatedAccount != null) {
            return ResponseEntity.ok(updatedAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<AccountDetails>> getAllAccounts() {
        List<AccountDetails> accounts = accountDetailsService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

   
}