package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.Ferramenta;
import br.com.synergy.repository.Ferramentas;

public class CadastroFerramentaService implements Serializable, CadastroService<Ferramenta>{

	private static final long serialVersionUID = 1L;
	@Inject
	private Ferramentas ferramentas;

	@Override
	public void salvar(Ferramenta Ferramenta)throws Exception{
		ferramentas.guardar(Ferramenta);
	}
	
	@Override
	public void excluir(Ferramenta Ferramenta)throws Exception{
		ferramentas.excluir(Ferramenta);
	}
	

}
