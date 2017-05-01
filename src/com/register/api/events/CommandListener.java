package com.register.api.events;

import java.util.List;
import java.util.concurrent.Semaphore;

import com.google.gson.Gson;
import com.register.api.commands.Command;
import com.register.api.commands.CreateRegisterCommand;
import com.register.api.commands.SignUpEmployeeCommand;
import com.register.api.persistence.EventStorage;

public class CommandListener {
	public static List<EventHandler> eventQueue;
	public static final Semaphore available = new Semaphore(1, true);
	private static final Gson gson = new Gson();
	
	public void on(Command cmd){}
	
	public void on(SignUpEmployeeCommand cmd){
		SignUpEmployeeHandler handler = new SignUpEmployeeHandler(cmd.getEmployee());
		String eventData = gson.toJson(handler);
		EventStorage.storeEvent(eventData, SignUpEmployeeHandler.class.getName());
	}
	
	public void on(CreateRegisterCommand cmd){
		CreateRegisterHandler handler = new CreateRegisterHandler(cmd.getRegister());
		String eventData = gson.toJson(handler);
		EventStorage.storeEvent(eventData, CreateRegisterHandler.class.getName());
	}
}
