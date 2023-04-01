package com.tabd.mcdonalds.controller;

import com.tabd.mcdonalds.service.PedidoMissingValueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PedidoMissingValueAdvice {
    @ResponseBody
    @ExceptionHandler(PedidoMissingValueException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    String PedidoMissingValueHandler(PedidoMissingValueException ex) {
        return ex.getMessage();
    }
}
