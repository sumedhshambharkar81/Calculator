package com.example.demo.dateservice;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface DateService 
{
	public ResponseEntity<?> service(String num1, String num2) throws Exception;
}
