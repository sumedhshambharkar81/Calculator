package com.example.math.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.common.dto.CommonRequest;
import com.common.service.exception.InputNotValid;
import com.example.math.operation.Operation;

@RestController
public class MathController 
{
	@Autowired
	private Operation opr;
	
	@RequestMapping(value = "/math", method = RequestMethod.POST)
	public ResponseEntity<?> math(@Valid @RequestBody CommonRequest req) throws Exception
	{
		if(!req.getService().matches("^[a-z]{7}-[a-z]{5}$"))
		{
			throw new InputNotValid("Please enter correct service..!");
		}
		else
		{
			if(req.getService().equals("compute-power"))
			{
				if(!req.getNum1().matches("^[1-9]{1}.[1-9]{1}$") || !req.getNum2().matches("^[1-9]{1}.[1-9]{1}$") )
				{
					throw new InputNotValid("Entered Numbers are not valid");
				}
				
				return opr.operationPower(req);
			}
			else
			{
				if(!req.getNum1().matches("^[0-9]{2}-[0-9]{2}-[0-9]{4}$") || 
						!req.getNum2().matches("^[0-9]{2}-[0-9]{2}-[0-9]{4}$") )
				{
					throw new InputNotValid("Entered Numbers are not valid");
				}
				
				return opr.operationDate(req);
			}
		}
	}
}