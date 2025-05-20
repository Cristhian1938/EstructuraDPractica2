package com.unl.hola.base.controller.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.Pageable;
import com.unl.hola.base.controller.dao.dao_models.DaoAlbum;
import com.unl.hola.base.models.Album;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;

import jakarta.validation.constraints.NotEmpty;

@BrowserCallable
@AnonymousAllowed


public class AlbumServices {
    private DaoAlbum Da;
    public AlbumServices() {
        Da = new DaoAlbum();
    }

    public void create(@NotEmpty String nombre) throws Exception{
        Da.getObj().setNombre(nombre);
        if(!Da.save())
            throw new  Exception("No se pudo guardar los datos del Album");
    }

    public void update(@NotEmpty Integer id, @NotEmpty String nombre) throws Exception{
        Da.setObj(Da.listAll().get(id));
        Da.getObj().setNombre(nombre);
        
        if(!Da.update(id))
            throw new  Exception("No se pudo modificar los datos del Album");
    }

    public List<Album> list(Pageable pageable) {        
        return Arrays.asList(Da.listAll().toArray());
    }

    public List<Album> listAll() {  
       // System.out.println("**********Entro aqui");  
        //System.out.println("lengthy "+Arrays.asList(da.listAll().toArray()).size());    
        return (List<Album>)Arrays.asList(Da.listAll().toArray());
    }
}
