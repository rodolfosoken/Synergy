package br.com.synergy.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.synergy.model.Material;
import br.com.synergy.model.ParticipanteMaterial;
import br.com.synergy.repository.Materiais;
import br.com.synergy.service.CadastroMaterialService;
import br.com.synergy.util.FacesMessages;

@Named
@ViewScoped
public class MaterialBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Materiais materiais;
	
	@Inject
	private CadastroMaterialService cadastroMaterial;
	
	@Inject
	private FacesMessages messages;
	
	private List<Material> todosMateriais;
	
	private Material materialEdicao = new Material();
	private Material materialSelecionado;
	
	//metodos utilitários
	
	//metodo chamado no inicio da pagina em metadata, para popular datatable
	public void consultar() {
	todosMateriais = materiais.todos();
	}
	
	public void salvar(){
		if(!isEditando() && materialEdicao.getCotacao()==null)
			materialEdicao.setDisponivel(true);
			
		cadastroMaterial.salvar(materialEdicao); 
		consultar();

		messages.info("Material salvo com sucesso!");
		prepararNovoCadastro();
		
		//pega lista de componentes para atualizar
		//atualizando a tabela e lança a mensagem de sucesso
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:messages", "frm:materiais-table"));
		
	}

	public void prepararNovoCadastro(){
		System.out.println("DEBUG: Executando prepararNovoCadastro Material");
		materialEdicao = new Material();
	}
	
	
	public void excluir(){
		cadastroMaterial.excluir(materialSelecionado);
		messages.info("Material: "+materialSelecionado.getMaterial()+" excluido com sucesso!");
		materialSelecionado=null;
		consultar();
		
	}
	
	public List<ParticipanteMaterial> completarParticipante(String nome){
		return materiais.buscaPorParticipante(nome.toString());
	}

	
	public boolean isEditando(){
		return materialEdicao.getIdmaterial()!=null;
	}
	
	//getters e setters
	public List<Material> getTodosMateriais() {
		return todosMateriais;
	}
	public Material getMaterialEdicao() {
		return materialEdicao;
	}
	public void setMaterialEdicao(Material materialEdicao) {
		this.materialEdicao = materialEdicao;
	}
	public Material getMaterialSelecionado() {
		return materialSelecionado;
	}
	public void setMaterialSelecionado(Material materialSelecionado) {
		this.materialSelecionado = materialSelecionado;
	}

	
	
}
