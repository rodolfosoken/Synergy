package br.com.synergy.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RateEvent;

import br.com.synergy.model.Fornecedor;
import br.com.synergy.model.FornecedorMaterial;
import br.com.synergy.repository.Fornecedores;
import br.com.synergy.service.CadastroFornecedorService;
import br.com.synergy.util.FacesMessages;
import br.com.synergy.util.RootCauseExctractor;

@Named
@ViewScoped
public class FornecedorMaterialBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Fornecedores fornecedores;

	@Inject
	private CadastroFornecedorService cadastroFornecedor;

	@Inject
	private FacesMessages messages;

	private List<Fornecedor> todosFornecedores;

	private Fornecedor fornecedorEdicao = new FornecedorMaterial();
	private Fornecedor fornecedorSelecionado;

	// metodos utilitários

	// metodo chamado no inicio da pagina em metadata, para popular datatable
	public void consultar() {
		todosFornecedores = fornecedores.todos("Material");
	}

	public void salvar() {
		try {
			cadastroFornecedor.salvar(fornecedorEdicao);
			consultar();
			messages.info("Fornecedor salvo com sucesso!");
			// pega lista de componentes para atualizar
			// atualizando a tabela e lança a mensagem de sucesso
			RequestContext.getCurrentInstance().update(
					Arrays.asList("frm:messages", "frm:fornecedores-table"));

		} catch (Exception e) {
			messages.error("Não foi possível realizar a alteração:",
					RootCauseExctractor.extractRootCauseMessage(e));
			FacesContext.getCurrentInstance().validationFailed();

		}
	}

	public void prepararNovoCadastro() {
		fornecedorEdicao = new FornecedorMaterial();
	}

	public void excluir() {
		try {
			cadastroFornecedor.excluir(fornecedorSelecionado);
			messages.info("Fornecedor: " + fornecedorSelecionado.getNome()
					+ " excluido com sucesso!");
			fornecedorSelecionado = null;
		} catch (Exception e) {
			messages.error("Não foi possível excluir!",RootCauseExctractor.extractRootCauseMessage(e));
		}
		consultar();
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:messages", "frm:fornecedores-table"));

	}

	public void onrate(RateEvent rate) {
		long id = Long.parseLong(FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("selected"));
		fornecedorEdicao = (FornecedorMaterial) fornecedores.buscaPorId(id);
		fornecedorEdicao.setNota((Integer) rate.getRating());
		salvar();
	}

	// getters e setters
	public List<Fornecedor> getTodosFornecedores() {
		return todosFornecedores;
	}

	public Fornecedor getFornecedorEdicao() {
		return fornecedorEdicao;
	}

	public void setFornecedorEdicao(Fornecedor fornecedorEdicao) {
		this.fornecedorEdicao = fornecedorEdicao;
	}

	public Fornecedor getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}

	public void setFornecedorSelecionado(Fornecedor fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}

}
