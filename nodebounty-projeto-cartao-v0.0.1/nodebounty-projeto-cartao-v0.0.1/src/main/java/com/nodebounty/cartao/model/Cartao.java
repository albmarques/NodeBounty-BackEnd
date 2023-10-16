package com.nodebounty.cartao.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) // manipula - lazy loaded properties
@Entity

public class Cartao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// Preencher o objeto cartao1 com valores
	private Long idCartao = 1L;
	private String titularCartao = "João Silva";
	private LocalDate validadeCartao = LocalDate.of(2025, 12, 31); // Representa 31 de dezembro de 2025
	private String numeroCartao = "1234567890123456"; // Número do cartão como String
	private Short cvcCartao = 123;

	public Cartao(Long idCartao, String titularCartao, LocalDate validadeCartao, String numeroCartao, Short cvcCartao) {
		setIdCartao(idCartao);
		setTitularCartao(titularCartao);
		setValidadeCartao(validadeCartao);
		setNumeroCartao(numeroCartao);
		setCvcCartao(cvcCartao);
	}
	
	public Cartao() {
		
	}
	
	


	public Long getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(Long idCartao) {
		this.idCartao = idCartao;
	}

	public String getTitularCartao() {
		return titularCartao;
	}

	public void setTitularCartao(String titularCartao) {
		this.titularCartao = titularCartao;
	}

	public LocalDate getValidadeCartao() {
		return validadeCartao;
	}

	public void setValidadeCartao(LocalDate validadeCartao) {
		this.validadeCartao = validadeCartao;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public Short getCvcCartao() {
		return cvcCartao;
	}

	public void setCvcCartao(Short cvcCartao) {
		this.cvcCartao = cvcCartao;
	}

}