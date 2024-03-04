package com.arcane.pfa.core.personalfinancecoreaccountservice.service;

import java.util.List;

import org.hibernate.jdbc.Expectations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arcane.pfa.core.personalfinancecoreaccountservice.Repository.AccountDetailsRepository;
import com.arcane.pfa.core.personalfinancecoreaccountservice.model.AccountDetails;
import com.arcane.pfa.core.personalfinancecoreaccountservice.model.UserDetails;

@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {

	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	public AccountDetails checkBalance(Long accountId) {
		return accountDetailsRepository.findById(accountId).orElse(null);
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

		UserDetails userDetails = userDetailsService.createUserDetails(accountDetails.getUserdetails());
		accountDetails.setUserdetails(userDetails);
		return accountDetailsRepository.save(accountDetails);
	}

	@Override
    public AccountDetails updateAccount(AccountDetails accountDetails) {
       AccountDetails accountDetail =  accountDetailsRepository.findById(accountDetails.getAccountNumber()).get();
       
    	if(accountDetail != null) {
    		accountDetail.setAccountName(accountDetails.getAccountName());
    		UserDetails userDetails = accountDetail.getUserdetails();
    		if(accountDetails.getUserdetails() != null) {
    			if(accountDetails.getUserdetails().getName() != null) {
    				userDetails.setName(accountDetails.getUserdetails().getName());
    			}
    			if(accountDetails.getUserdetails().getUserAddress() != null) {
    		userDetails.setUserAddress(accountDetails.getUserdetails().getUserAddress());
    			}
    		}
    		accountDetail.setAccountName(accountDetails.getAccountName());
    		AccountDetails newAccountDetails;
    		try {
    			 newAccountDetails =   accountDetailsRepository.save(accountDetail);
    		}catch(Exception e) {
    			System.err.println(e.getMessage());
    			newAccountDetails = null;
    		}
    		return newAccountDetails;
    	}
        return null;
    }

	@Override
	public List<AccountDetails> getAllAccounts() {
		return accountDetailsRepository.findAll();
	}

}