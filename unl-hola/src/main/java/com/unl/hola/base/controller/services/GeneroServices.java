package com.unl.hola.base.controller.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.Pageable;
import com.unl.hola.base.controller.dao.dao_models.DaoGenero;
import com.unl.hola.base.models.Genero;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;

import jakarta.validation.constraints.NotEmpty;

@BrowserCallable
@AnonymousAllowed



public class GeneroServices {
    private DaoGenero dg;
    public GeneroServices() {
        dg = new DaoGenero();
    }

    public void createGenero(@NotEmpty String nombre) throws Exception{
        dg.getObj().setNombre(nombre);
        if(!dg.save())
            throw new  Exception("No se pudo guardar los datos de genero");
    }

    public void updateGenero(@NotEmpty Integer id, @NotEmpty String nombre) throws Exception{
        dg.setObj(dg.listAll().get(id));
        dg.getObj().setNombre(nombre);
        if(!dg.update(id))
            throw new  Exception("No se pudo modificar los datos de artista");
    }

    public List<Genero> list(Pageable pageable) {        
        return Arrays.asList(dg.listAll().toArray());
    }
    public List<Genero> listAll() {  
        return (List<Genero>)Arrays.asList(dg.listAll().toArray());
    }
}
