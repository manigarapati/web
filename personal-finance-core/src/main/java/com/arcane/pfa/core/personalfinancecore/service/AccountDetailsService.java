package com.arcane.pfa.core.personalfinancecore.service;

import java.util.List;

import com.arcane.pfa.core.personalfinancecore.model.AccountDetails;

public interface AccountDetailsService{
	AccountDetails checkBalance(Long accountNumber);
	double depositFunds(Long accountId, double amount);
	double withdrawFunds(Long accountId, double amount);
	AccountDetails addAccount(AccountDetails accountDetails);
	AccountDetails updateAccount(AccountDetails accountDetails);
	List<AccountDetails> getAllAccounts();

}
