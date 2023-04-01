package com.tabd.mcdonalds.controller;

import com.tabd.mcdonalds.model.McDonalds;
import com.tabd.mcdonalds.service.McDonaldsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="mcdonalds")
public class McDonaldsController {
    private McDonaldsService mcDonaldsService;

    public McDonaldsController(McDonaldsService mcDonaldsService){
        this.mcDonaldsService = mcDonaldsService;
    }

    @GetMapping(value="/cardapio")
    public ResponseEntity<List<McDonalds>> obterPessoas() {
        List<McDonalds> mcdonalds = mcDonaldsService.list();
        return new ResponseEntity<List<McDonalds>>(mcdonalds, HttpStatus.OK) ;
    }

    @GetMapping(value="/cardapio/{n_Pedido}")
    public ResponseEntity<?> findById(@PathVariable("n_Pedido") Integer n_Pedido) {
        Optional<McDonalds> mcDonalds = Optional.ofNullable(this.mcDonaldsService.findById(n_Pedido));
        return new ResponseEntity<Optional<McDonalds>>(mcDonalds,HttpStatus.OK);
    }

    @PostMapping(value="/cardapio")
    public ResponseEntity<?> salvar(@RequestBody McDonalds mcDonalds) {
        this.mcDonaldsService.save(mcDonalds);
        return new ResponseEntity<McDonalds>(mcDonalds,HttpStatus.OK);
    }

    @PutMapping(value="/cardapio/{n_Pedido}")
    public ResponseEntity<?> editar(@PathVariable("n_Pedido") Integer n_Pedido, @RequestBody McDonalds mcDonalds) {
        this.mcDonaldsService.update(n_Pedido, mcDonalds);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value="/cardapio/{n_Pedido}")
    public ResponseEntity<?> deletar(@PathVariable("n_Pedido") Integer n_Pedido) {
        this.mcDonaldsService.delete(n_Pedido);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
