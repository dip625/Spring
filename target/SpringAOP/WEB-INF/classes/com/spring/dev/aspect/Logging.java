package com.spring.dev.aspect;

import org.apache.commons.logging.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*
 * @Aspect - mark a class as a class containing advice methods.

@Pointcut - mark a function as a pointcut

execution( expression ) - expression covering methods on which advice is to be applied.
 */



@Aspect
public class Logging {

	//@Pointcut("execution(* com.dataguise.controller.*.*(..))")
	
	 private static Log log = null;
	
	@Pointcut("execution(* com.spring.dev.model.Employee.*(..))")
	public void pointcutMethod(){
	}
	
	@Before("pointcutMethod()")
	public void beforeAdvice() {
		System.out.println("Before Advice MEthodx");
	}
	
	@After("pointcutMethod()")
	public void AfterAdvice() {
		System.out.println("After advice method");
	}
	
	@AfterReturning(pointcut="execution(* com.spring.dev.model.Employee.*(..))", returning="retVal")
	public void afterReturningAdvice(JoinPoint jp, Object retVal){
	   System.out.println("Method Signature: "  + jp.getSignature());  
	   System.out.println("Returning:" + retVal.toString() );
	}
}
