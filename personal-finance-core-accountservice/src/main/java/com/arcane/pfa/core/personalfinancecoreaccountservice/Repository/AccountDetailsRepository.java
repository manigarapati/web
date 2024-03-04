package com.arcane.pfa.core.personalfinancecoreaccountservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arcane.pfa.core.personalfinancecoreaccountservice.model.AccountDetails;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {

	

}
