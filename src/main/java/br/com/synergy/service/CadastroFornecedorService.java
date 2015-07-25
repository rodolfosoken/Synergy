package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.synergy.model.FornecedorFerramenta;
import br.com.synergy.repository.FornecedorFerramentaDAO;

public class CadastroFornecedorService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private FornecedorFerramentaDAO dao;
	
	
	@Transactional
	public void salvar(FornecedorFerramenta fornecedor){

		dao.merge(fornecedor);
	}
	

}
