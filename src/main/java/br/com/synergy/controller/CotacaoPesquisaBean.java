package br.com.synergy.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.synergy.model.Cotacao;
import br.com.synergy.repository.Cotacoes;

@Named
@ViewScoped
public class CotacaoPesquisaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cotacoes cotacoes;
	
	private Cotacao cotacaoSelecionada;
	
	
	public List<Cotacao> getTodas(){
		return cotacoes.todas();
	}

	public Cotacao getCotacaoSelecionada() {
		return cotacaoSelecionada;
	}

	public void setCotacaoSelecionada(Cotacao cotacaoSelecionada) {
		this.cotacaoSelecionada = cotacaoSelecionada;
	}
	
	
	

}
