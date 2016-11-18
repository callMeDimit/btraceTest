package com.dimit.btrace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.dimit.btrace.command.Commands;
import com.dimit.btrace.command.inter.Command;

public class MainClz {
	public static final String SEPARATOR = " ";

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (true) {
				String readLine = br.readLine();
				readLine.trim();
				String[] split = readLine.split(SEPARATOR);
				Commands commands = Commands.valueOf(split[0].toUpperCase());
				Command<?> command = commands.getCommand();
				if (split.length > 1) {
					String[] argStrs = Arrays.copyOfRange(split, 1, split.length);
					Object[] argObjs = command.processArgument(argStrs);
					command.execute(argObjs);
				} else {
					command.execute();
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
