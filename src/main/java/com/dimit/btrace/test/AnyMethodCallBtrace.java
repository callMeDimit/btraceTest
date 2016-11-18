package com.dimit.btrace.test;

import static com.sun.btrace.BTraceUtils.*;
import com.sun.btrace.annotations.*;
@BTrace
public class AnyMethodCallBtrace {
	@OnMethod(clazz="com.dimit.btrace.model.AnyMethodCall", method="/.*/",
            location=@Location(value=Kind.CALL, clazz="/.*/", method="/.*/"))
  public static void m(@Self Object self, @ProbeClassName String pcm, @TargetMethodOrField String method, @ProbeMethodName String probeMethod) { // all calls to the methods with signature "()"
      println(classOf(self)+"---" + pcm + "   class   " + method + " in " + probeMethod);
  }
}
