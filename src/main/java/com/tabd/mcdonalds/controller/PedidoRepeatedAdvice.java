package com.tabd.mcdonalds.controller;

import com.tabd.mcdonalds.service.PedidoRepeatedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PedidoRepeatedAdvice {
    @ResponseBody
    @ExceptionHandler(PedidoRepeatedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String pedidoRepeatedHandler(PedidoRepeatedException ex) {
        return ex.getMessage();
    }
}
