package com.example.demo.student;

import static java.time.Month.JANUARY;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	 
	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository repository) {
		return args -> {
			Student mariam = new Student(
					"Mariam",
					"mariam.jamal@gmial.com",
					LocalDate.of(2000, JANUARY, 5)
			);
			
			Student alex = new Student(
					"Alex",
					"alex@gmial.com",
					LocalDate.of(2004, JANUARY, 5)
			);
			
			repository.saveAll(
					List.of(mariam, alex)
			);
		};
	}

}
