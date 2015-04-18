package com.testspring.drawshapes.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Circle extends AbstractShape implements ApplicationContextAware, BeanNameAware
{
	private Point center;

	private int radius;

	private ApplicationContext appContext;

	@Autowired
	@Qualifier("circleSpecific")
	// default auto-wiring using annotations is by type therefore we are using qualifier to set the
	// desired bean
	public void setCenter(Point center)
	{
		this.center = center;
	}

	public Point getCenter()
	{
		return center;
	}

	public void setRadius(int radius)
	{
		this.radius = radius;
	}

	public int getRadius()
	{
		return radius;
	}

	@Override
	public void draw()
	{
		System.out.println(getMessageSource().getMessage("msgCircle", null, "Default", null));
		System.out.println("centre : ( " + getCenter().getXCoordinate() + "," + getCenter().getYCoordinate() + " )");
		System.out.println("radius :" + getRadius());
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException
	{
		this.appContext = context;
		System.out.println("initialised appContext in Circle Class :\n" + appContext);

	}

	@Override
	public void setBeanName(String beanName)
	{
		System.out.println("Bean Name is : " + beanName);

	}

	/**
	 * This method will be called after initialisation of bean.
	 */
	public void myInit()
	{
		System.out.println("My init method is called for Circle");
	}

	/**
	 * This method will be called before bean destruction of bean..
	 */
	public void myCleanUp()
	{
		System.out.println("My Clean Up method is called for Circle");
	}

}
