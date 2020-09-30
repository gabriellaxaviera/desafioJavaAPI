package com.gabriellaxavier.desafioconcrete.error;

public class EmailExistsException extends RuntimeException {

    public EmailExistsException(String message){

        super(message);

    }
}
