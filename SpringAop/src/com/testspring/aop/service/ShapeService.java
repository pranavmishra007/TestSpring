package com.testspring.aop.service;

import com.testspring.aop.model.Circle;
import com.testspring.aop.model.Shape;
import com.testspring.aop.model.Triangle;

public class ShapeService
{
	private Circle circle;

	private Triangle triangle;

	public Circle getCircle()
	{
		return circle;
	}

	public void setCircle(Circle circle)
	{
		this.circle = circle;
	}

	public Triangle getTriangle()
	{
		return triangle;
	}

	public void setTriangle(Triangle triangle)
	{
		this.triangle = triangle;
	}

	public Shape getShape(String name)
	{
		Shape shape = null;

		if ("circle".equalsIgnoreCase(name))
		{
			shape = circle;
		} else if ("triangle".equalsIgnoreCase(name))
		{
			shape = triangle;
		}

		return shape;

	}
}
