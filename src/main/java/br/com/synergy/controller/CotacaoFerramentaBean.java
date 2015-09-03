package br.com.synergy.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.synergy.model.CotacaoFerramenta;
import br.com.synergy.model.FornecedorFerramenta;
import br.com.synergy.model.Ferramenta;
import br.com.synergy.model.ParticipanteFerramenta;
import br.com.synergy.repository.Fornecedores;
import br.com.synergy.service.CadastroCotacaoFerramentaService;
import br.com.synergy.util.FacesMessages;

@Named
@ViewScoped
public class CotacaoFerramentaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private FacesMessages messages;

	@Inject
	private Fornecedores fornecedores;

	@Inject
	private CadastroCotacaoFerramentaService cadastro;

	private CotacaoFerramenta cotacaoFerramenta;

	private ParticipanteFerramenta participanteSelecionado;
	private ParticipanteFerramenta participanteFerramenta;
	private Ferramenta ferramentaEdicao;
	private Ferramenta ferramentaSelecionado;
	private Integer indexTab=0;
	

	public CotacaoFerramentaBean() {
		limpar();
		cotacaoFerramenta.setDataInicio(new Date());

	}
	
	public void onRowSelection(){
		indexTab=1;
	}

	private void limpar() {
		cotacaoFerramenta = new CotacaoFerramenta();
		participanteFerramenta = new ParticipanteFerramenta();
		ferramentaEdicao = new Ferramenta();
		participanteSelecionado=null;
		ferramentaSelecionado=null;
		indexTab=0;
	}

	public List<FornecedorFerramenta> completarFornecedor(String nome) {
		return fornecedores.buscaPorFornecedorFerramenta(nome);
	}

	public void adicionarFerramenta() {
		ferramentaEdicao.setParticipanteFerramenta(participanteSelecionado);
		participanteSelecionado.getFerramentas().add(ferramentaEdicao);
		ferramentaEdicao = new Ferramenta();
	}

	public void salvarCotacao() {
		cadastro.salvar(cotacaoFerramenta);
		messages.info("Cotação salva com sucesso!");
		
		limpar();
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:messages", "frm"));
	}

	public void adicionarFornecedor() {
		System.out.println(participanteFerramenta.getFornecedor());
		if (participanteFerramenta.getFornecedor() == null) {

			messages.error("Fornecedor de Ferramentas deve ser selecionado!");
			RequestContext.getCurrentInstance().update("frm:growl");

		} else if (!contemParticipante(participanteFerramenta,cotacaoFerramenta.getParticipantesFerramentas())) {
			
			//Referência bidirecional
			participanteFerramenta.setCotacaoFerramenta(cotacaoFerramenta);
			cotacaoFerramenta.getParticipantesFerramentas().add(
					participanteFerramenta);
			
			//limpa a instancia do bean
			participanteFerramenta = new ParticipanteFerramenta();
		} else {
			messages.error("Fornecedor já foi adicionado!");
			RequestContext.getCurrentInstance().update("frm:growl");
		}
	}
	
	public void removerFornecedor(){
		cotacaoFerramenta.getParticipantesFerramentas().remove(participanteSelecionado);
		participanteSelecionado=null; 
	}
	
	public void removerFerramenta(){
		participanteSelecionado.getFerramentas().remove(ferramentaSelecionado);
		ferramentaSelecionado=null;
	}

	public boolean contemParticipante(ParticipanteFerramenta participante,
			Set<ParticipanteFerramenta> lista) {
		boolean contem = false;
		for (ParticipanteFerramenta p : lista) {
			if(p.getFornecedor().getIdfornecedor()
					.equals(participante.getFornecedor().getIdfornecedor())){
				return !contem;
			}
		
		}
		return contem;
	}

	// getters e setters

	public Ferramenta getFerramentaEdicao() {
		return ferramentaEdicao;
	}

	public Ferramenta getFerramentaSelecionado() {
		return ferramentaSelecionado;
	}

	public void setFerramentaSelecionado(Ferramenta ferramentaSelecionado) {
		this.ferramentaSelecionado = ferramentaSelecionado;
	}

	public void setFerramentaEdicao(Ferramenta ferramentaEdicao) {
		this.ferramentaEdicao = ferramentaEdicao;
	}

	public ParticipanteFerramenta getParticipanteFerramenta() {
		return participanteFerramenta;
	}

	public void setParticipanteFerramenta(
			ParticipanteFerramenta participanteFerramenta) {
		this.participanteFerramenta = participanteFerramenta;
	}

	public CotacaoFerramenta getCotacaoFerramenta() {
		return cotacaoFerramenta;
	}

	public void setCotacaoFerramenta(CotacaoFerramenta cotacaoFerramenta) {
		this.cotacaoFerramenta = cotacaoFerramenta;
	}

	public ParticipanteFerramenta getParticipanteSelecionado() {
		return participanteSelecionado;
	}

	public void setParticipanteSelecionado(
			ParticipanteFerramenta participanteSelecionado) {
		this.participanteSelecionado = participanteSelecionado;
	}

	public Integer getIndexTab() {
		return indexTab;
	}

	public void setIndexTab(Integer indexTab) {
		this.indexTab = indexTab;
	}
	

}
