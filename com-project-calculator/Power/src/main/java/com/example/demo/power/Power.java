package com.example.demo.power;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.dto.RequestDTO;
import com.example.demo.powerservice.PowerService;

@Service
public class Power
{
	@Autowired
	private PowerService ser;
	
	public ResponseEntity<?> operation(@Valid RequestDTO req) 
	{
		return ser.service(req.getNum1(), req.getNum2());
	}
	

}
