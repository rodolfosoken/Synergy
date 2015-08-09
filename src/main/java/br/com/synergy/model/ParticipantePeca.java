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
@Table(name = "participante_peca", catalog = "sistema_gestao")
public class ParticipantePeca implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long idparticipantePeca;
	private CotacaoPeca cotacaoPeca;
	private Fornecedor fornecedor;
	private Set<Peca> pecas = new HashSet<Peca>(0);

	public ParticipantePeca() {
	}

	public ParticipantePeca(CotacaoPeca cotacaoPeca, Fornecedor fornecedor) {
		this.cotacaoPeca = cotacaoPeca;
		this.fornecedor = fornecedor;
	}

	public ParticipantePeca(CotacaoPeca cotacaoPeca, Fornecedor fornecedor,
			Set<Peca> pecas) {
		this.cotacaoPeca = cotacaoPeca;
		this.fornecedor = fornecedor;
		this.pecas = pecas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idparticipante_peca", unique = true, nullable = false)
	public Long getIdparticipantePeca() {
		return this.idparticipantePeca;
	}

	public void setIdparticipantePeca(Long idparticipantePeca) {
		this.idparticipantePeca = idparticipantePeca;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cotacao_peca_cotacao_idcotacao", nullable = false)
	public CotacaoPeca getCotacaoPeca() {
		return this.cotacaoPeca;
	}

	public void setCotacaoPeca(CotacaoPeca cotacaoPeca) {
		this.cotacaoPeca = cotacaoPeca;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fornecedor_idfornecedor", nullable = false)
	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "participantePeca", cascade= CascadeType.ALL)
	public Set<Peca> getPecas() {
		return this.pecas;
	}

	public void setPecas(Set<Peca> pecas) {
		this.pecas = pecas;
	}

}
