package com.nodebounty.cartao.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nodebounty.cartao.model.Cartao;
import com.nodebounty.cartao.model.ICartaoRepository;

import jakarta.el.ELException;

@Service
public class CartaoServico implements ICartaoServico {
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    ICartaoRepository repository;

    @Override
    public List<Cartao> consultaCartao() {
        return repository.findAll();
    }


    public boolean gerarCartao(){
        Cartao novoCartao =new Cartao();
        try{
            repository.save(novoCartao);
            return true;
        }
        catch(ELException e){
            logger.info(e);
            return false;
        }
        
    }
    
    public boolean excluiCartao(Long cartaoId) {
        Optional<Cartao> cartaoOptional = repository.findById(cartaoId);

        if (cartaoOptional.isPresent()) {
            repository.delete(cartaoOptional.get());
            logger.info("Cartão com ID " + cartaoId + " excluído com sucesso.");
            return true;
        } else {
            logger.info("Tentativa de exclusão de um cartão inexistente com ID " + cartaoId);
            return false;
        }
    }
}
