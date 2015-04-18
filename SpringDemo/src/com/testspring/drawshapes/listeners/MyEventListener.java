package com.testspring.drawshapes.listeners;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener<ApplicationEvent>
{
	@Override
	public void onApplicationEvent(ApplicationEvent event)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("EVENT : "+event.toString());
		System.out.println("------------------------------------------------------------------------------");
	}

}
