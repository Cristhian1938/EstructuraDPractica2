package com.unl.hola.base.controller.data_struct.queue;
import com.unl.hola.base.controller.data_struct.list.LinkedList;

public class QueueImplementation<E> extends LinkedList<E>{
    private Integer top;

    public Integer getTop() {
        return this.top;
    }

    public QueueImplementation(Integer top){
        this.top = top;
    }

    protected Boolean isFullQueque() {
        return this.top >= getLength();
    }

    protected void queue(E info) throws Exception {
        if(!isFullQueque()) {
            add(info);
        } else {
            throw new ArrayIndexOutOfBoundsException("Queque full");
        }
    }
    protected E dequeue() throws Exception {       
        return deleteFirst();
        
    }


}
