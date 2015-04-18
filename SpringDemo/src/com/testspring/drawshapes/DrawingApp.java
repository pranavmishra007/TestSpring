package com.testspring.drawshapes;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.testspring.drawshapes.beans.Shape;

public class DrawingApp
{
	private BeanFactory beanFactory;

	private ApplicationContext appContext;

	private AbstractApplicationContext absAppContext;

	public static void main(String[] args)
	{
		DrawingApp app = new DrawingApp();

		app.objectIntilizationUsingBeanFactory();
		app.objectIntilizationUsingApplicationContext();
		app.objectIntilizationUsingAbstractApplicationContext();
		app.printMessage();
	}
	
	/**
	 * NOTE : There is one quite important thing to be aware of when deploying a bean in the
	 * prototype scope, in that the life cycle of the bean changes slightly. Spring does not manage
	 * the complete life cycle of a prototype bean: the container instantiates, configures,
	 * decorates and otherwise assembles a prototype object, hands it to the client and then has no
	 * further knowledge of that prototype instance. This means that while initialisation life cycle
	 * callback methods will be called on all objects regardless of scope, in the case of
	 * prototypes, any configured destruction life cycle call backs will not be called. It is the
	 * responsibility of the client code to clean up prototype scoped objects and release any
	 * expensive resources that the prototype bean(s) are holding onto. (One possible way to get the
	 * Spring container to release resources used by prototype-scoped beans is through the use of a
	 * custom bean post-processor which would hold a reference to the beans that need to be cleaned
	 * up.)
	 * 
	 * for more info :
	 * http://static.springsource.org/spring/docs/3.0.0.M3/reference/html/ch04s04.html
	 * #beans-factory-scopes-prototype
	 */

	/**
	 * Object Initialisation using Bean factory. For Bean Factory the spring.xml should be in the
	 * root of project if you are simply providing the string name e.g. spring.xml.
	 */
	private void objectIntilizationUsingBeanFactory()
	{
		System.out.println("******************************************************************************");
		System.out.println("Bean Factory");
		beanFactory = new XmlBeanFactory(new FileSystemResource("springBeanFactory.xml"));
		Shape shape1 = (Shape) beanFactory.getBean("rectangle");
		shape1.draw();
		System.out.println("******************************************************************************");
	
	}

	/**
	 * Object Initialisation using Application Context. For Application Context the spring.xml
	 * should be inside the source folder if you are simply providing the string spring.xml.
	 */
	private void objectIntilizationUsingApplicationContext()
	{
		System.out.println("******************************************************************************");
		System.out.println("Application Context");
		appContext = new ClassPathXmlApplicationContext("springApplicationContext.xml");
		// objects can be called either by id or name or alias
		// but the best practice is to use id
		System.out.println("******************************************************************************");
		System.out.println("Using Id");
		Shape shape2 = (Shape) appContext.getBean("line");
		shape2.draw();
		System.out.println("******************************************************************************");
		System.out.println("Using alias");
		shape2 = (Shape) appContext.getBean("line-alias");
		shape2.draw();
		System.out.println("******************************************************************************");
		System.out.println("Using name");
		shape2 = (Shape) appContext.getBean("line-name");
		shape2.draw();
		System.out.println("******************************************************************************");
		Shape shape3 = (Shape) appContext.getBean("triangle");
		shape3.draw();
		System.out.println("******************************************************************************");
		Shape shape4 = (Shape) appContext.getBean("circle");
		shape4.draw();
		System.out.println("******************************************************************************");
		// To close the application context
		((ClassPathXmlApplicationContext) appContext).close();
	}

	/**
	 * Object Initialisation using Abstract Application Context.
	 */
	private void objectIntilizationUsingAbstractApplicationContext()
	{
		System.out.println("******************************************************************************");
		System.out.println("Abstract Application Context");
		absAppContext = new ClassPathXmlApplicationContext("springAbstractApplicationContext.xml");
		// By using shutdownHook we need not to call the close method on absAppContext/
		absAppContext.registerShutdownHook();
		System.out.println("******************************************************************************");
		Shape shape5 = (Shape) absAppContext.getBean("quadrilateral");
		shape5.draw();
		System.out.println("******************************************************************************");
		Shape shape6 = (Shape) absAppContext.getBean("square");
		shape6.draw();
		System.out.println("******************************************************************************");
	}

	private void printMessage()
	{
		String msg = appContext.getMessage("greeting", null, "Default Greeting", null);
		System.out.println(msg);
	}

}
