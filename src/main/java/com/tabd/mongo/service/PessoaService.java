package com.tabd.mongo.service;

import com.tabd.mongo.model.Pessoa;
import com.tabd.mongo.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public void save(Pessoa pessoa){
        this.pessoaRepository.save(pessoa);
    }

    public void delete(Integer id){
        this.pessoaRepository.deleteById(id);
    }

    public Optional<Pessoa> findById(Integer id){
        return this.pessoaRepository.findById(id);
    }

    public Pessoa findByName(String name){
        return this.pessoaRepository.findByName(name);
    }

    public List<Pessoa> list() {
        return this.pessoaRepository.findAll();
    }

    public void update(Integer id, Pessoa pessoaNova){
        Optional<Pessoa> pessoaAntiga = this.pessoaRepository.findById(id);
        pessoaNova.setId(pessoaAntiga.get().getId());
        this.pessoaRepository.save(pessoaNova);
    }
}
