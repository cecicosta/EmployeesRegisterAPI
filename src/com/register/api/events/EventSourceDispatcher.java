package com.register.api.events;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.register.api.persistence.EventData;
import com.register.api.persistence.EventStorage;
import com.register.api.persistence.SnapshotRegister;

public class EventSourceDispatcher  {
	private static final Gson gson = new Gson();
	public static void runEventSource() throws Exception{
		try {
			SnapshotRegister nr = EventStorage.getLastSnapshopRegister();
			List<EventData> eventData = EventStorage.
					getAllEventDataOfIdGt(nr == null? -1: nr.getEventDataId());
			if(eventData == null){
				return;
			}
			EventData lastEvent = null;
			Iterator<EventData> it = eventData.iterator(); 
			while(it.hasNext()){
				lastEvent = it.next();
				String handlerType = lastEvent.getHandlerType();
				Class<?> clazz = Class.forName(handlerType);
				EventHandler event = (EventHandler) gson.fromJson(lastEvent.getEventData(), clazz) ;
				try{
					event.execute();
				}catch(Exception ex){
					ex.printStackTrace();
					SnapshotRegister ssr = new SnapshotRegister(System.currentTimeMillis(), 
							"failed", lastEvent.getId());
					EventStorage.storeSnapshotRegister(ssr);
					lastEvent = null;
				}
			}

			if(lastEvent != null){
				SnapshotRegister ssr = new SnapshotRegister(System.currentTimeMillis(), 
						"commited", lastEvent.getId());
				EventStorage.storeSnapshotRegister(ssr);
			}
		} catch (Exception ex) {
			throw ex;
		} 
	}


	
}
