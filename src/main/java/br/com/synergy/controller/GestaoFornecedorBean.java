package br.com.synergy.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.synergy.model.FornecedorFerramenta;
import br.com.synergy.repository.FornecedorFerramentaDAO;
import br.com.synergy.service.CadastroFornecedorService;
import br.com.synergy.util.FacesMessages;

@Named
@ViewScoped
public class GestaoFornecedorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FornecedorFerramentaDAO dao;
	
	@Inject
	private CadastroFornecedorService cadastroFornecedor;
	
	@Inject
	private FacesMessages messages;
	
	private List<FornecedorFerramenta> todosFornecedores;
	
	private FornecedorFerramenta fornecedorEdicao = new FornecedorFerramenta();
	private FornecedorFerramenta fornecedorSelecionado;
	
	//metodos utilitários
	
	//metodo chamado no inicio da pagina em metadata, para popular datatable
	public void consultar() {
	todosFornecedores = dao.todos();
	}
	
	public void salvar(){
		cadastroFornecedor.salvar(fornecedorEdicao);
		consultar();
	}
	
	public void prepararNovoCadastro(){
		fornecedorEdicao = new FornecedorFerramenta();
	}
	
	
	//getters e setters
	public List<FornecedorFerramenta> getTodosFornecedores() {
		return todosFornecedores;
	}
	public FornecedorFerramenta getFornecedorEdicao() {
		return fornecedorEdicao;
	}
	public void setFornecedorEdicao(FornecedorFerramenta fornecedorEdicao) {
		this.fornecedorEdicao = fornecedorEdicao;
	}
	public FornecedorFerramenta getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}
	public void setFornecedorSelecionado(FornecedorFerramenta fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}

	

	
	
}
