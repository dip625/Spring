package com.spring.dev.aspect;

/*
 * If you look at all the above advices pointcut expressions, there are chances that they gets 
 * applied to some other beans where it’s not intended. For example, someone can define a new 
 * spring bean with getName() method and the advices will start getting applied to that even 
 * though it was not intended. That’s why we should keep the scope of pointcut expression as 
 * narrow as possible.

An alternative approach is to create a custom annotation and annotate the methods where we want 
the advice to be applied. This is the purpose of having Employee setName() method annotated 
with @CustomAnnotation annotation.
 */

	public @interface CustomAnnotation {

	}

