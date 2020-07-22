package com.example.demo.datecontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.date.Date;
import com.example.demo.dto.RequestDTO;

@RestController
public class DateController
{
	@Autowired
	private Date date;
	
	@RequestMapping(value = "/date", method = RequestMethod.POST)
	public ResponseEntity<?> math(@Valid @RequestBody RequestDTO req) throws Exception
	{
		return date.operation(req);
	}
}
