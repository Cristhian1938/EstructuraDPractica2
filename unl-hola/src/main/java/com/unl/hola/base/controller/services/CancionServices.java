package com.unl.hola.base.controller.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.unl.hola.base.controller.dao.dao_models.DaoAlbum;
import com.unl.hola.base.controller.dao.dao_models.DaoCancion;
import com.unl.hola.base.controller.dao.dao_models.DaoGenero;
import com.unl.hola.base.models.Album;
import com.unl.hola.base.models.Cancion;
import com.unl.hola.base.models.Genero;
import com.unl.hola.base.models.TipoArchivoEnum;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;

import jakarta.validation.constraints.NotEmpty;

@BrowserCallable
@AnonymousAllowed


public class CancionServices {
    private DaoCancion Dc;
    public CancionServices() {
        Dc = new DaoCancion();
    }

    public void create(@NotEmpty String nombre, Integer id_genero, Integer duracion, @NotEmpty String url, @NotEmpty String tipo, Integer id_album) throws Exception{
        if(nombre.trim().length() > 0 && url.trim().length() > 0 && tipo.trim().length() > 0 && duracion > 0 && id_genero > 0 && id_album > 0)
            Dc.getObj().setNombre(nombre);
            Dc.getObj().setDuracion(duracion);
            Dc.getObj().setId_album(id_album);
            Dc.getObj().setTipo(TipoArchivoEnum.valueOf(tipo));
            Dc.getObj().setUrl(url);
            Dc.getObj().setId_genero(id_genero);
            if(!Dc.save())
                throw new  Exception("No se pudo guardar los datos de Cancion");
    }

    public void update(@NotEmpty Integer id, @NotEmpty String nombre, Integer id_genero, Integer duracion, @NotEmpty String url, @NotEmpty String tipo, Integer id_album) throws Exception{
       if(nombre.trim().length() > 0 && url.trim().length() > 0 && tipo.trim().length() > 0 && duracion > 0 && id_genero > 0 && id_album > 0)
            Dc.setObj(Dc.listAll().get(id - 1));
            Dc.getObj().setNombre(nombre);
            Dc.getObj().setDuracion(duracion);
            Dc.getObj().setId_album(id_album);
            Dc.getObj().setTipo(TipoArchivoEnum.valueOf(tipo));
            Dc.getObj().setUrl(url);
            Dc.getObj().setId_genero(id_genero);
            if(!Dc.update(id - 1))
                throw new  Exception("No se pudo guardar los datos de Cancion");
    }

    

    public List<HashMap> listaAlbumCombo(){
        List<HashMap> lista = new ArrayList<>();
        DaoAlbum Da = new DaoAlbum();
        if(!Da.listAll().isEmpty()) {
            Album [] arreglo = Da.listAll().toArray();
            for(int i = 0; i < arreglo.length; i++){
                HashMap<String, String> aux = new HashMap<>();
                aux.put("value", arreglo[i].getId().toString(i)); 
                aux.put("label", arreglo[i].getNombre());   
                lista.add(aux);   
            }
        }
        return lista;
    }


    public List<HashMap> listaGeneroCombo(){
        List<HashMap> lista = new ArrayList<>();
        DaoGenero Dg = new DaoGenero();
        if(!Dg.listAll().isEmpty()) {
            Genero [] arreglo = Dg.listAll().toArray();
            for(int i = 0; i < arreglo.length; i++){
                HashMap<String, String> aux = new HashMap<>();
                aux.put("value", arreglo[i].getId().toString(i)); 
                aux.put("label", arreglo[i].getNombre());  
                lista.add(aux);    
            }
        }
        return lista;
    }

    public List<String> listTipo() {
        List<String> lista = new ArrayList<>();
        for(TipoArchivoEnum r: TipoArchivoEnum.values()) {
            lista.add(r.toString());
        }        
        return lista;
    }



    public List<HashMap> listCancion(){
        List<HashMap> lista = new ArrayList<>();
        if(!Dc.listAll().isEmpty()) {
            Cancion [] arreglo = Dc.listAll().toArray();
           
            for(int i = 0; i < arreglo.length; i++) {
                
                HashMap<String, String> aux = new HashMap<>();
                aux.put("id", arreglo[i].getId().toString(i));                
                aux.put("nombre", arreglo[i].getNombre());
                aux.put("genero", new DaoGenero().listAll().get(arreglo[i].getId_genero() - 1).getNombre());
                aux.put("id_genero", new DaoGenero().listAll().get(arreglo[i].getId_genero() - 1).getId().toString());
                aux.put("album", new DaoAlbum().listAll().get(arreglo[i].getId_album() - 1).getNombre());
                aux.put("id_album", new DaoAlbum().listAll().get(arreglo[i].getId_album() - 1).getId().toString());
                aux.put("duracion", arreglo[i].getDuracion().toString());
                aux.put("url", arreglo[i].getUrl());
                aux.put("tipo", arreglo[i].getTipo().toString());
                lista.add(aux);
            }
        }
        return lista;
    }

}
