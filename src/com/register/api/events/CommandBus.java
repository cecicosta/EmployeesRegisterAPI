package com.register.api.events;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import com.register.api.persistence.EventData;
import com.register.api.persistence.EventStorage;
import com.register.api.persistence.SnapshotRegister;

public class CommandBus extends Thread {
	private final Gson gson = new Gson();
	@Override
	public void run(){
		while(true){
			try {
				SnapshotRegister nr = EventStorage.getLastSnapshopRegister();
				List<EventData> eventData = EventStorage.
						getAllEventDataOfIdGt(nr == null? -1: nr.getEventDataId());
				if(eventData == null){
					TimeUnit.MILLISECONDS.sleep(2000);
					continue;
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
			        //Method method = clazz.getMethod("execute");
			        //Object object = clazz.newInstance();
			        //method.invoke(object);
				}

				if(lastEvent != null){
					SnapshotRegister ssr = new SnapshotRegister(System.currentTimeMillis(), 
							"commited", lastEvent.getId());
					EventStorage.storeSnapshotRegister(ssr);
				}
			} catch (Exception e) {
				e.printStackTrace();
				try {
					TimeUnit.MILLISECONDS.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} 
			try {
				TimeUnit.MILLISECONDS.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
}
