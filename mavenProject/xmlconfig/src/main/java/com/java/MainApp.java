package com.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main( String [] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student student1 = context.getBean("student1", Student.class);
		student1.display();
		
		Student student2 = context.getBean("student2", Student.class);
		student2.display();
		
	}

}
