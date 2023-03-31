package com.tabd.mcdonalds.service;

import com.tabd.mcdonalds.model.McDonalds;
import com.tabd.mcdonalds.repository.McDonaldsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class McDonaldsService {

    private McDonaldsRepository mcDonaldsRepository;

    public McDonaldsService(McDonaldsRepository mcDonaldsRepository){
        this.mcDonaldsRepository = mcDonaldsRepository;
    }

    public void save(McDonalds mcDonalds){
        this.mcDonaldsRepository.save(mcDonalds);
    }

    public void delete(Integer n_Pedido){
        this.mcDonaldsRepository.deleteById(n_Pedido);
    }

    public Optional<McDonalds> findById(Integer n_Pedido){
        return this.mcDonaldsRepository.findById(n_Pedido);
    }

    public List<McDonalds> list() {
        return this.mcDonaldsRepository.findAll();
    }

    public void update(Integer n_Pedido, McDonalds mcDonaldsNovo){
        Optional<McDonalds> mcDonaldsAntigo = this.mcDonaldsRepository.findById(n_Pedido);
        mcDonaldsNovo.setN_Pedido(mcDonaldsAntigo.get().getN_Pedido());
        this.mcDonaldsRepository.save(mcDonaldsNovo);
    }
}
