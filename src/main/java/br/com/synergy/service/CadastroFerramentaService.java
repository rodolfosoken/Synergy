package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.Ferramenta;
import br.com.synergy.repository.Ferramentas;
import br.com.synergy.util.Transacional;

public class CadastroFerramentaService implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private Ferramentas dao;

		
	
	@Transacional
	public void salvar(Ferramenta Ferramenta){
		dao.guardar(Ferramenta);
	}
	
	@Transacional
	public void excluir(Ferramenta Ferramenta){
		dao.excluir(Ferramenta);
	}

	

}
