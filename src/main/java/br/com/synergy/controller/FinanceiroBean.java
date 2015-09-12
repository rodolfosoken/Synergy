package br.com.synergy.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.synergy.model.Conta;
import br.com.synergy.model.Pep;
import br.com.synergy.repository.Contas;

@Named
@ViewScoped
public class FinanceiroBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Contas contas;
	
	private List<Conta> todas;
	private Conta contaSelecionada;
	private Conta contaEdicao;
	
	private Pep pepEdicao;
	private Pep pepSelecionada;
	
	
	public void consultar(){
	this.todas = contas.todasContas();
	}
	
	public void prepararNovoCadastro(){
		contaEdicao=new Conta();
		contaSelecionada =null;
		pepEdicao = new Pep();
		pepSelecionada=null;
		
	}
	
	public void adicionarPep(){
		pepEdicao.setConta(contaEdicao);
		contaEdicao.getPeps().add(pepEdicao);
		System.out.println("pep"+pepEdicao.getDescricao());
		pepEdicao = new Pep();
		pepSelecionada= null;
	}
	
	public void removerPep(){
		contaEdicao.getPeps().remove(pepSelecionada);
		pepSelecionada= null;
	}
	
	//getters e setters
	public List<Conta> getTodas(){
		return todas;
	}

	public Conta getContaSelecionada() {
		return contaSelecionada;
	}

	public void setContaSelecionada(Conta contaSelecionada) {
		this.contaSelecionada = contaSelecionada;
	}

	public Conta getContaEdicao() {
		return contaEdicao;
	}

	public void setContaEdicao(Conta contaEdicao) {
		this.contaEdicao = contaEdicao;
	}

	public Pep getPepEdicao() {
		return pepEdicao;
	}

	public void setPepEdicao(Pep pepEdicao) {
		this.pepEdicao = pepEdicao;
	}

	public Pep getPepSelecionada() {
		return pepSelecionada;
	}

	public void setPepSelecionada(Pep pepSelecionada) {
		this.pepSelecionada = pepSelecionada;
	}
	
	
	
	
}
