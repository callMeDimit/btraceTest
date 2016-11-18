package com.dimit.btrace.command.inter;

/**
 * 抽象命令接口
 * 
 * @author dimit
 *
 */
public interface Command<T> {
	/**
	 * 执行命令
	 * @param 命令执行参数
	 */
	T execute(Object... arg);
	
	/**
	 * 参数处理
	 * @param argStrs
	 * @return
	 */
	Object[] processArgument(String[] argStrs);
}
