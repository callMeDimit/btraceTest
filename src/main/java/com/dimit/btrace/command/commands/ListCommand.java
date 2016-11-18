package com.dimit.btrace.command.commands;

import com.dimit.btrace.command.AbstractCommand;
import com.dimit.btrace.command.Commands;
import com.dimit.btrace.command.receivers.DefaultReceiver;

public class ListCommand extends AbstractCommand<Void> {

	@Override
	public Object execute(Object... arg) {
		Runnable r = () -> {
			Commands[] commands = Commands.values();
			for (Commands c : commands) {
				System.err.println(c.getDesc());
			}
		};
		return super.receiver.handler(r);
	}

	public static ListCommand defaultOf() {
		ListCommand command = new ListCommand();
		command.receiver = new DefaultReceiver();
		return command;
	}
}
