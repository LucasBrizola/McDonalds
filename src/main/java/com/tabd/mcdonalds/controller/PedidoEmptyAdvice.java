package com.tabd.mcdonalds.controller;

import com.tabd.mcdonalds.service.PedidoEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PedidoEmptyAdvice {
    @ResponseBody
    @ExceptionHandler(PedidoEmptyException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    String pedidoEmptyHandler(PedidoEmptyException ex) {
        return ex.getMessage();
    }
}
