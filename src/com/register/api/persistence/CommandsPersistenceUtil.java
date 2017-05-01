package com.register.api.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.register.api.events.CreateRegisterHandler;
import com.register.api.events.SignUpEmployeeHandler;
public class CommandsPersistenceUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();
    private static ServiceRegistry serviceRegistry;
    private static SessionFactory buildSessionFactory() {
    	
    	Configuration cfg1 = new Configuration();
    	cfg1.configure("/hibernate-business-model.cfg.xml");
    	cfg1.addAnnotatedClass(SignUpEmployeeHandler.class); // mapped classes
    	cfg1.addAnnotatedClass(CreateRegisterHandler.class);
    	serviceRegistry = new ServiceRegistryBuilder().applySettings(
    			cfg1.getProperties()). buildServiceRegistry();	
    	sessionFactory = cfg1.buildSessionFactory(serviceRegistry);
    	
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}

