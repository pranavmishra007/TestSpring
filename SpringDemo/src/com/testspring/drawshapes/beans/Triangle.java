package com.testspring.drawshapes.beans;

import java.util.List;

public class Triangle extends AbstractShape
{
	private List<Point> points;

	public void setPoints(List<Point> points)
	{
		this.points = points;
	}

	public List<Point> getPoints()
	{
		return points;
	}

	@Override
	public void draw()
	{
		System.out.println(getMessageSource().getMessage("msgTriangle", null, "Default", null));
		for (Point point : points)
		{
			System.out.println("Point " + points.indexOf(point) + " : (" + point.getXCoordinate() + ","
					+ point.getYCoordinate() + ")");
		}
	}
}
