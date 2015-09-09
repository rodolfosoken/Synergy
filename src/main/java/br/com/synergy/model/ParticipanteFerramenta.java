package br.com.synergy.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "participante_ferramenta", catalog = "sistema_gestao")
public class ParticipanteFerramenta implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long idparticipanteFerramenta;
	private CotacaoFerramenta cotacaoFerramenta;
	private Fornecedor fornecedor;
	private Set<Ferramenta> ferramentas = new HashSet<Ferramenta>(0);

	public ParticipanteFerramenta() {
	}

	public ParticipanteFerramenta(CotacaoFerramenta cotacaoFerramenta,
			Fornecedor fornecedor) {
		this.cotacaoFerramenta = cotacaoFerramenta;
		this.fornecedor = fornecedor;
	}

	public ParticipanteFerramenta(CotacaoFerramenta cotacaoFerramenta,
			Fornecedor fornecedor, Set<Ferramenta> ferramentas) {
		this.cotacaoFerramenta = cotacaoFerramenta;
		this.fornecedor = fornecedor;
		this.ferramentas = ferramentas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idparticipante_ferramenta", unique = true, nullable = false)
	public Long getIdparticipanteFerramenta() {
		return this.idparticipanteFerramenta;
	}

	public void setIdparticipanteFerramenta(Long idparticipanteFerramenta) {
		this.idparticipanteFerramenta = idparticipanteFerramenta;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cotacao_ferramenta_cotacao_idcotacao", nullable = false)
	public CotacaoFerramenta getCotacaoFerramenta() {
		return this.cotacaoFerramenta;
	}

	public void setCotacaoFerramenta(CotacaoFerramenta cotacaoFerramenta) {
		this.cotacaoFerramenta = cotacaoFerramenta;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fornecedor_idfornecedor", nullable = false)
	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "participanteFerramenta", cascade= CascadeType.ALL)
	public Set<Ferramenta> getFerramentas() {
		return this.ferramentas;
	}

	public void setFerramentas(Set<Ferramenta> ferramentas) {
		this.ferramentas = ferramentas;
	}

}
