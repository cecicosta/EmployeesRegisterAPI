package com.register.api.commands;

import java.util.List;

import com.register.api.entities.HourRegister;
import com.register.api.events.CommandListener;
public class CreateRegisterCommand implements Command {
	private List<CommandListener> listeners;
	private HourRegister register;
	public CreateRegisterCommand(HourRegister register){
		this.setRegister(register);
	}
	@Override
	public void issue() throws Exception {
		while(listeners.iterator().hasNext())
			listeners.iterator().next().on(this);
	}
	@Override
	public void addListener(CommandListener listener) {
		listeners.add(listener);
	}
	public HourRegister getRegister() {
		return register;
	}
	public void setRegister(HourRegister register) {
		this.register = register;
	}
}
