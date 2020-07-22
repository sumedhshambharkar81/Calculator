package com.example.demo.powercontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.RequestDTO;
import com.example.demo.power.Power;

@RestController
public class PowerController
{
	@Autowired
	private Power power;
	
	@RequestMapping(value = "/power", method = RequestMethod.POST)
	public ResponseEntity<?> math(@Valid @RequestBody RequestDTO req)
	{
		return power.operation(req);
	}
}
