package com.arcane.pfa.core.personalfinanceapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PersonalFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalFinanceApplication.class, args);
	}

}
