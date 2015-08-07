package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.CotacaoMaterial;
import br.com.synergy.repository.Cotacoes;
import br.com.synergy.util.Transacional;

public class CadastroCotacaoMaterialService implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private Cotacoes cotacoes;

	
	@Transacional
	public void salvar(CotacaoMaterial cotacao){
		cotacoes.guardar(cotacao);

	}

}
