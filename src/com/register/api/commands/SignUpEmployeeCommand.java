package com.register.api.commands;

import java.util.List;

import com.register.api.entities.Employee;
import com.register.api.events.CommandListener;

public class SignUpEmployeeCommand implements Command {
	private List<CommandListener> listeners;
	private Employee employee;
	public SignUpEmployeeCommand(Employee employee) {
		this.setEmployee(employee);
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
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
