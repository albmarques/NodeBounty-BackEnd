package com.nodebounty.cartao.model;

import java.time.LocalDate;
import java.util.Random;

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
	private LocalDate validadeCartao = LocalDate.of(2025, 12, 31); // Representa 31 de dezembro de 2025
	private String numeroCartao = "1234567890123456"; // Número do cartão como String
	private Short cvcCartao = 123;

	public Cartao(Long idCartao, LocalDate validadeCartao, String numeroCartao, Short cvcCartao) {
		setIdCartao(idCartao);
		setValidadeCartao(validadeCartao);
		setNumeroCartao(numeroCartao);
		setCvcCartao(cvcCartao);
	}
	
	public Cartao() {
		gerarCartao();
	}
	
	public void gerarCartao(){
		setValidadeCartao(gerarValidade());
		setNumeroCartao(gerarNumero());
		setCvcCartao(gerarCvc());
	}

	private static Short gerarCvc() {
        Random random = new Random();
        return (short) (100 + random.nextInt(900));
    }

	private static String gerarNumero() {
        Random random = new Random();
        StringBuilder numeroCartao = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            int digito = random.nextInt(10);
            numeroCartao.append(digito);
        }

        return numeroCartao.toString();
    }

	private static LocalDate gerarValidade() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate validadeCartao = dataAtual.plusYears(1); // Adicione 1 ano à data atual
        return validadeCartao;
    }



	public Long getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(Long idCartao) {
		this.idCartao = idCartao;
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