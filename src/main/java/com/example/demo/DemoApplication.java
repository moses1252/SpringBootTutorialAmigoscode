package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //add restcontroller:  makes this class to serve rest endpoints
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	//in order to be served as a restful endpoint
	//need to annotate it
	//we have get mapping, put mapping, post mapping
	@GetMapping
	public String hello() {
		return "Hello World";
	}

}
