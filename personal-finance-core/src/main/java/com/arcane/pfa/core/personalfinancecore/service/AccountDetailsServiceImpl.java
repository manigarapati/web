package com.arcane.pfa.core.personalfinancecore.service;

import java.util.List;

import org.hibernate.jdbc.Expectations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcane.pfa.core.personalfinancecore.Repository.AccountDetailsRepository;
import com.arcane.pfa.core.personalfinancecore.dto.AccountDetailsResponse;
import com.arcane.pfa.core.personalfinancecore.dto.UserDetailsRespone;
import com.arcane.pfa.core.personalfinancecore.model.AccountDetails;
import com.arcane.pfa.core.personalfinancecore.model.UserDetails;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {

	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	public AccountDetails checkBalance(Long accountNumber) {
		return accountDetailsRepository.findById(accountNumber).orElse(null);
	}

	@Override
	public double depositFunds(Long accountId, double amount) {
		AccountDetails accountDetails = accountDetailsRepository.findById(accountId).orElse(null);
		if (accountDetails != null) {
			double currentBalance = accountDetails.getAccountBalance();
			double newBalance = currentBalance + amount;
			accountDetails.setAccountBalance(newBalance);
			accountDetailsRepository.save(accountDetails);
			return newBalance;
		} else {
			// Account not found
			return -1; // Or throw an exception
		}
	}

	@Override
	public double withdrawFunds(Long accountId, double amount) {
		AccountDetails accountDetails = accountDetailsRepository.findById(accountId).orElse(null);
		if (accountDetails != null) {
			double currentBalance = accountDetails.getAccountBalance();
			if (currentBalance >= amount) {
				double newBalance = currentBalance - amount;
				accountDetails.setAccountBalance(newBalance);
				accountDetailsRepository.save(accountDetails);
				return newBalance;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}

	@Override
	public AccountDetails addAccount(AccountDetails accountDetails) {
	Long userId = accountDetails.getUserDetails().getUserId();
	if(userId != null) {
		UserDetails userDetails =    userDetailsService.getUserDetails(userId);
		//AccountDetails accountDetails = boToDo(accountDetailsResponse, userDetailsRespone);
		if(userDetails != null) {
		  accountDetails.setUserDetails(userDetails) ;
			return accountDetailsRepository.save(accountDetails);
		}
	} 
	
	return null;
	
		
	}
	
	private AccountDetailsResponse doToBo(AccountDetails accountDetails) {
		AccountDetailsResponse accountDetailsResponse = new AccountDetailsResponse();
		accountDetailsResponse.setAccountBalance(accountDetails.getAccountBalance());
		accountDetailsResponse.setAccountName(accountDetails.getAccountName());
		accountDetailsResponse.setAccountNumber(accountDetails.getAccountNumber());
		accountDetailsResponse.setAccountType(accountDetails.getAccountType());
		accountDetailsResponse.setIfscCode(accountDetails.getIfscCode());
		if(accountDetails.getUserDetails() != null) {
			accountDetailsResponse.setUserId(accountDetails.getUserDetails().getUserId());
		}
		return accountDetailsResponse;
	}
	
	private AccountDetails boToDo(AccountDetailsResponse accountDetailsResponse, UserDetailsRespone userDetailsRespone) {
		AccountDetails details = new AccountDetails();
		details.setAccountBalance(accountDetailsResponse.getAccountBalance());
		details.setAccountName(accountDetailsResponse.getAccountName());
		details.setAccountNumber(accountDetailsResponse.getAccountNumber());
		details.setAccountType(accountDetailsResponse.getAccountType());
		details.setIfscCode(accountDetailsResponse.getIfscCode());
		if(userDetailsRespone != null) {
			UserDetails userDetails = new UserDetails();
			userDetails.setName(userDetailsRespone.getName());
			userDetails.setUserAddress(userDetailsRespone.getUserAddress());
			userDetails.setUserEmail(userDetailsRespone.getUserEmail());
			userDetails.setUserId(userDetailsRespone.getUserId());
			userDetails.setUserName(userDetailsRespone.getUserName());
			userDetails.setUserPhoneNumber(userDetailsRespone.getUserPhoneNumber());
			
			details.setUserDetails(userDetails);
		}
		
		return details;
	}
	

	@Override
    public AccountDetails updateAccount(AccountDetails accountDetails) {
		
		 AccountDetails accountDO = checkBalance(accountDetails.getAccountNumber());
			if(accountDO != null) {
				if(accountDetails.getAccountBalance() != null) {
					accountDO.setAccountBalance(accountDetails.getAccountBalance());
				}
				if(accountDetails.getAccountName() != null) {
					accountDO.setAccountName(accountDetails.getAccountName());
				}
				if(accountDetails.getIfscCode() != null) {
					accountDO.setIfscCode(accountDetails.getIfscCode());
				}
				return accountDetailsRepository.save(accountDO);
			}
   			
   	 
       return null;
	}  		

	@Override
	public List<AccountDetails> getAllAccounts() {
		return accountDetailsRepository.findAll();
	}

}