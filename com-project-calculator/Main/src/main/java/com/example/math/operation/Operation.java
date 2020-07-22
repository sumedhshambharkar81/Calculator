package com.example.math.operation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.common.dto.CommonRequest;
import com.common.dto.CommonResponse;
import com.example.math.dto.ResponseDate;
import com.example.math.dto.ResponsePower;

@Service 
public class Operation 
{
	
	@Value("${url_name_date}")
	private String url_date;
	
	@Value("${url_name_power}")
	private String url_power;
	
	@Autowired
	private ResponsePower responsePower;
	
	@Autowired
	private ResponseDate responseDate;
	
	CommonResponse res = new CommonResponse();

	public ResponseEntity<?> operationPower(@Valid CommonRequest request) 
	{
		RestTemplate rst =  new RestTemplate();
		
		res = rst.postForObject(url_power, request,CommonResponse.class);
		responsePower.setPower(res.getResponse().toString());
		
		return ResponseEntity.ok(responsePower);
	}

	public ResponseEntity<?> operationDate(@Valid CommonRequest requestDate)
	{
		RestTemplate rst =  new RestTemplate();
		
		res = rst.postForObject(url_date, requestDate,CommonResponse.class);
		responseDate.setDifference(res.getResponse().toString() + " days");

			return ResponseEntity.ok(responseDate);
	}
}
