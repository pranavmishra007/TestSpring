package com.testspring.drawshapes.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import com.testspring.drawshapes.events.DrawEvent;

/*
 * Using @Component we don't have to define this bean inside the spring.xml. This annotation will
 * tell spring that this class needs to be registered as a bean But to use this annotation we have
 * to define <context:component-scan base-package=""/> tag in spring.xml.
 */
/*
 * NOTE : @Component is generic annotation which tell spring the below class is bean. But if we are writing
 * some enterprise application and want to tell spring that bean is of some specific type
 * then we can use following annotations.
 */
// @Service - if the bean is service bean
// @Repository - if bean is a data bean
// @Controller - if bean is a controller bean
@Component
public class Square extends AbstractShape implements ApplicationEventPublisherAware
{
	private Point point1;

	private Point point2;

	private Point point3;

	private Point point4;

	/*
	 * ApplicationEventPublisher instance is used to publish our own events and we have implemented
	 * ApplicationEventPublisherAware to ask spring to initialise this variable.
	 */
	private ApplicationEventPublisher applicationEventPublisher;

	public Point getPoint1()
	{
		return point1;
	}

	// if in the @Resource annotation we wont specify the name property it will search for a bean
	// with same name in spring.xml
	@Resource(name = "origin")
	public void setPoint1(Point point1)
	{
		this.point1 = point1;
	}

	public Point getPoint2()
	{
		return point2;
	}

	@Resource(name = "point2")
	public void setPoint2(Point point2)
	{
		this.point2 = point2;
	}

	public Point getPoint3()
	{
		return point3;
	}

	@Resource(name = "point3")
	public void setPoint3(Point point3)
	{
		this.point3 = point3;
	}

	public Point getPoint4()
	{
		return point4;
	}

	@Resource(name = "point4")
	public void setPoint4(Point point4)
	{
		this.point4 = point4;
	}

	@Override
	public void draw()
	{
		applicationEventPublisher.publishEvent(new DrawEvent(this));
		System.out.println(getMessageSource().getMessage("msgSquare", null, "Default", null));
		System.out.println("Point A : ( " + getPoint1().getXCoordinate() + "," + getPoint1().getYCoordinate() + " )");
		System.out.println("Point B : ( " + getPoint2().getXCoordinate() + "," + getPoint2().getYCoordinate() + " )");
		System.out.println("Point C : ( " + getPoint3().getXCoordinate() + "," + getPoint3().getYCoordinate() + " )");
		System.out.println("Point D : ( " + getPoint4().getXCoordinate() + "," + getPoint4().getYCoordinate() + " )");

	}

	@PostConstruct
	public void initializeSquare()
	{
		System.out.println("initializeSquare using @PostConstruct");
	}

	@PreDestroy
	public void destroySquare()
	{
		System.out.println("destroySquare using @PreDestroy");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher)
	{
		this.applicationEventPublisher = applicationEventPublisher;
	}

}
