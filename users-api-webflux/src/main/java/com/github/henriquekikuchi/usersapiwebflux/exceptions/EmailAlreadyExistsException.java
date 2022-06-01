package com.github.henriquekikuchi.usersapiwebflux.exceptions;

import java.io.IOException;

public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
