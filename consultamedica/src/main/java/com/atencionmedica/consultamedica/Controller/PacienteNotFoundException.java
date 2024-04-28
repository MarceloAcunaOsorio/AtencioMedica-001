package com.atencionmedica.consultamedica.Controller;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PacienteNotFoundException extends RuntimeException 
{
    public PacienteNotFoundException(String message)
    {
        super(message);
    }

}
