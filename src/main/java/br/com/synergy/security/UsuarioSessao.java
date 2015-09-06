package br.com.synergy.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.synergy.model.Usuario;

/*
 *  Classe que armazena um usuário do sistema
 *  com as características de um usuário do Spring  
 * 
 * */
public class UsuarioSessao extends User {


	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	public UsuarioSessao(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}
	
	
	public Usuario getUsuario(){
		return usuario;
	}


}
