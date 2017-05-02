package com.register.api.commands;

import java.util.ArrayList;
import java.util.Iterator;

import com.register.api.entities.Employee;

public class SignUpEmployeeCommand implements Command {
	private ArrayList<CommandListener> listeners = new ArrayList<CommandListener> ();
	private Employee employee;
	public SignUpEmployeeCommand(Employee employee) {
		this.setEmployee(employee);
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
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
