package com.dimit.btrace.command.commands;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.dimit.btrace.command.AbstractCommand;
import com.dimit.btrace.command.receivers.DefaultReceiver;
import com.dimit.btrace.model.AnyMethodCall;

/**
 * 任意方法调用
 * 
 * @author dimit
 */
public class CallMethodCommand extends AbstractCommand<Void> {
	@Override
	public Object execute(Object... arg) {
		return super.receiver.handler(arg);
	}

	@Override
	public Object[] processArgument(String[] argStrs) {
		if (argStrs.length != 1) {
			throw new IllegalArgumentException("非法参数异常");
		}
		try {
			Method declaredMethod = AnyMethodCall.class.getDeclaredMethod(argStrs[0]);
			Runnable r = () -> {
				try {
					declaredMethod.invoke(new AnyMethodCall());
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			};
			return new Object[] { r };
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return super.processArgument(argStrs);
	}

	public static CallMethodCommand defaultOf() {
		CallMethodCommand command = new CallMethodCommand();
		command.receiver = new DefaultReceiver();
		return command;
	}
}
