package com.qa.PersonProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PersonProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonProjectApplication.class, args);
	}
//  Want to make it http callable
//	Make this match to a GET request only
//	Takes string input with the URL of where it is matched
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello World!";
	}

//	Use request param
//	Set value of name - name of request param to bind to -  and default value - if empty value given
//	localhost:8080/helloyou/firstname=Minahil
	@GetMapping("/helloyou")
	public String sayHelloYou(@RequestParam(name = "firstname", defaultValue = "World") String firstname) {
		//	%s is a format specifier - acts as a placeholder for string to be input
		return String.format("Hello %s!", firstname);
	}

}




