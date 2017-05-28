package com.spring.dev.model;

import com.spring.dev.aspect.CustomAnnotation;

public class Employee {
	private String name;

	public String getName() {
		System.out.println("Getter method");
		return name;
	}

	@CustomAnnotation
	public void setName(String name) {
		System.out.println("Setter Method name");
		this.name = name;
	}
	
	public void throwException(){
		throw new RuntimeException("Dummy Exception");
	}
}
