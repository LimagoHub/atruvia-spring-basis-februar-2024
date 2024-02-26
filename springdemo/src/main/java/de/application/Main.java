package de.application;


import de.application.demo.Demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {


	public static void main(String[] args) {


		final AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		context.registerShutdownHook();

		Demo demo = (Demo)context.getBean("demo");
		//demo.foo();

		if(System.currentTimeMillis() > 10) return;

		Demo d2 = context.getBean(Demo.class);

		System.out.println(demo == d2);


	}

}
