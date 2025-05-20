package com.unl.hola.base.controller.dao.dao_models;
import com.unl.hola.base.controller.dao.AdapterDao;
import com.unl.hola.base.models.Cancion;


public class DaoCancion extends AdapterDao<Cancion> {
    private Cancion obj;

    public DaoCancion() {
        super(Cancion.class);
        // TODO Auto-generated constructor stub
    }

    //getter and setter
    public Cancion getObj() {
        if (obj == null) {
            this.obj = new Cancion();
            
        }
        return this.obj;
    }

    public void setObj(Cancion obj) {
        this.obj = obj;
    }

    public Boolean save() {
        try {
            this.persist(obj);
            return true;
        } catch (Exception e) {
            //LOG DE ERROR
            return false;
            // TODO: handle exception
        }
    }

    public Boolean update(Integer pos) {
        try {
            this.update(obj, pos);
            return true;
        } catch (Exception e) {
            return false;
            // TODO: handle exception
        }
    }
}
