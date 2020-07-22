package com.common.dto;

import javax.validation.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class CommonRequest 
{
	@NotEmpty
	private String service;
	
	@NotEmpty
	private String num1;
	
	@NotEmpty
	private String num2;
}
