package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.Fornecedor;
import br.com.synergy.repository.Fornecedores;
import br.com.synergy.util.Transacional;

public class CadastroFornecedorService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Fornecedores dao;
		
	
	@Transacional
	public void salvar(Fornecedor fornecedor){
		dao.guardar(fornecedor);
	}
	
	@Transacional
	public void excluir(Fornecedor fornecedor){
		dao.excluir(fornecedor);
	}
	

}
