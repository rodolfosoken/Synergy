package br.com.synergy.controller;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.repository.Cotacoes;

public class CotacaoPesquisaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cotacoes cotacoes;

}
