package br.com.mathdebortoli.controllers.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnSupportedMathOperation extends RuntimeException{
    public UnSupportedMathOperation(String message){
        super(message);
    }
}
