package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.Conta;
import br.com.synergy.repository.Contas;
import br.com.synergy.util.Transacional;

public class CadastroContaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Contas contas;
	
	@Transacional
	public void salvar(Conta conta){
		contas.salvar(conta);		
	}


}
