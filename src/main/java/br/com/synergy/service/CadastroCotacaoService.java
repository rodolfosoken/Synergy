package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.Cotacao;
import br.com.synergy.repository.Cotacoes;
import br.com.synergy.util.Transacional;

public class CadastroCotacaoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cotacoes cotacoes;

	@Transacional
	public void salvar(Cotacao cotacao)throws Exception{
		cotacoes.guardar(cotacao);
	}
	
	@Transacional
	public void excluir(Cotacao cotacao)throws Exception{
		cotacoes.excluir(cotacao);
	}
	
	
}
