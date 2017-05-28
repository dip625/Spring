package com.spring.dev.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CustomAnnotationAspect {
	@Before("@annotation(com.spring.dev.aspect.CustomAnnotation)")
	public void myAdvice(){
		System.out.println("CustomeAnnotation on setMethod: Executing myAdvice!!");
	}
}
