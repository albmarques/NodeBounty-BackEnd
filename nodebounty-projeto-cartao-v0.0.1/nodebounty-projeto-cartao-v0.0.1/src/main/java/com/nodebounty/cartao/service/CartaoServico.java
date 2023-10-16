package com.nodebounty.cartao.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nodebounty.cartao.model.Cartao;
import com.nodebounty.cartao.model.ICartaoRepository;

@Service
public class CartaoServico implements ICartaoServico {
    Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    ICartaoRepository repository;

    @Override
    public List<Cartao> consultaCartao() {
        return repository.findAll();
    }
}
