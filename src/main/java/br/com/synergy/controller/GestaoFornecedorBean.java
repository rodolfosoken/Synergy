package br.com.synergy.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.synergy.model.FornecedorFerramenta;
import br.com.synergy.repository.DAOFornecedorFerramenta;
import br.com.synergy.util.FacesMessages;

@Named
@ViewScoped
public class GestaoFornecedorBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private DAOFornecedorFerramenta dao;
	@SuppressWarnings("unused")
	@Inject
	private FacesMessages messages;
	
	private List<FornecedorFerramenta> todosFornecedores;
	private FornecedorFerramenta fornecedorSelecionado;
	private FornecedorFerramenta fornecedorEdicao = new FornecedorFerramenta();
	
	
	//limpa a instancia do fornecedor do dialogo
	public void prepararCadastro(){
		fornecedorEdicao = new FornecedorFerramenta();
	}
	
	//funções
	public void consultar() {
	todosFornecedores = dao.listarTodos();
	}
	
	public List<FornecedorFerramenta> getTodosFornecedores() {
		return todosFornecedores;
	}
	
	public void salvar(){
		dao.guardar(fornecedorEdicao);
		System.out.println("gravou");		
	}
	
	
	//getters e setters
	public FornecedorFerramenta getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}
	public void setFornecedorSelecionado(FornecedorFerramenta fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}
	public FornecedorFerramenta getFornecedorEdicao() {
		return fornecedorEdicao;
	}
	public void setFornecedorEdicao(FornecedorFerramenta fornecedorEdicao) {
		this.fornecedorEdicao = fornecedorEdicao;
	}
}
