package com.testspring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.testspring.aop.service.ShapeService;

public class AopMain
{
	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
		System.out.println(shapeService.getShape("circle").getName());
		System.out.println(shapeService.getShape("triangle").getName());
	}

}
