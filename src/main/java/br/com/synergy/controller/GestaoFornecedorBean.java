package br.com.synergy.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.synergy.model.Fornecedor;
import br.com.synergy.repository.FornecedorFerramentaDAO;
import br.com.synergy.util.FacesMessages;

@Named
@ViewScoped
public class GestaoFornecedorBean implements Serializable {
	@Inject
	private FornecedorFerramentaDAO dao;
	@Inject
	private FacesMessages messages;
	
	private List<Fornecedor> todosFornecedores;
	
	public void consultar() {
	todosFornecedores = dao.todos();
	}
	public List<Fornecedor> getTodosFornecedores() {
		return todosFornecedores;
	}
}
