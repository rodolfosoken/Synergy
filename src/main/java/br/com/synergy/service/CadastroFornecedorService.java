package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.Fornecedor;
import br.com.synergy.repository.Fornecedores;

public class CadastroFornecedorService implements Serializable, CadastroService<Fornecedor> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Fornecedores fornecedores;
		
	
	@Override
	public void salvar(Fornecedor fornecedor)throws Exception{
		fornecedores.guardar(fornecedor);
	}
	
	@Override
	public void excluir(Fornecedor fornecedor)throws Exception{
		fornecedores.excluir(fornecedor);
	}
	

}
