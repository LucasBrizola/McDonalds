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
        if(mcDonaldsRepository.findById(mcDonalds.getN_Pedido()).isPresent()){
            throw new PedidoRepeatedException(mcDonalds.getN_Pedido());
        }
        if(verifyFields(mcDonalds)){
            this.mcDonaldsRepository.save(mcDonalds);
        }
    }

    public void delete(Integer n_Pedido){
        if(mcDonaldsRepository.findById(n_Pedido).isPresent()){
            this.mcDonaldsRepository.deleteById(n_Pedido);
        }
        else throw new PedidoNotFoundException(n_Pedido);
    }

    public McDonalds findById(Integer n_Pedido){
        return mcDonaldsRepository.findById(n_Pedido)
                .orElseThrow(() -> new PedidoNotFoundException(n_Pedido));
    }

    public List<McDonalds> list() {
        List<McDonalds> lista = this.mcDonaldsRepository.findAll();
        if (lista.isEmpty()){
            throw( new PedidoEmptyException());
        }
        else return lista;
    }

    public void update(Integer n_Pedido, McDonalds mcDonaldsNew){
        McDonalds mcDonaldsOld = this.findById(n_Pedido);
        replaceFields(mcDonaldsNew, mcDonaldsOld);
        this.mcDonaldsRepository.save(mcDonaldsNew);
    }

    private boolean verifyFields(McDonalds mcDonalds){
        if(mcDonalds.getN_Pedido() == 0
                || mcDonalds.getItem() == null
                || mcDonalds.getQtd() == 0
                || mcDonalds.getValor() == 0.0
        ){
            throw new PedidoMissingValueException();
        }
        return true;
    }

    private McDonalds replaceFields(McDonalds mcDonaldsNew, McDonalds mcDonaldsOld){
        mcDonaldsNew.setN_Pedido(mcDonaldsOld.getN_Pedido());

        if(mcDonaldsNew.getItem() == null){
            mcDonaldsNew.setItem(mcDonaldsOld.getItem());
        }

        if(mcDonaldsNew.getValor() == 0.0){
            mcDonaldsNew.setValor(mcDonaldsOld.getValor());
        }

        if(mcDonaldsNew.getQtd() == 0){
            mcDonaldsNew.setQtd(mcDonaldsOld.getQtd());
        }
        return mcDonaldsNew;
    }
}
