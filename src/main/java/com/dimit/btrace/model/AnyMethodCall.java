package com.dimit.btrace.model;

public class AnyMethodCall {
	public void method1() {
		System.err.println("origin: call method1");
	}

	public void method2() {
		System.err.println("origin: call method2");
	}
}
