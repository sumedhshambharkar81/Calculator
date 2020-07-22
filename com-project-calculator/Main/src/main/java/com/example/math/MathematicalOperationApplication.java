package com.example.math;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ="com.example,com.common")
public class MathematicalOperationApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(MathematicalOperationApplication.class, args);
	}

}
