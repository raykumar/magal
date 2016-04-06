package com.akennedy.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Alejandro
 */
public class ObjetosDAO {
    public Session session;
    public Transaction tx;
    
    public void iniciarOperacion()throws HibernateException{
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
    
    public void manejarExcepcion(HibernateException he)throws HibernateException{
        tx.rollback();
        throw  new HibernateException("Ocurrio un error en la capa de acceso de datos", he);
    }
    
    public Long guardarObjeto(Object objeto){
        Long id = 0l;
        try {
            iniciarOperacion();
            id = (Long)session.save(objeto);            
            tx.commit();
        } catch (HibernateException e) {
            manejarExcepcion(e);
            throw  e;
        }
        finally{
            session.close();
        }        
        return id;
    }
    
    public void actualizarObjeto(Object objeto){
        try {
            iniciarOperacion();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException e) {
            manejarExcepcion(e);
            throw  e;
        }
        finally{
            session.close();
        }
    }
    
    public void eliminarObjeto(Object objeto){
        try {
            iniciarOperacion();
            session.delete(objeto);
            tx.commit();            
        } catch (HibernateException e) {
            manejarExcepcion(e);
            throw  e;
        }
        finally{
            session.close();
        }
    }
    
    public Object obtenerObjeto(Long idObjeto, Object o)throws HibernateException{        
        try {
            iniciarOperacion();
            o =  session.get(o.getClass(), idObjeto);
        }finally{
            session.close();
        }
        return o;
    }
       
}
