package com.register.api.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

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
	
	public static void storeSnapshotRegister(SnapshotRegister ssr){
		Session session = PersistenceUtil.getEventSessionFactory().openSession();
		session.beginTransaction();
		session.save(ssr);
		session.getTransaction().commit();
		session.flush();
		session.close();
	}
	
	public static EventData getEventData(Integer id){
		Session session = PersistenceUtil.getEventSessionFactory().openSession();
		EventData event = (EventData) session.get(EventData.class, id);		
		session.close();
		return event;		
	}
	
	@SuppressWarnings("unchecked")
	public static List<EventData> getAllEventDataOfIdGt(Integer id) throws Exception{
		Session session = PersistenceUtil.getEventSessionFactory().openSession();
		List<EventData> events = (List<EventData>) session.createCriteria(EventData.class).
				add(Restrictions.gt("eventDataId", id)).list();
		session.close();
		if(events == null)
			throw new Exception("no events found.");
		return events;
	}
	
	public static SnapshotRegister getLastSnapshopRegister() throws Exception{
		Session session = PersistenceUtil.getEventSessionFactory().openSession();	
		DetachedCriteria maxId = DetachedCriteria.forClass(SnapshotRegister.class)
			    .setProjection( Projections.max("id") );
		SnapshotRegister snapshot = (SnapshotRegister)session.createCriteria(SnapshotRegister.class)
			    .add(Property.forName("id").eq(maxId)).uniqueResult();
		session.close();
		return snapshot;
	}
}
