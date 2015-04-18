package com.testspring.drawshapes.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public abstract class AbstractShape implements Shape
{
	private MessageSource messageSource;

	@Autowired
	public void setMessageSource(MessageSource messageSource)
	{
		this.messageSource = messageSource;
	}

	public MessageSource getMessageSource()
	{
		return messageSource;
	}

}
