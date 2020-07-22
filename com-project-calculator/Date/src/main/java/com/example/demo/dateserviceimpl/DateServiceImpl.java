package com.example.demo.dateserviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.util.Precision;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.example.demo.dateservice.DateService;
import com.example.demo.dto.ResponseDTO;

@Component
public class DateServiceImpl implements DateService 
{

	@Override
	public ResponseEntity<?> service(String num1, String num2) throws Exception 
	{
		Date d1 = new SimpleDateFormat("dd-MM-yyyy").parse(num1);
		Date d2 = new SimpleDateFormat("dd-MM-yyyy").parse(num2);
		
		Long difference = d1.getTime() - d2.getTime();
		
		float days = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
		
		Double day = (double) days;
		
		ResponseDTO response = new ResponseDTO();
		
		response.setResponse(Precision.round(day, 2));
		
		return ResponseEntity.ok(response);
	}

}
