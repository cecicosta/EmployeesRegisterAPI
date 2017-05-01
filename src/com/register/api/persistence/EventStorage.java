package com.register.api.persistence;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.register.api.entities.Employee;

public class EventStorage {
	public static void storeEvent(String eventData, String handlerType){
		Session session = PersistenceUtil.getEventSessionFactory().openSession();
		session.beginTransaction();
		EventData ed = new EventData(eventData, handlerType);
		session.save(ed);
		session.getTransaction().commit();
		session.flush();
		session.close();
	}
	
	public static EventData getEventData(Integer id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		EventData event = (EventData) session.get(EventData.class, id);		
		session.close();
		return event;		
	}
	
	public static SnapshopRegister getLastSnapshopRegister() throws Exception{
		Session session = PersistenceUtil.getEventSessionFactory().openSession();
		SnapshopRegister snapshot = (SnapshopRegister) session.createCriteria(Employee.class).
				setProjection(Projections.max("timestamp")).uniqueResult();
		session.close();
		if(snapshot == null)
			throw new Exception("Snapshop not found.");
		return snapshot;
	}
}
