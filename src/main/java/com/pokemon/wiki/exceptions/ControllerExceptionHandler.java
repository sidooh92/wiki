package com.pokemon.wiki.exceptions;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "com.pokemon.wiki.controllers")
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {EmptyPokemonException.class, PokemonDoNotExistException.class})
    public ResponseEntity<Object> handlerError(Exception ex, WebRequest webRequest) {
        String bodyError = "This is our error about pokemons";

        return handleExceptionInternal(ex, bodyError, new HttpHeaders(), HttpStatus.I_AM_A_TEAPOT, webRequest);

    }


}
