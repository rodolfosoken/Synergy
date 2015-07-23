package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import repository.FornecedorFerramentaHome;
import util.FacesMessages;
import model.FornecedorFerramenta;

@Named
@ViewScoped
public class GestaoFornecedorBean implements Serializable {
	@Inject
	private FornecedorFerramentaHome dao;
	@Inject
	private FacesMessages messages;
	
	private List<FornecedorFerramenta> todosFornecedores;
	
	public void consultar() {
	todosFornecedores = dao.todos();
	}
	public List<FornecedorFerramenta> getTodosFornecedores() {
		return todosFornecedores;
	}
}
