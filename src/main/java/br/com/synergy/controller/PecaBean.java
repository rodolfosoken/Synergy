package br.com.synergy.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.synergy.model.FornecedorPeca;
import br.com.synergy.model.Material;
import br.com.synergy.model.Peca;
import br.com.synergy.repository.Fornecedores;
import br.com.synergy.repository.Materiais;
import br.com.synergy.repository.Pecas;
import br.com.synergy.service.CadastroPecaService;
import br.com.synergy.util.FacesMessages;
import br.com.synergy.util.RootCauseExctractor;

@Named
@ViewScoped
public class PecaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pecas pecas;
	
	@Inject
	private CadastroPecaService cadastroPeca;
	
	@Inject
	private Materiais materiais;
	
	@Inject
	private FacesMessages messages;
	
	@Inject
	private Fornecedores fornecedores;
	
	private List<Peca> todasPecas;
	
	private Peca pecaEdicao = new Peca();
	private Peca pecaSelecionado;
	
	//metodos utilitários
	
	//metodo chamado no inicio da pagina em metadata, para popular datatable
	public void consultar() {
	todasPecas = pecas.todas();
	}
	
	public void salvar(){
		try{
		cadastroPeca.salvar(pecaEdicao); 
		consultar();

		messages.info("Peça salva com sucesso!");
		prepararNovoCadastro();
		} catch (Exception e) {
			messages.error("Não foi possível salvar:",
					RootCauseExctractor.extractRootCauseMessage(e));
		}
		//pega lista de componentes para atualizar
		//atualizando a tabela e lança a mensagem de sucesso
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:messages", "frm:pecas-table"));
	}

	public void prepararNovoCadastro(){
		pecaEdicao = new Peca();
	}
	
	
	public void excluir(){
		try{
		cadastroPeca.excluir(pecaSelecionado);
		messages.info("Peca: "+pecaSelecionado.getPartName()+" excluido com sucesso!");
		pecaSelecionado=null;
		} catch (Exception e) {
			messages.error("Não foi possível excluir:",
					RootCauseExctractor.extractRootCauseMessage(e));
		}
		consultar();
		
	}
	
	
	public List<Material> completarMaterial(String nome){
		return materiais.buscaPorMaterialEspc(nome.toString());
	}
	
	public List<FornecedorPeca> completarFornecedor(String nome){
		return fornecedores.buscaPorFornecedorPeca(nome);
	}
	
	//getters e setters
	public List<Peca> getTodasPecas() {
		return todasPecas;
	}
	public Peca getPecaEdicao() {
		return pecaEdicao;
	}
	public void setPecaEdicao(Peca pecaEdicao) {
		this.pecaEdicao = pecaEdicao;
	}
	public Peca getPecaSelecionado() {
		return pecaSelecionado;
	}
	public void setPecaSelecionado(Peca pecaSelecionado) {
		this.pecaSelecionado = pecaSelecionado;
	}

	
	
}
