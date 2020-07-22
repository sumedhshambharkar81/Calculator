package com.common.service.exception;

public class InputNotValid extends BaseException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7329451976725704902L;

	public InputNotValid()
	{
		super();
	}
	
	public InputNotValid(String errormsg)
	{
		super(errormsg);
	}
}
