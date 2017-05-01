package com.register.api.events;

import com.register.api.persistence.EventStorage;
import com.register.api.persistence.SnapshopRegister;

public class CommandBus extends Thread {
	public void run(){
		while(true){
			try {
				SnapshopRegister nr = EventStorage.getLastSnapshopRegister();
				if(nr.getStatus() == "commited"){
					this.wait(200);
					continue;
				}
				EventData eventData = EventStorage.getEventData();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
}
