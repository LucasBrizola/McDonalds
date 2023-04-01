package com.tabd.mcdonalds.controller;

import com.tabd.mcdonalds.service.PedidoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PedidoNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PedidoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String pedidoNotFoundHandler(PedidoNotFoundException ex) {
        return ex.getMessage();
    }
}
