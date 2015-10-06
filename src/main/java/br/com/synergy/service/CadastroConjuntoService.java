package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.Conjunto;
import br.com.synergy.repository.Conjuntos;

public class CadastroConjuntoService implements Serializable, CadastroService<Conjunto>{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Conjuntos conjuntos;
	
	@Override
	public void salvar(Conjunto conjunto)throws Exception{
		conjuntos.guardar(conjunto);
	}

	@Override
	public void excluir(Conjunto conjunto) throws Exception {
		conjuntos.excluir(conjunto);
	}
	

}
