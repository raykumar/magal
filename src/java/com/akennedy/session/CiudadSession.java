/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.akennedy.session;

import com.akennedy.dao.ObjetosDAO;
import com.akennedy.entities.Ciudad;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 * 
 * @author Alejandro Kennedy <alekennedypy at gmail.com>
 */
public class CiudadSession extends ObjetosDAO{
    public Long insertarCiudad(Ciudad ciu){
        Long id = 0l;
        try {
            iniciarOperacion();
            id = (Long)session.save(ciu);            
            tx.commit();
        } catch (HibernateException e) {
            manejarExcepcion(e);
            throw e;
        }finally{
            session.close();
        }        
        return id;        
    }
    
     public void actualizarCiudad(Ciudad ciu){
        try {
            iniciarOperacion();
            session.update(ciu);
            tx.commit();
        } catch (HibernateException e) {
            manejarExcepcion(e);
            throw  e;
        }
        finally{
            session.close();
        }
    }
    
    public List<Ciudad> listaCiudad(int inicio, int fin){
        List<Ciudad> lCiudad = new ArrayList<>();
        iniciarOperacion();
        try {
            lCiudad = session.createQuery("from Ciudad c where c.activo = true")
            .setFirstResult(inicio).setMaxResults(fin).list();
        } catch (HibernateException e) {
            manejarExcepcion(e);
            throw e;                    
        }finally{
            session.close();
        }
        return lCiudad;
    }
    
    public List<Ciudad> searchCiudad(int inicio, int fin, String ciudad){
        List<Ciudad> lCiudad = new ArrayList<>();
        iniciarOperacion();
        try {
            lCiudad = session.createQuery("from Ciudad c where c.activo = true and lower(c.ciu_nombre) like '%"+ciudad.toLowerCase()+"%'")
            .setFirstResult(inicio).setMaxResults(fin).list();
        } catch (HibernateException e) {
            manejarExcepcion(e);
            throw e;                    
        }finally{
            session.close();
        }
        return lCiudad;
    }
    
    public Ciudad obtenerCiudad(Long idObjeto)throws HibernateException{        
        Ciudad ciu = null;
        try {            
            ciu = new Ciudad();
            iniciarOperacion();
            ciu =  (Ciudad) session.get(ciu.getClass(),idObjeto);
        }finally{
            session.close();
        }
        return ciu;
    }
}
