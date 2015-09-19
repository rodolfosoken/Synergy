package br.com.synergy.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.synergy.model.Conjunto;
import br.com.synergy.model.Ferramenta;
import br.com.synergy.model.Montagem;
import br.com.synergy.model.Peca;
import br.com.synergy.repository.Conjuntos;
import br.com.synergy.repository.Ferramentas;
import br.com.synergy.repository.Pecas;
import br.com.synergy.service.CadastroConjuntoService;
import br.com.synergy.util.FacesMessages;

@Named
@ViewScoped
public class ConjuntoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private FacesMessages messages;

	@Inject
	private CadastroConjuntoService cadastro;

	@Inject
	private Ferramentas ferramentas;

	@Inject
	private Pecas pecas;

	@Inject
	private Conjuntos conjuntos;

	private Conjunto conjuntoEdicao;
	private Conjunto conjuntoSelecionado;
	private Montagem montagem;
	private Montagem montagemSelecionada;
	private List<Conjunto> todos;
	private Ferramenta ferramentaEdicao;
	private Ferramenta ferramentaSelecionada;
	private Peca pecaEdicao;
	private Peca pecaSelecionada;
	
	
	private int quantidadePeca;
	private int quantidadeFerramenta;

	
	public void consultar(){
		this.todos = conjuntos.todos();
	}
	
	public ConjuntoBean() {
		limpar();
	}

	private void limpar() {
		conjuntoEdicao = new Conjunto();
		ferramentaEdicao=new Ferramenta();
		pecaEdicao = new Peca();
		montagem = new Montagem();
		montagemSelecionada = null;
		quantidadePeca = 1;
		quantidadeFerramenta=1;
	}
	
	public void adicionarPeca(){
		for (int i = 0; i < quantidadePeca; i++) {
		conjuntoEdicao.getPecas().add(pecaEdicao);		
		pecaEdicao.getConjuntos().add(conjuntoEdicao);
		}
		pecaEdicao = new Peca();
		quantidadePeca=1;
	}
	
	public void removerPeca(){
		pecaSelecionada.getConjuntos().remove(conjuntoEdicao);
		conjuntoEdicao.getPecas().remove(pecaSelecionada);
	}
	
	public void adicionarFerramenta(){
		for (int i = 0; i < quantidadeFerramenta; i++) {
		ferramentaEdicao.getConjuntos().add(conjuntoEdicao);
		conjuntoEdicao.getFerramentas().add(ferramentaEdicao);
		}
		ferramentaEdicao=new Ferramenta();
		quantidadeFerramenta=1; 
	}
	
	public void removerFerramenta(){
		ferramentaSelecionada.getConjuntos().remove(conjuntoEdicao);
		conjuntoEdicao.getFerramentas().remove(ferramentaSelecionada);
	}

	public void adicionarMontagem() {
		montagem.getPeca().getMontagems().add(montagem);
		montagem.getFerramenta().getMontagems().add(montagem);
		montagem.setConjunto(conjuntoEdicao);
		conjuntoEdicao.getMontagems().add(montagem);
		montagem = new Montagem();
	}

	public void removerMontagem() {
		if (montagemSelecionada != null) {
			montagemSelecionada.getPeca().getMontagems()
					.remove(montagemSelecionada);
			montagemSelecionada.getFerramenta().getMontagems()
					.remove(montagemSelecionada);
			conjuntoEdicao.getMontagems().remove(montagemSelecionada);

			montagemSelecionada = null;
		} else {
			messages.error("Selecione uma montagem para remover.");
			RequestContext.getCurrentInstance().update(":frm:messages");
		}
	}

	public void salvarConjunto() {
		cadastro.guardar(conjuntoEdicao);
		limpar();
		messages.info("Conjunto cadastrado com sucesso!");
		RequestContext.getCurrentInstance().update("frm");
	}

	public void editarConjunto() {
			conjuntoEdicao = conjuntoSelecionado;
	
	}
	
	public List<Ferramenta> completarFerramenta(String nome) {
		return ferramentas.buscaPorFerramentaNome(nome);
	}

	public List<Peca> completarPeca(String nome) {
		return pecas.buscaPorPecaNome(nome);
	}


	// getters e setters
		
	public List<Conjunto> getTodos() {
		return this.todos;
	}

	public Ferramenta getFerramentaSelecionada() {
		return ferramentaSelecionada;
	}

	public void setFerramentaSelecionada(Ferramenta ferramentaSelecionada) {
		this.ferramentaSelecionada = ferramentaSelecionada;
	}

	public int getQuantidadePeca() {
		return quantidadePeca;
	}

	public void setQuantidadePeca(int quantidadePeca) {
		this.quantidadePeca = quantidadePeca;
	}

	public int getQuantidadeFerramenta() {
		return quantidadeFerramenta;
	}

	public void setQuantidadeFerramenta(int quantidadeFerramenta) {
		this.quantidadeFerramenta = quantidadeFerramenta;
	}

	public Peca getPecaSelecionada() {
		return pecaSelecionada;
	}

	public void setPecaSelecionada(Peca pecaSelecionada) {
		this.pecaSelecionada = pecaSelecionada;
	}

	public Ferramenta getFerramentaEdicao() {
		return ferramentaEdicao;
	}

	public void setFerramentaEdicao(Ferramenta ferramentaEdicao) {
		this.ferramentaEdicao = ferramentaEdicao;
	}

	public Peca getPecaEdicao() {
		return pecaEdicao;
	}

	public void setPecaEdicao(Peca pecaEdicao) {
		this.pecaEdicao = pecaEdicao;
	}

	public Conjunto getConjuntoEdicao() {
		return conjuntoEdicao;
	}

	public void setConjuntoEdicao(Conjunto conjuntoEdicao) {
		this.conjuntoEdicao = conjuntoEdicao;
	}

	public Montagem getMontagem() {
		return montagem;
	}

	public void setMontagem(Montagem montagem) {
		this.montagem = montagem;
	}

	public Montagem getMontagemSelecionada() {
		return montagemSelecionada;
	}

	public void setMontagemSelecionada(Montagem montagemSelecionada) {
		this.montagemSelecionada = montagemSelecionada;
	}

	public Conjunto getConjuntoSelecionado() {
		return conjuntoSelecionado;
	}

	public void setConjuntoSelecionado(Conjunto conjuntoSelecionado) {
		this.conjuntoSelecionado = conjuntoSelecionado;
	}

}
