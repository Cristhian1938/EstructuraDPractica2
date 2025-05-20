package com.unl.hola.base.controller.data_struct.stack;

public class stack <E> {
    private StackImplementation<E> stack;
    public void Stack(Integer top){
        stack = new StackImplementation<>(top);
    }

    
    public Boolean push(E data){
        try {
            stack.push(data);
            return true;
        } catch (Exception e) {
            return false;
            // TODO: handle exception
        }
    }

    public E pop(){
        try {
            return stack.pop();
        } catch (Exception e) {
            return null;
            // TODO: handle exception
        }
    }

    public Boolean isFullStack(){
        return stack.isFullStack();
    }

    public Integer top(){
        return stack.getTop();
    }

    public Integer size(){
        return stack.getLength();
    }
}
