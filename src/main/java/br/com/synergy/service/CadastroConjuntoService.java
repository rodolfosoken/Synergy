package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.Conjunto;
import br.com.synergy.repository.Conjuntos;
import br.com.synergy.util.Transacional;

public class CadastroConjuntoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Conjuntos conjuntos;
	
	@Transacional
	public void guardar(Conjunto conjunto){
		conjuntos.guardar(conjunto);
	}
	

}
