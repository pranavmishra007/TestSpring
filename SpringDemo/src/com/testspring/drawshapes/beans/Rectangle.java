package com.testspring.drawshapes.beans;

public class Rectangle extends AbstractShape
{
	private int height;

	private int width;

	private String drawnBy;

	public Rectangle(int height, int width)
	{
		this.height = height;
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public String getDrawnBy()
	{
		return drawnBy;
	}

	public void setDrawnBy(String drawnBy)
	{
		this.drawnBy = drawnBy;
	}

	@Override
	public void draw()
	{
		System.out.println("Rectangle of height :" + getHeight() + " and width :" + getWidth() + " is drawn by "
				+ getDrawnBy());
	}

}
