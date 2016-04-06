/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akennedy.ws;

import com.akennedy.entities.Ciudad;
import com.akennedy.session.CiudadSession;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Alejandro Kennedy
 */
@Path("wf")
public class WFResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WFResource
     */
    public WFResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)    
    @Path("/searchCity/{inicio}/{fin}")
    public Response getListaCiudad(@PathParam("inicio") int inicio, @PathParam("fin") int fin) {
        CiudadSession ciudadSession = new CiudadSession();        
        List<Ciudad> listaCiudad = ciudadSession.listaCiudad(inicio, fin);
        Gson g = new Gson();
        return Response.status(Response.Status.OK).entity(g.toJson(g.toJson(listaCiudad))).
                header("Access-Control-Allow-Origin", "*").
                header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").
                header("Access-Control-Allow-Headers", "origin,  content-type, accept, authorization, X-Requested-With").
                header("Access-Control-Allow-Credentials", "true").
                header("Access-Control-Allow-Max-Age", "1209600").build();
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insertCiudad")
    public Response insertarCiudad(String value){
        Type tCiudad = new TypeToken<Ciudad>(){}.getType();
        Gson g = new Gson();        
        Ciudad ciudad = g.fromJson(value, tCiudad);
        ciudad.setActivo(true);
        CiudadSession ciudadSession = new CiudadSession();
        
        try {
            if(ciudad.validarCiudad()){
                ciudad.setCiu_id(ciudadSession.insertarCiudad(ciudad));                
            }else{
                System.err.println("La entidad Ciudad no pasó la validación");
            }            
            return Response.status(Response.Status.OK).entity(g.toJson(ciudad)).
                    header("Access-Control-Allow-Origin", "*").
                    header("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS, HEAD").
                    header("Access-Control-Allow-Headers", "origin,  content-type, accept, authorization, X-Requested-With").
                    header("Access-Control-Allow-Credentials", "true").
                    header("Access-Control-Allow-Max-Age", "1209600").build();
        } catch (Exception e) {
            String err = "{\"respuesta\":\""+e.getMessage()+"\"}";
            return Response.status(Response.Status.OK).entity(err).
                    header("Access-Control-Allow-Origin", "*").
                    header("Access-Control-Allow-Methods", "POST, GET,PUT, DELETE, OPTIONS, HEAD").
                    header("Access-Control-Allow-Headers", "origin,  content-type, accept, authorization, X-Requested-With").
                    header("Access-Control-Allow-Credentials", "true").
                    header("Access-Control-Allow-Max-Age", "1209600").build();           
        }        
    } 
    
    @POST    
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/deleteCity")
    public Response deleteCity(String value){
        Type tCiudad = new TypeToken<Ciudad>(){}.getType();
        Gson g = new Gson();
        Ciudad ciudad = g.fromJson(value, tCiudad);
        
        CiudadSession csession = new CiudadSession();
        ciudad = csession.obtenerCiudad(ciudad.getCiu_id());
        ciudad.setActivo(false);
        csession.actualizarCiudad(ciudad);
        String err = "{\"respuesta\":\"'deleted'\"}";
        return Response.status(Response.Status.OK).entity(err).
                    header("Access-Control-Allow-Origin", "*").
                    header("Access-Control-Allow-Methods", "POST, GET,PUT, DELETE, OPTIONS, HEAD").
                    header("Access-Control-Allow-Headers", "origin,  content-type, accept, authorization, X-Requested-With").
                    header("Access-Control-Allow-Credentials", "true").
                    header("Access-Control-Allow-Max-Age", "1209600").build();        
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateCiudad")
    public Response updateCiudad(String value){
        Type tCiudad = new TypeToken<Ciudad>(){}.getType();
        Gson g = new Gson();        
        Ciudad ciudad = g.fromJson(value, tCiudad);        
        CiudadSession ciudadSession = new CiudadSession();
        
        try {
            if(ciudad.validarCiudad()){
                ciudad.setActivo(Boolean.TRUE);
                ciudadSession.actualizarCiudad(ciudad);
            }else{
                System.err.println("La entidad Ciudad no pasó la validación");
            }            
            return Response.status(Response.Status.OK).entity(g.toJson(ciudad)).
                    header("Access-Control-Allow-Origin", "*").
                    header("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS, HEAD").
                    header("Access-Control-Allow-Headers", "origin,  content-type, accept, authorization, X-Requested-With").
                    header("Access-Control-Allow-Credentials", "true").
                    header("Access-Control-Allow-Max-Age", "1209600").build();
        } catch (Exception e) {
            String err = "{\"respuesta\":\""+e.getMessage()+"\"}";
            return Response.status(Response.Status.OK).entity(err).
                    header("Access-Control-Allow-Origin", "*").
                    header("Access-Control-Allow-Methods", "POST, GET,PUT, DELETE, OPTIONS, HEAD").
                    header("Access-Control-Allow-Headers", "origin,  content-type, accept, authorization, X-Requested-With").
                    header("Access-Control-Allow-Credentials", "true").
                    header("Access-Control-Allow-Max-Age", "1209600").build();           
        }        
    } 
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/searchCity/{inicio}/{fin}/{city}")
    public Response searchCiudad(@PathParam("inicio") int inicio, @PathParam("fin") int fin, @PathParam("city") String city) {
        CiudadSession ciudadSession = new CiudadSession();        
        if(city.isEmpty()){
            city = "";
        }
        List<Ciudad> listaCiudad = ciudadSession.searchCiudad(inicio, fin, city);
        Gson g = new Gson();
        return Response.status(Response.Status.OK).entity(g.toJson(g.toJson(listaCiudad))).
                header("Access-Control-Allow-Origin", "*").
                header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").
                header("Access-Control-Allow-Headers", "origin,  content-type, accept, authorization, X-Requested-With").
                header("Access-Control-Allow-Credentials", "true").
                header("Access-Control-Allow-Max-Age", "1209600").build();
        
    }

    /**
     * PUT method for updating or creating an instance of WFResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
