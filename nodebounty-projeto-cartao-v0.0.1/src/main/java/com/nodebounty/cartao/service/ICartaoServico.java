package com.nodebounty.cartao.service;
import java.util.List;
import com.nodebounty.cartao.model.Cartao;
public interface ICartaoServico {
	public List<Cartao> consultaCartao();
	boolean excluiCartao(Long cartaoId);
	public boolean gerarCartao();
}
