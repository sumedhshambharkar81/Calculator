package com.common.service.exception.handllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.common.dto.CommonException;
import com.common.service.exception.InputNotValid;

@RestControllerAdvice
public class GlobalExceptionHandller extends ResponseEntityExceptionHandler implements AuthenticationEntryPoint
{
	
	CommonException response = new CommonException();
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders hth,
			HttpStatus hts, WebRequest wb)
	{
		response.setResponseCode("96");
		response.setResponseDesc(ex.getBindingResult().getFieldError().getField() + " "+
				ex.getBindingResult().getFieldError().getDefaultMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler({InputNotValid.class})
	public ResponseEntity<?> handleInputNotValid(InputNotValid ex, WebRequest wb)
	{
		response.setResponseCode("92");
		response.setResponseDesc(ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException 
	{
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
}
