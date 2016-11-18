package com.dimit.btrace.command;

import com.dimit.btrace.command.commands.CallMethodCommand;
import com.dimit.btrace.command.commands.ListCommand;
import com.dimit.btrace.command.commands.ByeCommand;
import com.dimit.btrace.command.commands.NewThreadCommand;
import com.dimit.btrace.command.inter.Command;

/**
 * 命令集合
 * 
 * @author dimit
 */
public enum Commands {
	/** 新建线程测试指令 */
	NEW(NewThreadCommand.valueOf(), "NEW 使用new Thread().start()新起一个线程 参数<无>"),

	/** 退出指令 */
	BYE(ByeCommand.valueOf(), "BYE 退出 参数<无>"),

	/** 调用任意方法指令 */
	CALL_METHOD(CallMethodCommand.defaultOf(), "CALL_METHOD 调用类AnyMethodCall实例的指定方法 参数<方法名>"),
	
	/** 打印所有指令*/
	LIST(ListCommand.defaultOf(), "LIST 打印所有指令 参数<无>");

	private Command<?> command;

	/** 指令描述 */
	private String desc;

	private Commands(Command<?> command, String desc) {
		this.command = command;
		this.desc = desc;
	}

	public Command<?> getCommand() {
		return command;
	}

	public String getDesc() {
		return desc;
	}
}
