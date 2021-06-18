package com.jun.base.jdk.annotation;

public @interface RequestForEnhancement {
	int id();

	String synopsis();

	String engineer() default "[unassigned]";

	String date() default "[unimplemented]";
}