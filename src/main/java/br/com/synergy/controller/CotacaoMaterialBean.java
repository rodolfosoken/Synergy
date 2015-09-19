package br.com.synergy.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

import br.com.synergy.model.CompraMaterial;
import br.com.synergy.model.Cotacao;
import br.com.synergy.model.CotacaoMaterial;
import br.com.synergy.model.Material;
import br.com.synergy.model.FornecedorMaterial;
import br.com.synergy.model.ParticipanteMaterial;
import br.com.synergy.model.Pep;
import br.com.synergy.model.Usuario;
import br.com.synergy.repository.Cotacoes;
import br.com.synergy.repository.Fornecedores;
import br.com.synergy.repository.Peps;
import br.com.synergy.repository.Usuarios;
import br.com.synergy.security.UsuarioPrincipal;
import br.com.synergy.service.CadastroCotacaoService;
import br.com.synergy.util.FacesMessages;
import br.com.synergy.util.RootCauseExctractor;

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
	private Usuarios usuarios;

	@Inject
	private Fornecedores fornecedores;

	@Inject
	private CadastroCotacaoService cadastro;

	@Inject
	private Cotacoes cotacoes;

	@Inject
	private Peps peps;

	private CotacaoMaterial cotacaoMaterial;
	private CompraMaterial compra;

	private ParticipanteMaterial participanteSelecionado;
	private ParticipanteMaterial participanteMaterial;
	private Integer indexTab = 0;

	public CotacaoMaterialBean() {
		limpar();
		compra = new CompraMaterial();

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

	public void limpar() {
		System.out.println("DEBUG: executando Limpar");
		cotacaoMaterial = new CotacaoMaterial();
		participanteMaterial = new ParticipanteMaterial();
		participanteSelecionado = null;
		cotacaoMaterial.setUsuario(UsuarioPrincipal.getUsuarioLogado()
				.getUsuario());
		cotacaoMaterial.setDataInicio(new Date());
		cotacaoMaterial.setConcluida(false);
		cotacaoMaterial.setComprado(false);
		cotacaoMaterial.setMaterial(new Material());

		indexTab = 0;
	}

	public String salvarCotacao() {
		System.out.println("DEBUG: executando salvarCotaçao");

		// verifica se foi adicionado algum fornecedor antes de salvar
		if (!cotacaoMaterial.getParticipantesMateriais().isEmpty()) {

			if (cotacaoMaterial.getConcluida()
					&& cotacaoMaterial.getCompraMaterial() != null) {

				// coloca a cotação como comprada
				cotacaoMaterial.setComprado(true);

			}

			// faz as referências da material para a cotação
			adicionarMaterial();
			try {

				cadastro.salvar(cotacaoMaterial);
				messages.info("Cotação salva com sucesso!");

				limpar();

				// se estiver editando, voltar para a tela pesquisa de cotações
				if (!isEditando())
					return "pesquisaCotacaoMaterial?ok=true faces-redirect=true";
			} catch (Exception e) {
				messages.error("Não foi possível realizar a alteração:",
						RootCauseExctractor.extractRootCauseMessage(e));
				FacesContext.getCurrentInstance().validationFailed();

			}
			RequestContext.getCurrentInstance().update(
					Arrays.asList("frm:messages", "frm"));

		} else {
			messages.error("Fornecedor Vazio");
			indexTab = 1;
		}
		return null;

	}

	public void editar(Long id) {
		System.out.println("DEBUG: Executando editar");
		// Busca por id para resgatar o objeto com a coleção de fornecedores
		// evitando uma Lazy exception

		Cotacao c = cotacoes.buscaPorId(id);

		if (c != null) {
			// faz a busca (o fetch join) da coleção de materiais de cada
			// fornecedor
			// evitar a Lazy exception
			cotacaoMaterial = cotacoes.buscaFetchParticipantesCotacaoMaterial(c
					.getIdcotacao());

			// Busca pep da cotação se ela já foi comprada
			if (cotacaoMaterial.getComprado()) {
				cotacaoMaterial = cotacoes
						.buscaFetchCompraMaterial(cotacaoMaterial
								.getIdcotacao());
			}

			indexTab = 0;
		} else {
			limpar();
			messages.error("Cotação não encontrada");
			RequestContext.getCurrentInstance().update(
					Arrays.asList("frm:messages", "frm"));

		}

	}

	public void comprar() {
		compra.setCotacaoMaterial(cotacaoMaterial);
		cotacaoMaterial.setCompraMaterial(compra);

		// passa o preço do participante para compra da cotação
		cotacaoMaterial.getCompraMaterial().setPreco(
				compra.getParticipante().getValor());

		// seta a data atual para a aquisição do produto
		cotacaoMaterial.getCompraMaterial().setDataAquisicao(new Date());

		// Faz a material ficar disponivel
		cotacaoMaterial.getMaterial().setDisponivel(true);

		// redireciona para a aba de compra
		indexTab = 2;
	}

	// referencia a cotação na material da cotação
	public void adicionarMaterial() {
		System.out.println("DEBUG: executando adcionarMaterial");
		cotacaoMaterial.getMaterial().setCotacao(cotacaoMaterial);
	}

	// adiciona o fornecedor na lista da cotação
	public void adicionarFornecedor() {
		System.out.println("DEBUG: executando adicionarFornecedor");

		// ao adicionar o fornecedor, verificar se o valor foi preenchido e o
		// fornecedor selecionado
		if (participanteMaterial.getFornecedor() == null
				|| participanteMaterial.getValor() == null) {

			messages.error("Preencha os campos corretamenta");
			RequestContext.getCurrentInstance().update("frm:growl");

			// verifica se o participante já foi adicionado
		} else if (!contemParticipante(participanteMaterial,
				cotacaoMaterial.getParticipantesMateriais())) {

			// Referência bidirecional
			participanteMaterial.setCotacaoMaterial(cotacaoMaterial);
			cotacaoMaterial.getParticipantesMateriais().add(
					participanteMaterial);

			// limpa a instância do bean
			participanteMaterial = new ParticipanteMaterial();
		} else {
			messages.error("Fornecedor já foi adicionado!");
			RequestContext.getCurrentInstance().update("frm:growl");
		}
	}

	public void removerFornecedor() {
		System.out.println("DEBUG: executando removerFornecedor");
		cotacaoMaterial.getParticipantesMateriais().remove(
				participanteSelecionado);
		participanteSelecionado = null;
	}

	// preenche o auto-completar da PEP
	public List<Pep> completarPep(String pep) {
		return peps.buscarPorNumero(pep);
	}

	// preenche o auto-completar de usuários
	public List<Usuario> completarUsuario(String nome) {
		System.out.println("DEBUG: executando CompletarUsuario");
		return usuarios.buscaPorNome(nome);
	}

	// preenche o auto-completar de fornecedores
	public List<FornecedorMaterial> completarFornecedor(String nome) {
		System.out.println("DEBUG: executando CompletarFornecedor");
		return fornecedores.buscaPorFornecedorMaterial(nome);
	}

	// conclui a cotação
	public void concluir() {
		System.out.println("DEBUG: executando concluir");
		cotacaoMaterial.setDataTermino(new Date());
		cotacaoMaterial.setConcluida(true);
		// redireciona para a aba de compra
		indexTab = 1;
	}

	// desfaz a conclusão da cotação e marca como em andamento
	public void desmarcar() {
		System.out.println("DEBUG: executando desmarcar");
		cotacaoMaterial.setDataTermino(null);
		cotacaoMaterial.setConcluida(false);
		cotacaoMaterial.getMaterial().setDisponivel(false);
		cotacaoMaterial.setComprado(false);
		cotacaoMaterial.setCompraMaterial(null);

		// redireciona para a aba inicial
		indexTab = 0;
	}

	public void okPep() {
		System.out.println("DEBUG:Executando okPep");
		Pep pep = cotacaoMaterial.getCompraMaterial().getPep();
		if (pep.getId() != null) {
			pep.setId(pep.getId());
		} else {
			messages.error("Selecione uma PEP");
		}
	}

	public boolean isEditando() {
		return cotacaoMaterial.getIdcotacao() != null;
	}

	// metodo para verificar se o participante já consta na lista
	public boolean contemParticipante(ParticipanteMaterial participante,
			List<ParticipanteMaterial> lista) {
		System.out.println("DEBUG: executando contemParticipante");
		boolean contem = false;
		for (ParticipanteMaterial p : lista) {
			if (p.getFornecedor().getIdfornecedor()
					.equals(participante.getFornecedor().getIdfornecedor())) {
				return !contem;
			}

		}
		return contem;
	}

	public void avaliaCompra() {
		cotacaoMaterial.getCompraMaterial().setOkAssist(
				cotacaoMaterial.getCompraMaterial().getOkAssist());
		cotacaoMaterial.getCompraMaterial().setOkEspec(
				cotacaoMaterial.getCompraMaterial().getOkEspec());
		cotacaoMaterial.getCompraMaterial().setOkPrazo(
				cotacaoMaterial.getCompraMaterial().getOkPrazo());
		cotacaoMaterial.getCompraMaterial().setOkVisita(
				cotacaoMaterial.getCompraMaterial().getOkVisita());

	}

	// getters e setters

	public List<CotacaoMaterial> getTodas() {
		System.out.println("DEBUG: todas sendo executado");
		return cotacoes.todasCotacoesMaterial();
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

	public Integer getIndexTab() {
		return indexTab;
	}

	public void setIndexTab(Integer indexTab) {
		this.indexTab = indexTab;
	}

	public CompraMaterial getCompra() {
		return compra;
	}

	public void setCompra(CompraMaterial compra) {
		this.compra = compra;
	}

}
