package com.register.api.events;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.register.api.persistence.EventData;
import com.register.api.persistence.EventStorage;
import com.register.api.persistence.SnapshotRegister;

public class CommandBus extends Thread {
	@Override
	public void run(){
		while(true){
			try {
				SnapshotRegister nr = EventStorage.getLastSnapshopRegister();
				if(nr == null){
					TimeUnit.MILLISECONDS.sleep(200);
					continue;
				}
				List<EventData> eventData = EventStorage.getAllEventDataOfIdGt(nr.getEventDataId());
				if(eventData == null){
					TimeUnit.MILLISECONDS.sleep(200);
					continue;
				}
				EventData lastEvent = null;
				while(eventData.iterator().hasNext()){
					lastEvent = eventData.iterator().next();
					String handlerType = lastEvent.getHandlerType();
					Class<?> clazz = Class.forName(handlerType);
			        Method method = clazz.getMethod("execute");
			        Object object = clazz.newInstance();
			        method.invoke(object);
				}
				//TODO: Se alguma transação não for bem sucedida, capturar causas possiveis
				//tratar se possivel, caso contrario continuar com as demais transações
				//Guardar status da transação falha em um registro de snapshopt se possível.
				SnapshotRegister ssr = new SnapshotRegister(System.currentTimeMillis(), 
						"commited", lastEvent.getId());
				EventStorage.storeSnapshotRegister(ssr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
}
