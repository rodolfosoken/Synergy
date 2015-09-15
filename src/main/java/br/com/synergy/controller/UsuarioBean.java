package br.com.synergy.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.synergy.model.Usuario;
import br.com.synergy.repository.Usuarios;
import br.com.synergy.util.FacesMessages;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuarios;
	
	@SuppressWarnings("unused")
	@Inject
	private FacesMessages messages;
	
	private Usuario usuarioEdicao;
	private Usuario usuarioSelecionado;
	
	
	public List<Usuario> getTodos(){
		return usuarios.getTodos();
	}
	
	
	//getters e setters
	public Usuario getUsuarioEdicao() {
		return usuarioEdicao;
	}
	public void setUsuarioEdicao(Usuario usuarioEdicao) {
		this.usuarioEdicao = usuarioEdicao;
	}
	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}
	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}
	
	
	
	

}
