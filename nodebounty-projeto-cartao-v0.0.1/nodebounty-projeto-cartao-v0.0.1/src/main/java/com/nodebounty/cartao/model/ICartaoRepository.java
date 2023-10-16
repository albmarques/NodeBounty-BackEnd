package com.nodebounty.cartao.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartaoRepository extends JpaRepository<Cartao, Long> {
	public List<Cartao> findAllByIdCartao(Long idCartao);

}