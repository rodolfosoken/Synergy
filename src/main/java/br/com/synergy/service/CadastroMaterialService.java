package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.Material;
import br.com.synergy.repository.Materiais;
import br.com.synergy.util.Transacional;

public class CadastroMaterialService implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private Materiais dao;

		
	
	@Transacional
	public void salvar(Material Material){
		dao.guardar(Material);
	}
	
	@Transacional
	public void excluir(Material Material){
		dao.excluir(Material);
	}

	

}
