package br.com.synergy.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

import br.com.synergy.model.Cotacao;
import br.com.synergy.model.CotacaoFerramenta;
import br.com.synergy.model.Ferramenta;
import br.com.synergy.model.FornecedorFerramenta;
import br.com.synergy.model.ParticipanteFerramenta;
import br.com.synergy.model.Usuario;
import br.com.synergy.repository.Cotacoes;
import br.com.synergy.repository.Fornecedores;
import br.com.synergy.repository.Participantes;
import br.com.synergy.repository.Usuarios;
import br.com.synergy.security.UsuarioPrincipal;
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
	private Usuarios usuarios;

	@Inject
	private Fornecedores fornecedores;

	@Inject
	private CadastroCotacaoFerramentaService cadastro;

	@Inject
	private Cotacoes cotacoes;

	@Inject
	private Participantes participantes;

	private CotacaoFerramenta cotacaoFerramenta;

	private ParticipanteFerramenta participanteSelecionado;
	private ParticipanteFerramenta participanteFerramenta;
	private Integer indexTab = 0;

	public CotacaoFerramentaBean() {
		limpar();

	}

	public void verificaEdicao() {
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

	public void editar(Long id) {
		System.out.println("DEBUG: Executando editar");
		// Busca por id para resgatar o objeto com a coleção de fornecedores
		// evitando uma Lazy exception
		
		Cotacao c = cotacoes.buscaPorId(id);

		if (c != null) {
			cotacaoFerramenta = (CotacaoFerramenta) c;

			// faz a busca (o fetch join) da coleção de ferramentas de cada
			// fornecedor
			// evitar a Lazy exception
			List<ParticipanteFerramenta> lista = new ArrayList<ParticipanteFerramenta>();
			for (ParticipanteFerramenta p : cotacaoFerramenta
					.getParticipantesFerramentas()) {
				lista.add(participantes.buscaPorId(p
						.getIdparticipanteFerramenta()));
			}
			cotacaoFerramenta.setParticipantesFerramentas(lista);
			indexTab = 0;
		} else {
			limpar();
			messages.error("Cotação não encontrada");
			RequestContext.getCurrentInstance().update(
					Arrays.asList("frm:messages", "frm"));
			
		}

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

	// referencia a cotação na ferramenta da cotação
	public void adicionarFerramenta() {
		System.out.println("DEBUG: executando adcionarFerramenta");
		cotacaoFerramenta.getFerramenta().setCotacao(cotacaoFerramenta);
	}

	public String salvarCotacao() {
		System.out.println("DEBUG: executando salvarCotaçao");
		if (!cotacaoFerramenta.getParticipantesFerramentas().isEmpty()) {
			adicionarFerramenta();
			cadastro.salvar(cotacaoFerramenta);
			messages.info("Cotação salva com sucesso!");

			limpar();
			RequestContext.getCurrentInstance().update(
					Arrays.asList("frm:messages", "frm"));
			if (!isEditando())
				return "pesquisaCotacaoFerramenta?faces-redirect=true";
		} else {
			messages.error("Fornecedor Vazio");
			indexTab = 1;
		}
		return null;

	}

	// adiciona o fornecedor na lista da cotação
	public void adicionarFornecedor() {
		System.out.println("DEBUG: executando adicionarFornecedor");
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

	// conclui a cotação
	public void concluir() {
		System.out.println("DEBUG: executando concluir");
		cotacaoFerramenta.setDataTermino(new Date());
		cotacaoFerramenta.setConcluida(true);
		cotacaoFerramenta.getFerramenta().setDisponivel(true);
		// redireciona para a aba de compra
		indexTab = 2;
	}

	// desfaz a conclusão da cotação e marca como em andamento
	public void desmarcar() {
		System.out.println("DEBUG: executando desmarcar");
		cotacaoFerramenta.setDataTermino(null);
		cotacaoFerramenta.setConcluida(false);
		cotacaoFerramenta.getFerramenta().setDisponivel(false);
		
		// redireciona para a aba inicial
		indexTab = 0;
	}

	public boolean isEditando() {
		return cotacaoFerramenta.getIdcotacao() != null;
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

}
