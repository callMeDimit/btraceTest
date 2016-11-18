package com.dimit.btrace.command.receivers;

import com.dimit.btrace.command.inter.Receiver;

public class DefaultReceiver implements Receiver<Void> {

	@Override
	public Void handler(Object... args) {
		if(args.length != 1) {
			throw new IllegalArgumentException("默认接收器参数个数非法");
		}
		if(args[0].getClass().isAssignableFrom(Runnable.class)) {
			throw new IllegalArgumentException("默认接收器参数类型非法");
		}
		Runnable runnable = (Runnable) args[0];
		runnable.run();
		return null;
	}
	
}
