package com.arcane.pfa.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.arcane.pfa.core")
public class PersonalFinanceCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalFinanceCoreApplication.class, args);
	}

}
