package com.example.demo.powerserviceimpl;

import org.apache.commons.math3.util.Precision;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.powerservice.PowerService;

@Component
public class PowerServiceImpl implements PowerService 
{

	@Override
	public ResponseEntity<?> service(String num1, String num2) 
	{
		Double power = Math.pow(Double.parseDouble(num1), Double.parseDouble(num2));
		ResponseDTO response = new ResponseDTO();
		response.setResponse(Precision.round(power.doubleValue(), 2));
		return ResponseEntity.ok(response);
	}

}
