package com.unl.hola.base.controller.dao.dao_models;
import com.unl.hola.base.controller.dao.AdapterDao;
import com.unl.hola.base.models.Genero;

public class DaoGenero extends AdapterDao<Genero> {
    private Genero obj;

    public DaoGenero() {
        super(Genero.class);
        // TODO Auto-generated constructor stub
    }

    //getter and setter
    public Genero getObj() {
        if (obj == null) {
            this.obj = new Genero();
            
        }
        return this.obj;
    }

    public void setObj(Genero obj) {
        this.obj = obj;
    }

    public Boolean save() {
        try {
            obj.setId(listAll().getLength()+1);
            this.persist(obj);
            return true;
        } catch (Exception e) {
            //LOG DE ERROR
            e.printStackTrace();
            System.out.println(e);
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
    
    public static void main(String[] args) {
        DaoGenero dg = new DaoGenero();
        dg.getObj().setId(dg.listAll().getLength() + 1);
        dg.getObj().setNombre("Rap");
        if (dg.save())
            System.out.println("GUARDADO");
        else
            System.out.println("Hubo un error");   
    }

}