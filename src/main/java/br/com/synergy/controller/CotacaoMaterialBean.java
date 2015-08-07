package br.com.synergy.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.synergy.model.CotacaoMaterial;
import br.com.synergy.model.Fornecedor;
import br.com.synergy.model.Material;
import br.com.synergy.model.ParticipanteMaterial;
import br.com.synergy.repository.Fornecedores;
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
	private CotacaoMaterial cotacaoMaterial;

	private ParticipanteMaterial participanteSelecionado;
	private ParticipanteMaterial participanteMaterial;
	private Material materialEdicao;
	private Material materialSelecionado;

	public CotacaoMaterialBean() {
		limpar();

	}

	private void limpar() {
		cotacaoMaterial = new CotacaoMaterial();
		participanteMaterial = new ParticipanteMaterial();
		materialEdicao = new Material();
	}

	public List<Fornecedor> completarFornecedor(String nome) {
		return fornecedores.buscaPorNome(nome);
	}

	public void adicionarMaterial() {
		materialEdicao.setParticipanteMaterial(participanteSelecionado);
		participanteSelecionado.getMateriais().add(materialEdicao);
		materialEdicao = new Material();
	}

	public void adicionaFornecedor() {
		if (participanteMaterial.getFornecedor() == null) {

			messages.error("Fornecedor deve ser selecionado!");
			RequestContext.getCurrentInstance().update("frm:growl");

		} else if (!contemParticipante(participanteMaterial,
				cotacaoMaterial.getParticipanteMateriais())) {
			cotacaoMaterial.getParticipanteMateriais()
					.add(participanteMaterial);
			participanteMaterial = new ParticipanteMaterial();
		} else {
			messages.error("Fornecedor já foi adicionado!");
			RequestContext.getCurrentInstance().update("frm:growl");
		}
	}

	public boolean contemParticipante(ParticipanteMaterial participante,
			Set<ParticipanteMaterial> lista) {
		boolean contem = false;
		for (ParticipanteMaterial p : lista) {
			contem = p.getFornecedor().getIdfornecedor()
					.equals(participante.getFornecedor().getIdfornecedor());
		}
		return contem;
	}

	// getters e setters

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
