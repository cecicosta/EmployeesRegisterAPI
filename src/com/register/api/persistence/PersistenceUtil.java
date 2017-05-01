package com.register.api.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.register.api.entities.Employee;
import com.register.api.entities.HourRegister;
import com.register.api.events.CreateRegisterHandler;
import com.register.api.events.SignUpEmployeeHandler;
public class PersistenceUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static SessionFactory buildSessionFactory(Configuration config) {
    	serviceRegistry = new ServiceRegistryBuilder().applySettings(
    			config.getProperties()). buildServiceRegistry();	
    	
        try {
        	sessionFactory = config.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getEventSessionFactory() {
    	Configuration config = new Configuration();
    	config.configure("/hibernate-event-repository.cfg.xml");
    	config.addAnnotatedClass(SignUpEmployeeHandler.class); // mapped classes
    	config.addAnnotatedClass(CreateRegisterHandler.class);
    	
        return buildSessionFactory(config);
    }
    
    public static SessionFactory getCommandSessionFactory() {
    	Configuration config = new Configuration();
    	config.configure("/hibernate-event-repository.cfg.xml");
    	config.addAnnotatedClass(Employee.class); // mapped classes
    	config.addAnnotatedClass(HourRegister.class);
    	
        return buildSessionFactory(config);
    }

    public static void shutdown() {
    	sessionFactory.close();
    }
}

