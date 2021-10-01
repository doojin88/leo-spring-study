package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value="name",defaultValue = "World")String name){
		return String.format("Hello, %s! ",name);
	}

	@GetMapping("/age")
	public String sayAge(@RequestParam(value="age",defaultValue ="19")int age){
		return String.format("Hello,My age is %d!",age);
	}

}
