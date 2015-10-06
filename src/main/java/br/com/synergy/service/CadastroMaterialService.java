package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.Material;
import br.com.synergy.repository.Materiais;

public class CadastroMaterialService implements Serializable, CadastroService<Material>{

	private static final long serialVersionUID = 1L;
	@Inject
	private Materiais materiais;

		
	
	@Override
	public void salvar(Material Material)throws Exception{
		materiais.guardar(Material);
	}
	
	@Override
	public void excluir(Material Material)throws Exception{
		materiais.excluir(Material);
	}

	

}
