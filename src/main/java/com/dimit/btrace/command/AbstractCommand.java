package com.dimit.btrace.command;

import com.dimit.btrace.command.inter.Command;
import com.dimit.btrace.command.inter.Receiver;

public abstract class AbstractCommand<T> implements Command<Object> {
	@Override
	public Object[] processArgument(String[] argStrs) {
		throw new UnsupportedOperationException("该命令不支持参数处理");
	}

	/** 接收者 */
	protected Receiver<T> receiver;
}
