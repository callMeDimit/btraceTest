package com.dimit.btrace.test;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;

@BTrace
public class BtraceTestOne {
	// @OnMethod annotation tells where to probe.
	// In this example, we are interested in entry
	// into the Thread.start() method.
	@OnMethod(clazz = "java.lang.Thread", method = "start")
	public static void func() {
		// println is defined in BTraceUtils
		// you can only call the static methods of BTraceUtils
		BTraceUtils.println("about to start a thread!");
	}
}
