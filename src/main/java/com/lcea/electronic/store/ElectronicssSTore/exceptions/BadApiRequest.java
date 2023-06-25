package com.lcea.electronic.store.ElectronicssSTore.exceptions;

public class BadApiRequest extends RuntimeException{
    public BadApiRequest(String message){
        super(message);
    }public BadApiRequest(){
        super("Bad Request!!");
    }

}
