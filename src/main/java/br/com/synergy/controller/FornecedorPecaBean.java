package br.com.synergy.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.synergy.model.Fornecedor;
import br.com.synergy.model.FornecedorPeca;
import br.com.synergy.repository.Fornecedores;
import br.com.synergy.service.CadastroFornecedorService;
import br.com.synergy.util.FacesMessages;

@Named
@ViewScoped
public class FornecedorPecaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Fornecedores dao;
	
	@Inject
	private CadastroFornecedorService cadastroFornecedor;
	
	@Inject
	private FacesMessages messages;
	
	private List<Fornecedor> todosFornecedores;
	
	private Fornecedor fornecedorEdicao = new FornecedorPeca();
	private Fornecedor fornecedorSelecionado;
	
	//metodos utilitários
	
	//metodo chamado no inicio da pagina em metadata, para popular datatable
	public void consultar() {
	todosFornecedores = dao.todos("Peca");
	}
	
	public void salvar(){
		try {
			cadastroFornecedor.salvar(fornecedorEdicao);
			consultar();
			messages.info("Fornecedor salvo com sucesso!");
			// pega lista de componentes para atualizar
			// atualizando a tabela e lança a mensagem de sucesso
			RequestContext.getCurrentInstance().update(
					Arrays.asList("frm:messages", "frm:fornecedores-table"));

		} catch (Exception e) {
			boolean continuar = true;
			Throwable rootCause = e.getCause();
			while(continuar){
				if(rootCause.getCause()==null)
					break;
				rootCause=rootCause.getCause();
			
			}
			messages.error("Não foi possível realizar a alteração:"+rootCause.getMessage());
			FacesContext.getCurrentInstance().validationFailed();
			
		}
	}
	
	public void prepararNovoCadastro(){
		fornecedorEdicao = new FornecedorPeca();
	}
	
	
	public void excluir(){
		cadastroFornecedor.excluir(fornecedorSelecionado);
		messages.info("Fornecedor: "+fornecedorSelecionado.getNome()+" excluido com sucesso!");
		fornecedorSelecionado=null;
		consultar();
		
	}
	
	//getters e setters
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
