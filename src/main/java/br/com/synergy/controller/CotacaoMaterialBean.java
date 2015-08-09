package br.com.synergy.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.synergy.model.CotacaoMaterial;
import br.com.synergy.model.FornecedorMaterial;
import br.com.synergy.model.Material;
import br.com.synergy.model.ParticipanteMaterial;
import br.com.synergy.repository.Fornecedores;
import br.com.synergy.service.CadastroCotacaoMaterialService;
import br.com.synergy.util.FacesMessages;

@Named
@ViewScoped
public class CotacaoMaterialBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private FacesMessages messages;

	@Inject
	private Fornecedores fornecedores;

	@Inject
	private CadastroCotacaoMaterialService cadastro;

	private CotacaoMaterial cotacaoMaterial;
	private ParticipanteMaterial participanteSelecionado;
	private ParticipanteMaterial participanteMaterial;
	private Material materialEdicao;
	private Material materialSelecionado;
	private Integer tabIndex = 0;

	public CotacaoMaterialBean() {
		limpar();

	}

	private void limpar() {
		cotacaoMaterial = new CotacaoMaterial();
		participanteMaterial = new ParticipanteMaterial();
		materialEdicao = new Material();
		participanteSelecionado = null;
		materialSelecionado = null;
		tabIndex = 0;
	}
	
	public void onRowSelection(){
		tabIndex=1;
	}

	public List<FornecedorMaterial> completarFornecedor(String nome) {
		return fornecedores.buscaPorFornecedorMaterial(nome);
	}

	public void adicionarMaterial() {
		materialEdicao.setParticipanteMaterial(participanteSelecionado);
		participanteSelecionado.getMateriais().add(materialEdicao);
		System.out.println("Adicionando material: "
				+ materialEdicao.getMaterialEspc());
		materialEdicao = new Material();
	}

	public void salvarCotacao() {
		cadastro.salvar(cotacaoMaterial);
		messages.info("Cotação salva com sucesso!");

		limpar();
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:messages", "frm"));
	}

	public void adicionarFornecedor() {
		if (participanteMaterial.getFornecedor() == null) {

			messages.error("Fornecedor de Materiais deve ser selecionado!");
			RequestContext.getCurrentInstance().update("frm:growl");

		} else if (!contemParticipante(participanteMaterial,
				cotacaoMaterial.getParticipantesMateriais())) {
			System.out.println("Vou adicionar: "
					+ participanteMaterial.getFornecedor().getNome());

			participanteMaterial.setCotacaoMaterial(cotacaoMaterial);
			cotacaoMaterial.getParticipantesMateriais().add(
					participanteMaterial);
			for (ParticipanteMaterial p : cotacaoMaterial
					.getParticipantesMateriais()) {
				System.out.println(p.getFornecedor().getNome());
			}

			participanteMaterial = new ParticipanteMaterial();
		} else {
			messages.error("Fornecedor já foi adicionado!");
			RequestContext.getCurrentInstance().update("frm:growl");
		}
	}

	public void removerFornecedor() {
		cotacaoMaterial.getParticipantesMateriais().remove(
				participanteSelecionado);
		participanteSelecionado = null;
	}

	public void removerMaterial() {
		participanteSelecionado.getMateriais().remove(materialSelecionado);
		materialSelecionado = null;
	}

	public boolean contemParticipante(ParticipanteMaterial participante,
			Set<ParticipanteMaterial> lista) {
		boolean contem = false;
		for (ParticipanteMaterial p : lista) {
			if(p.getFornecedor().getIdfornecedor()
					.equals(participante.getFornecedor().getIdfornecedor())){
				return !contem;
			}
		
		}
		return contem;
	}

	// getters e setters

	public Integer getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(Integer tabIndex) {
		this.tabIndex = tabIndex;
	}

	public Material getMaterialEdicao() {
		return materialEdicao;
	}

	public Material getMaterialSelecionado() {
		return materialSelecionado;
	}

	public void setMaterialSelecionado(Material materialSelecionado) {
		this.materialSelecionado = materialSelecionado;
	}

	public void setMaterialEdicao(Material materialEdicao) {
		this.materialEdicao = materialEdicao;
	}

	public ParticipanteMaterial getParticipanteMaterial() {
		return participanteMaterial;
	}

	public void setParticipanteMaterial(
			ParticipanteMaterial participanteMaterial) {
		this.participanteMaterial = participanteMaterial;
	}

	public CotacaoMaterial getCotacaoMaterial() {
		return cotacaoMaterial;
	}

	public void setCotacaoMaterial(CotacaoMaterial cotacaoMaterial) {
		this.cotacaoMaterial = cotacaoMaterial;
	}

	public ParticipanteMaterial getParticipanteSelecionado() {
		return participanteSelecionado;
	}

	public void setParticipanteSelecionado(
			ParticipanteMaterial participanteSelecionado) {
		this.participanteSelecionado = participanteSelecionado;
	}

}
