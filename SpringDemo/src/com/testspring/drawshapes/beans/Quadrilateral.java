package com.testspring.drawshapes.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;

public class Quadrilateral extends AbstractShape implements InitializingBean, DisposableBean
{
	private Point point1;

	private Point point2;

	private Point point3;

	private Point point4;

	public Point getPoint1()
	{
		return point1;
	}

	@Required
	public void setPoint1(Point point1)
	{
		this.point1 = point1;
	}

	public Point getPoint2()
	{
		return point2;
	}

	@Required
	public void setPoint2(Point point2)
	{
		this.point2 = point2;
	}

	public Point getPoint3()
	{
		return point3;
	}

	@Required
	public void setPoint3(Point point3)
	{
		this.point3 = point3;
	}

	public Point getPoint4()
	{
		return point4;
	}

	@Required
	public void setPoint4(Point point4)
	{
		this.point4 = point4;
	}

	@Override
	public void draw()
	{
		System.out.println(getMessageSource().getMessage("msgQuardilateral", null, "Default", null));
		System.out.println("Point A : ( " + getPoint1().getXCoordinate() + "," + getPoint1().getYCoordinate() + " )");
		System.out.println("Point B : ( " + getPoint2().getXCoordinate() + "," + getPoint2().getYCoordinate() + " )");
		System.out.println("Point C : ( " + getPoint3().getXCoordinate() + "," + getPoint3().getYCoordinate() + " )");
		System.out.println("Point D : ( " + getPoint4().getXCoordinate() + "," + getPoint4().getYCoordinate() + " )");

	}

	/**
	 * afterPropertiesSet will be called after the properties of bean are initialised.
	 */
	@Override
	public void afterPropertiesSet() throws Exception
	{
		System.out.println("Initializing bean init method called for Quadrilateral");

	}

	/**
	 * destroy method will be called before bean is destroyed. The destroy method will not be called
	 * in case of bean scope is prototype in the spring.xml.
	 */
	@Override
	public void destroy() throws Exception
	{
		System.out.println("DisposableBean destroy method called for Quadrilateral");

	}

}
