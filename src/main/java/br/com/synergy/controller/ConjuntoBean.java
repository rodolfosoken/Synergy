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

	public ConjuntoBean() {
		limpar();
	}

	private void limpar() {
		conjuntoEdicao = new Conjunto();
		montagem = new Montagem();
		montagemSelecionada =null;
	}

	public List<Ferramenta> completarFerramenta(String nome) {
		return ferramentas.buscaPorFerramentaNome(nome);
	}

	public List<Peca> completarPeca(String nome) {
		return pecas.buscaPorPecaNome(nome);
	}

	public void adicionarMontagem() {
		montagem.getPeca().getMontagems().add(montagem);
		montagem.getFerramenta().getMontagems().add(montagem);
		montagem.setConjunto(conjuntoEdicao);
		conjuntoEdicao.getMontagems().add(montagem);
		montagem= new Montagem();
	}
	
	public void removerMontagem(){
		if(montagemSelecionada!=null){
		montagemSelecionada.getPeca().getMontagems().remove(montagemSelecionada);
		montagemSelecionada.getFerramenta().getMontagems().remove(montagemSelecionada);
		conjuntoEdicao.getMontagems().remove(montagemSelecionada);
		
		montagemSelecionada= null;
		}else{
			messages.error("Selecione uma montagem para remover.");
			RequestContext.getCurrentInstance().update(":frm:messages");
		}
	}
	
	public void salvarConjunto(){
		cadastro.guardar(conjuntoEdicao);
		limpar();
		messages.info("Conjunto cadastrado com sucesso!");
		RequestContext.getCurrentInstance().update("frm");
	}
	

	public List<Conjunto> getTodos(){
		return conjuntos.todos();
	}
	

	// getters e setters

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
