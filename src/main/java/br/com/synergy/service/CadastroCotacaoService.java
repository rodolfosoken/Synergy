package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.Cotacao;
import br.com.synergy.repository.Cotacoes;

public class CadastroCotacaoService implements Serializable, CadastroService<Cotacao>{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cotacoes cotacoes;

	@Override
	public void salvar(Cotacao cotacao)throws Exception{
		cotacoes.guardar(cotacao);
	}
	
	@Override
	public void excluir(Cotacao cotacao)throws Exception{
		cotacoes.excluir(cotacao);
	}
	
	
}
