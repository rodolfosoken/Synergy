package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.Peca;
import br.com.synergy.repository.Pecas;
import br.com.synergy.util.Transacional;

public class CadastroPecaService implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private Pecas dao;

		
	
	@Transacional
	public void salvar(Peca peca){
		dao.guardar(peca);
	}
	
	@Transacional
	public void excluir(Peca peca){
		dao.excluir(peca);
	}

	

}
