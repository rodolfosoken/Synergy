package br.com.synergy.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.synergy.model.Usuario;
import br.com.synergy.repository.Usuarios;

public class CadastroUsuarioService implements Serializable, CadastroService<Usuario>{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuarios;
	
	@Override
	public void salvar(Usuario usuario)throws Exception{
		usuarios.salvar(usuario);
	}
	
	@Override
	public void excluir(Usuario usuario)throws Exception{
		usuarios.excluir(usuario);
	}

}
