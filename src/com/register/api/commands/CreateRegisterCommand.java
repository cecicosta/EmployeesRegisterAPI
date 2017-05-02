package com.register.api.commands;

import java.util.ArrayList;
import java.util.Iterator;

import com.register.api.entities.HourRegister;
public class CreateRegisterCommand implements Command {
	private ArrayList<CommandListener> listeners = new ArrayList<CommandListener>();
	private HourRegister register;
	public CreateRegisterCommand(HourRegister register){
		this.setRegister(register);
	}
	@Override
	public void issue() throws Exception {
		Iterator<CommandListener> it = listeners.iterator();
		while(it.hasNext())
			it.next().on(this);
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
