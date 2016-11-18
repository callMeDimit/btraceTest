package com.dimit.btrace.command.commands;

import com.dimit.btrace.command.AbstractCommand;
import com.dimit.btrace.command.inter.Receiver;

public class ByeCommand extends AbstractCommand<Void> {

	@Override
	public Object execute(Object... arg) {
		return super.receiver.handler(arg);
	}

	public static ByeCommand valueOf() {
		ByeCommand command = new ByeCommand();
		command.receiver = new ByeReceiver();
		return command;
	}

}

class ByeReceiver implements Receiver<Void> {

	@Override
	public Void handler(Object... args) {
		System.out.println("origin:系统退出");
		System.exit(0);
		return null;
	}

}