package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.FornecedorFerramenta;
import br.com.synergy.repository.FornecedorFerramentaDAO;
import br.com.synergy.util.Transacional;

public class CadastroFornecedorService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FornecedorFerramentaDAO dao;
		
	
	@Transacional
	public void salvar(FornecedorFerramenta fornecedor){
		dao.guardar(fornecedor);
	}
	

}
