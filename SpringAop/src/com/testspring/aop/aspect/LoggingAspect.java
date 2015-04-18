package com.testspring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect
{
	@Before("execution(public String com.testspring.aop.model.Circle.getName())")
	public void loggingAdvice1()
	{
		System.out
				.println("logging Advice Called for no parameters public getter 'getName()' of Circle with return type String.");
	}

	/**
	 * Using wild cards and '..'
	 */
	@Before("execution(* get*(..))")
	public void loggingAdvice2()
	{
		System.out
				.println("logging Advice Called for all getter methods regardless the 'return type , access types and parameters'");
	}
}
