package com.spring.dev.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@Pointcut("execution(* com.spring.dev.model.Employee.*(..))")
	public void pointcutMethod(){
	}
	
	@Pointcut("execution(public String getName())")
	public void pointcut2(){
		
	}
	
	@Pointcut("execution(* com.spring.dev.model.*.get*())")   //whose package starts with model and method name starts with get and does not take any argument.
	public void pointcutGetMethod(){
	}
	
	//Pointcut to execute on all the methods of classes in a package
		@Pointcut("within(com.spring.dev.model.*)")
		public void allMethodsPointcut(){}
	
	//bELOW ARE ADIVICES
	
	@Before("pointcut2()")
	public void beforeAdvice() {
		System.out.println("Before Advice method on getName only");
	}
	
	@Before("args(name)")
	public void logStringArguments(String name){
		System.out.println("String argument passed="+name);
	}
	
	@After("pointcutMethod()")
	public void AfterAdvice() {
		System.out.println("After advice method");
	}
	
	@AfterReturning(pointcut="execution(* com.spring.dev.model.Employee.getName())", returning="retVal")
	public void afterReturningAdvice(JoinPoint jp, Object retVal){
	   System.out.println("AfterReturning : Method Signature: "  + jp.getSignature());  
	   System.out.println("AfterReturning : Returning:" + retVal);// !=null ? retVal.toString() : null );
	}
	
	@AfterThrowing(pointcut = "pointcutMethod()",throwing="ex", argNames="ex")
    public void afterThrowing(JoinPoint jp, Throwable ex) throws Throwable {
        //log = LogFactory.getLog(jp.getTarget().getClass());
 
           	//if (log != null && log.isErrorEnabled()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Exception in Class: ").append(
                        jp.getSignature().getDeclaringTypeName()).append(
                        " :Method name : ").append(jp.getSignature().getName())
                        .append(
                                " :Exeption Message : ");
				if(ex.getCause()!=null){
						sb.append(ex.getMessage()+ ":" +ex.getCause().getMessage() );
				}else{
						sb.append(ex.getMessage()+ ":"  );
				}
                        
              //  log.error(sb.toString(), ex);
                System.out.println("After Throwing :" +sb.toString());
            //}
            //throw dgException;
        	
        }
}
