package com.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {

		//1: launch a spring context -
		
		try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			//2: configure the things that we want spring framework to manage - @Configuration
			//HelloWorldConfiguration - @Configuration
			//name - @Bean
			
			
			//3: Retrieving beans managed by spring
			System.out.println(context.getBean("name"));
			
			System.out.println(context.getBean("age"));
			
			System.out.println(context.getBean("person"));
			
			System.out.println(context.getBean("person2MethodCall"));
			
			System.out.println(context.getBean("person3Parameters"));
			
			System.out.println(context.getBean("address2"));
			
			System.out.println(context.getBean(Person.class));
			
			System.out.println(context.getBean(Address.class));
			
			System.out.println(context.getBean("person5Qualifier"));
			
//			Arrays.stream(context.getBeanDefinitionNames()).forEach(a -> System.out.println(a + " - I am a bean"));
		};

	}

} 