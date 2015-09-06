package br.com.synergy.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.synergy.model.Cargo;
import br.com.synergy.model.Usuario;
import br.com.synergy.repository.Usuarios;
import br.com.synergy.util.CDIServiceLocator;

public class UsuarioDetalhesService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		Usuarios usuarios = CDIServiceLocator.getBean(Usuarios.class);
		//busca usuário pelo email
		Usuario usuario = usuarios.buscaPorEmail(username);
		
		//armazenará o objeto usuário com as informações de autoridades
		UsuarioSessao usuarioDetalhado = null;
		
		//se a busca retornar algum usuário, ele deve receber as autoridades de seu cargo
		if(usuario != null){
			usuarioDetalhado = new UsuarioSessao(usuario, getAutoridades(usuario));
		}
		
		
		return usuarioDetalhado;
	}

	//gera a lista de autoridades a partir dos cargos de um usuário
	private Collection<? extends GrantedAuthority> getAutoridades(
			Usuario usuario) {
		List<SimpleGrantedAuthority> autoridades = new ArrayList<>();
		
		for (Cargo cargo : usuario.getCargos()) {
			autoridades.add(new SimpleGrantedAuthority(cargo.getNome().toUpperCase()));			
		}
		
		return autoridades;
	}

}
