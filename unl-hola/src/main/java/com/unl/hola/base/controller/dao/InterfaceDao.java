package com.unl.hola.base.controller.dao;

import com.unl.hola.base.controller.data_struct.list.LinkedList;

//datos genericos
public interface InterfaceDao <T> {
    public LinkedList<T> listAll();
    public void persist(T obj) throws Exception;
    public void update(T obj, Integer pos) throws Exception;
    public void update_by_id(T obj, Integer id) throws Exception;
    public T get(Integer id) throws Exception;
}