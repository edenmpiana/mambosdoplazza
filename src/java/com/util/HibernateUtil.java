/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author mariompi
 */
public class HibernateUtil {
    //Annotation based configuration
    private static SessionFactory sessionFactory;
    private static SessionFactory buildSessionFactory ()
    {
        try
        {   //Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration ();
            configuration.configure("/hibernate.cfg.xml");
            System.out.println("Hibaernate Annotation Configuration loaded");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate Annotation serviceRegistry created");
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }
        catch (Throwable ex)
        {
           //Make sure you log the exception, as it migth be swalled
            System.err.println("Initial SesseionFactory creation failed. "+ ex);
            throw new ExceptionInInitializerError(ex);
        }
    
    }
    
    public static SessionFactory getSessionFactory()
    {
        if (sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
    
    public static void shutdown()
    {
        //close caches and connection pools
        sessionFactory.close();
    }
    
}
