package br.com.synergy.model;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "participante_ferramenta", catalog = "sistema_gestao")
public class ParticipanteFerramenta implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long idparticipanteFerramenta;
	private CotacaoFerramenta cotacaoFerramenta;
	private Fornecedor fornecedor;
	private Double valor;

	public ParticipanteFerramenta() {
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
	
	@Column(name = "valor", precision = 22, scale = 0)
	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}


}
