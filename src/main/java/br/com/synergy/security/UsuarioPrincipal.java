package br.com.synergy.security;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Named
@RequestScoped
public class UsuarioPrincipal{


	//Fornece o nome do usuario logado
	public String getNomeUsuarioLogado(){
		return getUsuarioLogado().getUsuario().getNome();
	}
	
	
	//pega o usuario logado
	static public UsuarioSessao getUsuarioLogado(){
		UsuarioSessao usuario = null;
		
		UsernamePasswordAuthenticationToken userSpring = (UsernamePasswordAuthenticationToken)
				FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		
		usuario = (UsuarioSessao) userSpring.getPrincipal();
		
		return usuario;
	}

}
