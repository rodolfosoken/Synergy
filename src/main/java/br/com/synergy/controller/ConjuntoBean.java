package br.com.synergy.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

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
import br.com.synergy.util.RootCauseExctractor;

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

	public void verificaEdicao() {

		// recebe a Id da cotação a ser editada pela url
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		if (request.getParameter("edicao") != null) {
			Long id = Long.parseLong(request.getParameter("edicao"));
			editar(id);
		}
	}

	public void editar(Long id) {
		conjuntoEdicao = conjuntos.buscaPorId(id);
		if (conjuntoEdicao != null) {
			System.out.println("DEBUG: Executando editar ConjuntoBean");

			// faz a busca com fetch pelas coleções do conjunto, evitando lazy
			// exception
			Conjunto c;
			c = conjuntos.buscaFetchComponentesFerramentas(id);
			if (c != null)
				conjuntoEdicao = c;
			c = conjuntos.buscaFetchComponentesPecas(id);
			if (c != null)
				c = conjuntoEdicao;
			c = conjuntos.buscaFetchMontagens(id);
			if (c != null)
				conjuntoEdicao = c;

			for (ComponenteFerramenta componenteFerramenta : conjuntoEdicao
					.getComponentesFerramentas()) {
				sourceFerramenta.add(componenteFerramenta);
			}
			for (ComponentePeca componentePeca : conjuntoEdicao
					.getComponentesPecas()) {
				sourcePeca.add(componentePeca);
			}

		} else {
			messages.error("Conjunto não encontrado.");
			RequestContext.getCurrentInstance().update(
					Arrays.asList("frm:messages", "frm"));
		}

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
		conjuntoEdicao.getComponentesPecas().add(componentePeca);
		dualListPeca.getSource().add(componentePeca);

		pecaEdicao = new Peca();
		componentePeca = new ComponentePeca(); 
		quantidadePeca = 1;

	}

	public void removerPeca() {
		conjuntoEdicao.getComponentesPecas().remove(componentePecaSelecionado);
		dualListPeca.getSource().remove(componentePecaSelecionado);
		componentePecaSelecionado.setConjunto(null);
		componentePecaSelecionado = null;
	}

	public void adicionarFerramenta() {
		ferramentaEdicao.getComponenteFerramentas().add(componenteFerramenta);
		componenteFerramenta.setFerramenta(ferramentaEdicao);
		componenteFerramenta.setQuantidade(quantidadeFerramenta);

		componenteFerramenta.setConjunto(conjuntoEdicao);
		conjuntoEdicao.getComponentesFerramentas().add(componenteFerramenta);
		dualListFerramenta.getSource().add(componenteFerramenta);

		ferramentaEdicao = new Ferramenta();
		componenteFerramenta = new ComponenteFerramenta();
		quantidadeFerramenta = 1;
	}

	public void removerFerramenta() {
		conjuntoEdicao.getComponentesFerramentas().remove(
				componenteFerramentaSelecionado);
		dualListFerramenta.getSource().remove(componenteFerramentaSelecionado);
		componenteFerramentaSelecionado.setConjunto(null);
		componenteFerramentaSelecionado = null;
		
	}

	public void adicionarMontagem() {
		montagemEdicao.setConjunto(conjuntoEdicao);
		conjuntoEdicao.getMontagens().add(montagemEdicao);
		montagemEdicao = new Montagem();
		montagemSelecionada = null;
		initMontagem();
	}

	public void removerMontagem() {
		montagemSelecionada.setConjunto(null);
		conjuntoEdicao.getMontagens().remove(montagemSelecionada);
		montagemSelecionada = null;
	}

	public String salvarConjunto() {
		try{
		cadastro.salvar(conjuntoEdicao);
		limpar();
		if(isEditando())
			return "tabelaConjuntos?ok=true faces-redirect=true";
		messages.info("Conjunto cadastrado com sucesso!");
		RequestContext.getCurrentInstance().update("frm");
		} catch (Exception e) {
			messages.error("Não foi possível salvar:",
					RootCauseExctractor.extractRootCauseMessage(e));
		}
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:messages", "frm"));
		return null;
	}

	public String editarConjunto() {
		return "conjunto?edicao=" + conjuntoSelecionado.getIdconjunto()
				+ "faces-redirect=true";

	}
	
	public void okMessage() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		if ("true".equals(request.getParameter("ok"))) {
			messages.info("Salvo com sucesso!");
		}
	}

	public List<Ferramenta> completarFerramenta(String nome) {
		return ferramentas.buscaPorFerramentaNome(nome);
	}

	public List<Peca> completarPeca(String nome) {
		return pecas.buscaPorPecaNome(nome);
	}
	
	public boolean isEditando(){
	 return (conjuntoEdicao.getIdconjunto()==null);
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
