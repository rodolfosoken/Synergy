package br.com.synergy.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

import br.com.synergy.model.Cotacao;
import br.com.synergy.model.CotacaoFerramenta;
import br.com.synergy.repository.Cotacoes;
import br.com.synergy.service.CadastroCotacaoService;
import br.com.synergy.util.FacesMessages;

@Named
@ViewScoped
public class CotacaoPesquisaFerrmanetaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Cotacoes cotacoes;

	@Inject
	private FacesMessages messages;
	
	@Inject
	private CadastroCotacaoService cadastro;

	private Cotacao cotacaoSelecionada;

	private List<CotacaoFerramenta> todasCotacoes;


	public String editarCotacaoFerramenta() {
		String url = "cotacaoFerramenta?edicao="
				+ cotacaoSelecionada.getIdcotacao() + "faces-redirect=true";

		return url;
	}
	
	public void excluir(){
		try{
		cadastro.excluir(cotacaoSelecionada);
		consultar();
		messages.info("Cotação excluída com sucesso!");
		RequestContext.getCurrentInstance().update(":frm");
		}catch(Exception e){
			messages.error("Não foi possível excluir essa cotação: Há dependencias.");
			RequestContext.getCurrentInstance().update(":frm:messages");
		}
	}

	public void okMessage() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		if ("true".equals(request.getParameter("ok"))) {
			messages.info("Salvo com sucesso!");
		}
	}
	
	public void consultar() {
		System.out.println("DEBUG: Consultar todas as cotações ferramentas");
		todasCotacoes = cotacoes.todasCotacoesFerramentas();
	}

	public String editarCotacaoMaterial() {
		String url = "cotacaoMaterial?edicao="
				+ cotacaoSelecionada.getIdcotacao() + "faces-redirect=true";

		return url;
	}

	public List<CotacaoFerramenta> getTodasCotacaoesFerramenta() {
		return todasCotacoes;
	}

	public Cotacao getCotacaoSelecionada() {
		return cotacaoSelecionada;
	}

	public void setCotacaoSelecionada(Cotacao cotacaoSelecionada) {
		this.cotacaoSelecionada = cotacaoSelecionada;
	}

}
