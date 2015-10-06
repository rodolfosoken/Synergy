package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.Conta;
import br.com.synergy.repository.Contas;

public class CadastroContaService implements Serializable, CadastroService<Conta>{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Contas contas;
	
	@Override
	public void salvar(Conta conta)throws Exception{
		contas.salvar(conta);		
	}

	@Override
	public void excluir(Conta conta) throws Exception {
		contas.excluir(conta);
	}


}
