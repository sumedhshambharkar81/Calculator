package com.example.demo.date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.dateservice.DateService;
import com.example.demo.dto.RequestDTO;

@Service
public class Date 
{
	@Autowired
	private DateService ser;

	public ResponseEntity<?> operation( RequestDTO req) throws Exception 
	{
		return ser.service(req.getNum1(), req.getNum2());
	}
	
	
}
