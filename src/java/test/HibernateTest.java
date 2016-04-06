/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import com.akennedy.dao.ObjetosDAO;
import com.akennedy.entities.Ciudad;
import com.akennedy.session.CiudadSession;
import java.util.List;


/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class HibernateTest {
    public static void main(String[] args){
        CiudadSession cs = new CiudadSession();
        List<Ciudad> l = cs.searchCiudad(0, 100, "HERNAN");
        for (Ciudad ciudad : l) {
            System.out.println(ciudad.getCiu_nombre());
        }
        System.exit(0);
    }
}
