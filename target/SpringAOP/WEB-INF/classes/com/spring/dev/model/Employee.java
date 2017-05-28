package com.spring.dev.model;

public class Employee {
	private String name;

	public String getName() {
		System.out.println("getting name Prabhu");
		return name;
	}

	
	public void setName(String name) {
		System.out.println("setting name Prabhu");
		this.name = name;
	}
	
	public void throwException(){
		throw new RuntimeException("Dummy Exception");
	}
}
