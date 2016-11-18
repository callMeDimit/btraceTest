package com.dimit.btrace.command.commands;

import com.dimit.btrace.command.AbstractCommand;
import com.dimit.btrace.command.inter.Receiver;

public class NewThreadCommand extends AbstractCommand<Void> {
	@Override
	public Void execute(Object... args) {
		return super.receiver.handler(args);
	}

	public static NewThreadCommand valueOf() {
		NewThreadCommand command = new NewThreadCommand();
		command.receiver = new NewThreadReceiver();
		return command;
	}
}

class NewThreadReceiver implements Receiver<Void> {
	@Override
	public Void handler(Object... args) {
		new Thread(() -> {
			String name = Thread.currentThread().getName();
			System.out.println("origin:" + name + "线程执行...");
		}).start();
		return null;
	}
}
