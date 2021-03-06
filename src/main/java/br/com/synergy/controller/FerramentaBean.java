package br.com.synergy.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.synergy.model.Ferramenta;
import br.com.synergy.repository.Ferramentas;
import br.com.synergy.service.CadastroFerramentaService;
import br.com.synergy.util.FacesMessages;
import br.com.synergy.util.RootCauseExctractor;

@Named
@ViewScoped
public class FerramentaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Ferramentas ferramentas;

	@Inject
	private CadastroFerramentaService cadastroFerramenta;

	@Inject
	private FacesMessages messages;

	private List<Ferramenta> todasFerramentas;

	private Ferramenta ferramentaEdicao = new Ferramenta();
	private Ferramenta ferramentaSelecionado;

	// metodas utilitários

	// metodo chamado no inicio da pagina em metadata, para popular datatable
	public void consultar() {
		System.out.println("DEBUG: Executando Consultar em ferramentas");
		todasFerramentas = ferramentas.todas();
	}

	public void salvar() {
		try{
		cadastroFerramenta.salvar(ferramentaEdicao);
		consultar();

		messages.info("Ferramenta salvo com sucesso!");
		prepararNovoCadastro();
		
		} catch (Exception e) {
			messages.error("Não foi possível salvar:",
					RootCauseExctractor.extractRootCauseMessage(e));
		}

		// pega lista de componentes para atualizar
		// atualizando a tabela e lança a mensagem de sucesso
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:messages", "frm:ferramentas-table"));
	}

	public void prepararNovoCadastro() {
		ferramentaEdicao = new Ferramenta();
	}

	public void excluir() {
		try{
		cadastroFerramenta.excluir(ferramentaSelecionado);
		messages.info("Ferramenta: " + ferramentaSelecionado.getNome()
				+ " excluido com sucesso!");
		ferramentaSelecionado = null;
		} catch (Exception e) {
			messages.error("Não foi possível realizar a operação.",
					RootCauseExctractor.extractRootCauseMessage(e));
		}
		consultar();

	}

	// getters e setters
	public List<Ferramenta> getTodasFerramentas() {
		return todasFerramentas;
	}

	public Ferramenta getFerramentaEdicao() {
		return ferramentaEdicao;
	}

	public void setFerramentaEdicao(Ferramenta ferramentaEdicao) {
		this.ferramentaEdicao = ferramentaEdicao;
	}

	public Ferramenta getFerramentaSelecionado() {
		return ferramentaSelecionado;
	}

	public void setFerramentaSelecionado(Ferramenta ferramentaSelecionado) {
		this.ferramentaSelecionado = ferramentaSelecionado;
	}

}
