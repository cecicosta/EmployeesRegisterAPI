package com.register.api.commands;

import com.register.api.events.CommandListener;

public interface Command {
	void issue() throws Exception;
	void addListener(CommandListener listener);
}
