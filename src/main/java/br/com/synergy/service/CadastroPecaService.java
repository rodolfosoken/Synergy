package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.Peca;
import br.com.synergy.repository.Pecas;

public class CadastroPecaService implements Serializable, CadastroService<Peca>{

	private static final long serialVersionUID = 1L;
	@Inject
	private Pecas dao;

		
	
	@Override
	public void salvar(Peca peca)throws Exception{
		dao.guardar(peca);
	}
	
	@Override
	public void excluir(Peca peca)throws Exception{
		dao.excluir(peca);
	}

	

}
