package com.spring.dev.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.dev.model.Employee;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationcontext.xml");
		
		Employee obj = (Employee)context.getBean("emp");
		obj.setName("Prabhu");
		obj.getName();
		obj.throwException();
		context.close();
	}

}
