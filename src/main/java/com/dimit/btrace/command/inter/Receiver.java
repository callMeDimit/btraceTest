package com.dimit.btrace.command.inter;

/**
 * 抽象接收者 接口
 * 
 * @author dimit
 *
 */
public interface Receiver<T> {
	T handler(Object... args);
}
