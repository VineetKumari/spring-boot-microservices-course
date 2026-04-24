package com.learning.restAPI.restful_web_service.helloWorld;

import java.util.Locale;

import org.jspecify.annotations.Nullable;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource=messageSource;
	}
	
	/*
	 * @RequestMapping(method = RequestMethod.GET,path =("/helloWorld") ) public
	 * String helloWorld() {
	 * 
	 * return "Hello World"; }
	 */
	
	@GetMapping(path = ("/helloWorld"))
	public String helloWorld() {
				return "Hello World";
	}
	
	@GetMapping(path = ("/helloWorldBean"))
	public HelloWorldBean helloWorldBean() {
				return new HelloWorldBean("Hello World");
	}

	@GetMapping(path = ("/helloWorldI18n"))
	public String helloWorldI18n() {
		@Nullable
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}
}
