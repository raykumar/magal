/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akennedy.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Alejandro
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;   

    static 
    { 
        try 
        { 
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory(); 
        } catch (HibernateException he) 
        { 
           System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he); 
            throw new ExceptionInInitializerError(he); 
        } 
    }  

    public static SessionFactory getSessionFactory() 
    { 
        return sessionFactory; 
    } 
    
}
