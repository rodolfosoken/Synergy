package br.com.synergy.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.synergy.model.Usuario;
import br.com.synergy.repository.Usuarios;
import br.com.synergy.service.CadastroUsuarioService;
import br.com.synergy.util.FacesMessages;
import br.com.synergy.util.RootCauseExctractor;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Usuarios usuarios;

	@Inject
	private CadastroUsuarioService cadastro;

	@Inject
	private FacesMessages messages;

	private Usuario usuarioEdicao;
	private Usuario usuarioSelecionado;
	private String cargo;

	public List<Usuario> getTodos() {
		return usuarios.getTodos();
	}

	public void salvar(Usuario usuario) {
		try {
			cadastro.salvar(usuarioEdicao);
		} catch (Exception e) {
			messages.error("Não foi possível realizar a operação.",
					RootCauseExctractor.extractRootCauseMessage(e));
		}
	}

	// getters e setters
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
