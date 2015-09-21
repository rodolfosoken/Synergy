package br.com.synergy.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DualListModel;

import br.com.synergy.model.ComponenteFerramenta;
import br.com.synergy.model.ComponentePeca;
import br.com.synergy.model.Conjunto;
import br.com.synergy.model.Ferramenta;
import br.com.synergy.model.Montagem;
import br.com.synergy.model.Peca;
import br.com.synergy.repository.Conjuntos;
import br.com.synergy.repository.Ferramentas;
import br.com.synergy.repository.Pecas;
import br.com.synergy.service.CadastroConjuntoService;
import br.com.synergy.util.FacesMessages;

@Named
@ViewScoped
public class ConjuntoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private FacesMessages messages;

	@Inject
	private CadastroConjuntoService cadastro;

	@Inject
	private Ferramentas ferramentas;

	@Inject
	private Pecas pecas;

	@Inject
	private Conjuntos conjuntos;

	private Conjunto conjuntoEdicao;
	private Conjunto conjuntoSelecionado;
	private List<Conjunto> todos;
	private Ferramenta ferramentaEdicao;
	private Ferramenta ferramentaSelecionada;
	private Peca pecaEdicao;
	private Peca pecaSelecionada;
	private ComponenteFerramenta componenteFerramenta;
	private ComponenteFerramenta componenteFerramentaSelecionado;
	private ComponentePeca componentePeca;
	private ComponentePeca componentePecaSelecionado;
	private Montagem montagemEdicao;
	private Montagem montagemSelecionada;
	private List<ComponentePeca> sourcePeca;
	private List<ComponenteFerramenta> sourceFerramenta;
	private DualListModel<ComponentePeca> dualListPeca;
	private DualListModel<ComponenteFerramenta> dualListFerramenta;

	private int quantidadePeca;
	private int quantidadeFerramenta;

	public void consultar() {
		this.todos = conjuntos.todos();
	}

	public ConjuntoBean() {
		limpar();
	}

	private void limpar() {
		conjuntoEdicao = new Conjunto();
		ferramentaEdicao = new Ferramenta();
		pecaEdicao = new Peca();
		componenteFerramenta = new ComponenteFerramenta();
		componentePeca = new ComponentePeca();
		montagemEdicao = new Montagem();
		sourcePeca = new ArrayList<ComponentePeca>();
		sourceFerramenta = new ArrayList<ComponenteFerramenta>();
		quantidadePeca = 1;
		quantidadeFerramenta = 1;

		conjuntoSelecionado = null;
		ferramentaSelecionada = null;
		pecaSelecionada = null;
		componenteFerramentaSelecionado = null;
		componentePecaSelecionado = null;
		montagemSelecionada = null;
		initMontagem();

	}

	public void initMontagem() {
		dualListPeca = new DualListModel<>(sourcePeca,
				montagemEdicao.getComponentePecas());
		dualListFerramenta = new DualListModel<>(sourceFerramenta,
				montagemEdicao.getComponenteFerramentas());

	}

	public void adicionarPeca() {
		pecaEdicao.getComponentePecas().add(componentePeca);
		componentePeca.setPeca(pecaEdicao);
		componentePeca.setQuantidade(quantidadePeca);

		componentePeca.setConjunto(conjuntoEdicao);
		conjuntoEdicao.getComponentePecas().add(componentePeca);
		sourcePeca.add(componentePeca);

		pecaEdicao = new Peca();
		componentePeca = new ComponentePeca();
		quantidadePeca = 1;
		initMontagem();

	}

	public void removerPeca() {
		conjuntoEdicao.getComponentePecas().remove(componentePecaSelecionado);
		sourcePeca.remove(componentePecaSelecionado);
		componentePecaSelecionado.setConjunto(null);
		componentePecaSelecionado = null;
		initMontagem();
	}

	public void adicionarFerramenta() {
		ferramentaEdicao.getComponenteFerramentas().add(componenteFerramenta);
		componenteFerramenta.setFerramenta(ferramentaEdicao);
		componenteFerramenta.setQuantidade(quantidadeFerramenta);

		componenteFerramenta.setConjunto(conjuntoEdicao);
		conjuntoEdicao.getComponenteFerramentas().add(componenteFerramenta);
		sourceFerramenta.add(componenteFerramenta);

		ferramentaEdicao = new Ferramenta();
		componenteFerramenta = new ComponenteFerramenta();
		quantidadeFerramenta = 1;
		initMontagem();
	}

	public void removerFerramenta() {
		conjuntoEdicao.getComponenteFerramentas().remove(
				componenteFerramentaSelecionado);
		sourceFerramenta.remove(componenteFerramentaSelecionado);
		componenteFerramentaSelecionado.setConjunto(null);
		componenteFerramentaSelecionado = null;
		initMontagem();
	}
	
	public void adicionarMontagem(){
		montagemEdicao.setConjunto(conjuntoEdicao);
		conjuntoEdicao.getMontagems().add(montagemEdicao);
		montagemEdicao = new Montagem();
		montagemSelecionada=null;
	}

	public void salvarConjunto() {
		cadastro.guardar(conjuntoEdicao);
		limpar();
		messages.info("Conjunto cadastrado com sucesso!");
		RequestContext.getCurrentInstance().update("frm");
	}

	public void editarConjunto() {
		conjuntoEdicao = conjuntoSelecionado;

	}

	public List<Ferramenta> completarFerramenta(String nome) {
		return ferramentas.buscaPorFerramentaNome(nome);
	}

	public List<Peca> completarPeca(String nome) {
		return pecas.buscaPorPecaNome(nome);
	}

	// getters e setters

	public List<Conjunto> getTodos() {
		return this.todos;
	}
	

	public Montagem getMontagemEdicao() {
		return montagemEdicao;
	}

	public void setMontagemEdicao(Montagem montagemEdicao) {
		this.montagemEdicao = montagemEdicao;
	}

	public Montagem getMontagemSelecionada() {
		return montagemSelecionada;
	}

	public void setMontagemSelecionada(Montagem montagemSelecionada) {
		this.montagemSelecionada = montagemSelecionada;
	}

	public DualListModel<ComponentePeca> getDualListPeca() {
		return dualListPeca;
	}

	public void setDualListPeca(DualListModel<ComponentePeca> dualListPeca) {
		this.dualListPeca = dualListPeca;
	}

	public DualListModel<ComponenteFerramenta> getDualListFerramenta() {
		return dualListFerramenta;
	}

	public void setDualListFerramenta(
			DualListModel<ComponenteFerramenta> dualListFerramenta) {
		this.dualListFerramenta = dualListFerramenta;
	}

	public ComponenteFerramenta getComponenteFerramentaSelecionado() {
		return componenteFerramentaSelecionado;
	}

	public void setComponenteFerramentaSelecionado(
			ComponenteFerramenta componenteFerramentaSelecionado) {
		this.componenteFerramentaSelecionado = componenteFerramentaSelecionado;
	}

	public ComponentePeca getComponentePecaSelecionado() {
		return componentePecaSelecionado;
	}

	public void setComponentePecaSelecionado(
			ComponentePeca componentePecaSelecionado) {
		this.componentePecaSelecionado = componentePecaSelecionado;
	}

	public ComponenteFerramenta getComponenteFerramenta() {
		return componenteFerramenta;
	}

	public void setComponenteFerramenta(
			ComponenteFerramenta componenteFerramenta) {
		this.componenteFerramenta = componenteFerramenta;
	}

	public ComponentePeca getComponentePeca() {
		return componentePeca;
	}

	public void setComponentePeca(ComponentePeca componentePeca) {
		this.componentePeca = componentePeca;
	}

	public Ferramenta getFerramentaSelecionada() {
		return ferramentaSelecionada;
	}

	public void setFerramentaSelecionada(Ferramenta ferramentaSelecionada) {
		this.ferramentaSelecionada = ferramentaSelecionada;
	}

	public int getQuantidadePeca() {
		return quantidadePeca;
	}

	public void setQuantidadePeca(int quantidadePeca) {
		this.quantidadePeca = quantidadePeca;
	}

	public int getQuantidadeFerramenta() {
		return quantidadeFerramenta;
	}

	public void setQuantidadeFerramenta(int quantidadeFerramenta) {
		this.quantidadeFerramenta = quantidadeFerramenta;
	}

	public Peca getPecaSelecionada() {
		return pecaSelecionada;
	}

	public void setPecaSelecionada(Peca pecaSelecionada) {
		this.pecaSelecionada = pecaSelecionada;
	}

	public Ferramenta getFerramentaEdicao() {
		return ferramentaEdicao;
	}

	public void setFerramentaEdicao(Ferramenta ferramentaEdicao) {
		this.ferramentaEdicao = ferramentaEdicao;
	}

	public Peca getPecaEdicao() {
		return pecaEdicao;
	}

	public void setPecaEdicao(Peca pecaEdicao) {
		this.pecaEdicao = pecaEdicao;
	}

	public Conjunto getConjuntoEdicao() {
		return conjuntoEdicao;
	}

	public void setConjuntoEdicao(Conjunto conjuntoEdicao) {
		this.conjuntoEdicao = conjuntoEdicao;
	}

	public Conjunto getConjuntoSelecionado() {
		return conjuntoSelecionado;
	}

	public void setConjuntoSelecionado(Conjunto conjuntoSelecionado) {
		this.conjuntoSelecionado = conjuntoSelecionado;
	}

}
