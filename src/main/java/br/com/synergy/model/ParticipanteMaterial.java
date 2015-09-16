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
@Table(name = "participante_material", catalog = "sistema_gestao")
public class ParticipanteMaterial implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long idparticipante;
	private CotacaoMaterial cotacaoMaterial;
	private Fornecedor fornecedor;
	private Double valor;

	public ParticipanteMaterial() {
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idparticipante", unique = true, nullable = false)
	public Long getIdparticipante() {
		return this.idparticipante;
	}

	public void setIdparticipante(Long idparticipante) {
		this.idparticipante = idparticipante;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cotacao_material_cotacao_idcotacao", nullable = false)
	public CotacaoMaterial getCotacaoMaterial() {
		return this.cotacaoMaterial;
	}

	public void setCotacaoMaterial(CotacaoMaterial cotacaoMaterial) {
		this.cotacaoMaterial = cotacaoMaterial;
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
