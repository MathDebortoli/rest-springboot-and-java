package br.com.mathdebortoli.controllers.exception.handler;

import br.com.mathdebortoli.controllers.exception.ExceptionResponse;
import br.com.mathdebortoli.controllers.exception.UnSupportedMathOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handlerAllExceptions (Exception e, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(new Date(), e.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnSupportedMathOperation.class)
    public final ResponseEntity<ExceptionResponse> handlerBadResquestException (Exception e, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(new Date(), e.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
