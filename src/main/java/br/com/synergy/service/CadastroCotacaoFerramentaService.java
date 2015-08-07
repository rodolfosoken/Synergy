package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.CotacaoFerramenta;
import br.com.synergy.repository.CotacoesFerramentas;
import br.com.synergy.util.Transacional;

public class CadastroCotacaoFerramentaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CotacoesFerramentas cotacoes;

	@Transacional
	public void salvar(CotacaoFerramenta cotacao){
		cotacoes.guardar(cotacao);
	}
	
}
