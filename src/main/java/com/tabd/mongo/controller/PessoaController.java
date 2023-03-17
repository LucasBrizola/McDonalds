package com.tabd.mongo.controller;

import com.tabd.mongo.model.Pessoa;
import com.tabd.mongo.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="mongo")
public class PessoaController {
    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    @GetMapping(value="/pessoas")
    public ResponseEntity<List<Pessoa>> obterPessoas() {
        List<Pessoa> pessoas = pessoaService.list();
        return new ResponseEntity<List<Pessoa>>(pessoas, HttpStatus.OK) ;
    }

    @GetMapping(value="/pessoa/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        Optional<Pessoa> pessoa = this.pessoaService.findById(id);
        return new ResponseEntity<Optional<Pessoa>>(pessoa,HttpStatus.OK);
    }

    @GetMapping(value="/pessoa/{name}")
    public ResponseEntity<?> findByName(@PathVariable("name") String name) {
        Pessoa pessoa = this.pessoaService.findByName(name);
        return new ResponseEntity<Pessoa>(pessoa,HttpStatus.OK);
    }

    @PostMapping(value="/pessoa")
    public ResponseEntity<?> salvar(@RequestBody Pessoa pessoa) {
        this.pessoaService.save(pessoa);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value="/pessoa/{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Integer id) {
        this.pessoaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
