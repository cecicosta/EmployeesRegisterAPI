package com.register.api.commands;

import java.util.List;
import java.util.concurrent.Semaphore;

import com.google.gson.Gson;
import com.register.api.events.CreateRegisterHandler;
import com.register.api.events.EventHandler;
import com.register.api.events.SignUpEmployeeHandler;
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
