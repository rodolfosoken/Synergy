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

import br.com.synergy.model.CompraFerramenta;
import br.com.synergy.model.Cotacao;
import br.com.synergy.model.CotacaoFerramenta;
import br.com.synergy.model.Ferramenta;
import br.com.synergy.model.FornecedorFerramenta;
import br.com.synergy.model.ParticipanteFerramenta;
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
public class CotacaoFerramentaBean implements Serializable {

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

	private CotacaoFerramenta cotacaoFerramenta;
	private CompraFerramenta compra;

	private ParticipanteFerramenta participanteSelecionado;
	private ParticipanteFerramenta participanteFerramenta;
	private Integer indexTab = 0;

	public CotacaoFerramentaBean() {
		limpar();
		compra = new CompraFerramenta();

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
		cotacaoFerramenta = new CotacaoFerramenta();
		participanteFerramenta = new ParticipanteFerramenta();
		participanteSelecionado = null;
		cotacaoFerramenta.setUsuario(UsuarioPrincipal.getUsuarioLogado()
				.getUsuario());
		cotacaoFerramenta.setDataInicio(new Date());
		cotacaoFerramenta.setConcluida(false);
		cotacaoFerramenta.setComprado(false);
		cotacaoFerramenta.setFerramenta(new Ferramenta());

		indexTab = 0;
	}

	public String salvarCotacao() {
		System.out.println("DEBUG: executando salvarCotaçao");

		// verifica se foi adicionado algum fornecedor antes de salvar
		if (!cotacaoFerramenta.getParticipantesFerramentas().isEmpty()) {

			if (cotacaoFerramenta.getConcluida()
					&& cotacaoFerramenta.getCompraFerramenta() != null) {

				// coloca a cotação como comprada
				cotacaoFerramenta.setComprado(true);

			}

			// faz as referências da ferramenta para a cotação
			adicionarFerramenta();
			try {
				cadastro.salvar(cotacaoFerramenta);
				messages.info("Cotação salva com sucesso!");

				limpar();

				// se estiver editando, voltar para a tela pesquisa de cotações
				if (!isEditando())
					return "pesquisaCotacaoFerramenta?ok=true faces-redirect=true";
			} catch (Exception e) {
				messages.error("Não foi possível salvar:",
						RootCauseExctractor.extractRootCauseMessage(e));
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

			// faz a busca (o fetch join) da coleção de ferramentas de cada
			// fornecedor
			// evitar a Lazy exception
			cotacaoFerramenta = cotacoes
					.buscaFetchParticipantesCotacaoFerramenta(c.getIdcotacao());

			// Busca pep da cotação se ela já foi comprada
			if (cotacaoFerramenta.getComprado()) {
				System.out.println("DEBUG: Executando Fetch Compra Ferramenta");
				cotacaoFerramenta = cotacoes
						.buscaFetchCompraFerramenta(cotacaoFerramenta
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
		compra.setCotacaoFerramenta(cotacaoFerramenta);
		cotacaoFerramenta.setCompraFerramenta(compra);

		// passa o preço do participante para compra da cotação
		cotacaoFerramenta.getCompraFerramenta().setPreco(
				compra.getParticipante().getValor());

		// seta a data atual para a aquisição do produto
		cotacaoFerramenta.getCompraFerramenta().setDataAquisicao(new Date());

		// Faz a ferramenta ficar disponivel
		cotacaoFerramenta.getFerramenta().setDisponivel(true);

		// redireciona para a aba de compra
		indexTab = 2;
	}

	// referencia a cotação na ferramenta da cotação
	public void adicionarFerramenta() {
		System.out.println("DEBUG: executando adcionarFerramenta");
		cotacaoFerramenta.getFerramenta().setCotacao(cotacaoFerramenta);
	}

	// adiciona o fornecedor na lista da cotação
	public void adicionarFornecedor() {
		System.out.println("DEBUG: executando adicionarFornecedor");

		// ao adicionar o fornecedor, verificar se o valor foi preenchido e o
		// fornecedor selecionado
		if (participanteFerramenta.getFornecedor() == null
				|| participanteFerramenta.getValor() == null) {

			messages.error("Preencha os campos corretamenta");
			RequestContext.getCurrentInstance().update("frm:growl");

			// verifica se o participante já foi adicionado
		} else if (!contemParticipante(participanteFerramenta,
				cotacaoFerramenta.getParticipantesFerramentas())) {

			// Referência bidirecional
			participanteFerramenta.setCotacaoFerramenta(cotacaoFerramenta);
			cotacaoFerramenta.getParticipantesFerramentas().add(
					participanteFerramenta);

			// limpa a instância do bean
			participanteFerramenta = new ParticipanteFerramenta();
		} else {
			messages.error("Fornecedor já foi adicionado!");
			RequestContext.getCurrentInstance().update("frm:growl");
		}
	}

	public void removerFornecedor() {
		System.out.println("DEBUG: executando removerFornecedor");
		cotacaoFerramenta.getParticipantesFerramentas().remove(
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
	public List<FornecedorFerramenta> completarFornecedor(String nome) {
		System.out.println("DEBUG: executando CompletarFornecedor");
		return fornecedores.buscaPorFornecedorFerramenta(nome);
	}

	// conclui a cotação
	public void concluir() {
		System.out.println("DEBUG: executando concluir");
		cotacaoFerramenta.setDataTermino(new Date());
		cotacaoFerramenta.setConcluida(true);
		// redireciona para a aba de compra
		indexTab = 1;
	}

	// desfaz a conclusão da cotação e marca como em andamento
	public void desmarcar() {
		System.out.println("DEBUG: executando desmarcar");
		cotacaoFerramenta.setDataTermino(null);
		cotacaoFerramenta.setConcluida(false);
		cotacaoFerramenta.getFerramenta().setDisponivel(false);
		cotacaoFerramenta.setComprado(false);
		cotacaoFerramenta.setCompraFerramenta(null);

		// redireciona para a aba inicial
		indexTab = 0;
	}

	public void okPep() {
		System.out.println("DEBUG:Executando okPep");
		Pep pep = cotacaoFerramenta.getCompraFerramenta().getPep();
		if (pep.getId() != null) {
			pep.setId(pep.getId());
		} else {
			messages.error("Selecione uma PEP");
		}
	}

	public boolean isEditando() {
		return cotacaoFerramenta.getIdcotacao() != null;
	}

	// metodo para verificar se o participante já consta na lista
	public boolean contemParticipante(ParticipanteFerramenta participante,
			List<ParticipanteFerramenta> lista) {
		System.out.println("DEBUG: executando contemParticipante");
		boolean contem = false;
		for (ParticipanteFerramenta p : lista) {
			if (p.getFornecedor().getIdfornecedor()
					.equals(participante.getFornecedor().getIdfornecedor())) {
				return !contem;
			}

		}
		return contem;
	}

	public void avaliaCompra() {
		cotacaoFerramenta.getCompraFerramenta().setOkAssist(
				cotacaoFerramenta.getCompraFerramenta().getOkAssist());
		cotacaoFerramenta.getCompraFerramenta().setOkEspec(
				cotacaoFerramenta.getCompraFerramenta().getOkEspec());
		cotacaoFerramenta.getCompraFerramenta().setOkPrazo(
				cotacaoFerramenta.getCompraFerramenta().getOkPrazo());
		cotacaoFerramenta.getCompraFerramenta().setOkVisita(
				cotacaoFerramenta.getCompraFerramenta().getOkVisita());

	}

	// getters e setters

	public List<CotacaoFerramenta> getTodas() {
		System.out.println("DEBUG: todas sendo executado");
		return cotacoes.todasCotacoesFerramentas();
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

	public CompraFerramenta getCompra() {
		return compra;
	}

	public void setCompra(CompraFerramenta compra) {
		this.compra = compra;
	}

}
