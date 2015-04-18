package com.testspring.drawshapes.beans;

public class Line extends AbstractShape
{
	private Point pointA;

	private Point pointB;

	public Point getPointA()
	{
		return pointA;
	}

	public void setPointA(Point pointA)
	{
		this.pointA = pointA;
	}

	public Point getPointB()
	{
		return pointB;
	}

	public void setPointB(Point pointB)
	{
		this.pointB = pointB;
	}

	@Override
	public void draw()
	{
		System.out.println(getMessageSource().getMessage("msgLine", null, "Default", null));
		System.out.println("Point A: (" + getPointA().getXCoordinate() + "," + getPointA().getYCoordinate() + ")");
		System.out.println("Point B: (" + getPointB().getXCoordinate() + "," + getPointB().getYCoordinate() + ")");
	}

	/**
	 * This method will be called after initialisation of bean.
	 */
	public void myInit()
	{
		System.out.println("My init method is called for Line");
	}

	/**
	 * This method will be called before bean destruction of bean..
	 */
	public void myCleanUp()
	{
		System.out.println("My Clean Up method is called for Line");
	}

}
