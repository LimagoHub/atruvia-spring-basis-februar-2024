package de.application;


import de.application.client.CalcClient;
import de.application.demo.Demo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {


	public static void main(String[] args) {


		final AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		context.registerShutdownHook();

		//context.getBean(CalcClient.class).go();




	}

}
