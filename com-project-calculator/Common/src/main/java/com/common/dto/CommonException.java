package com.common.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class CommonException implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String response = " ";
	
	private String responseCode = " ";
	
	private String responseDesc = " ";
	

}
