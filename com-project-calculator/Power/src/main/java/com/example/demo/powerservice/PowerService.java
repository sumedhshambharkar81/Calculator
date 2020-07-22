package com.example.demo.powerservice;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface PowerService 
{
	public ResponseEntity<?> service(String num1, String num2);
}
