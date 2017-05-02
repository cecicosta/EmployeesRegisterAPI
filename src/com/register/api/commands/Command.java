package com.register.api.commands;

public interface Command {
	void issue() throws Exception;
	void addListener(CommandListener listener);
}
