package com.akennedy.session;

import com.akennedy.dao.ObjetosDAO;
import com.akennedy.entities.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 * 
 * @author Alejandro Kennedy <alekennedypy at gmail.com>
 */
public class ClienteSession extends ObjetosDAO{
    
    public Long guardarCliente(Cliente cli){
        Long id = 0l;
        try {
            iniciarOperacion();
            id = (Long)session.save(cli);            
            tx.commit();
        } catch (HibernateException e) {
            manejarExcepcion(e);
            throw e;
        }finally{
            session.close();
        }        
        return id;        
    }
    
    public List<Cliente> listaClientes(int inicio, int fin){
        List<Cliente> lClientes = new ArrayList<>();
        iniciarOperacion();
        try {
            lClientes = session.createQuery("from Cliente")
            .setFirstResult(inicio).setMaxResults(fin).list();
        } catch (HibernateException e) {
            manejarExcepcion(e);
            throw e;                    
        }finally{
            session.close();
        }
        return lClientes;
    }   
    
}
