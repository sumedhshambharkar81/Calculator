package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class RequestDTO 
{
	@NotEmpty
	private String service;
	
	@NotEmpty
	private String num1;
	
	@NotEmpty
	private String num2;
}
