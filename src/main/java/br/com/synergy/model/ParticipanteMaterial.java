package br.com.synergy.model;

// Generated 06/08/2015 08:46:26 by Hibernate Tools 3.4.0.CR1

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

/**
 * ParticipanteMaterial generated by hbm2java
 */
@Entity
@Table(name = "participante_material", catalog = "sistema_gestao")
public class ParticipanteMaterial implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long idparticipante;
	private CotacaoMaterial cotacaoMaterial;
	private Fornecedor fornecedor;
	private Set<Material> materiais = new HashSet<Material>(0);

	public ParticipanteMaterial() {
	}

	public ParticipanteMaterial(CotacaoMaterial cotacaoMaterial,
			Fornecedor fornecedor) {
		this.cotacaoMaterial = cotacaoMaterial;
		this.fornecedor = fornecedor;
	}

	public ParticipanteMaterial(CotacaoMaterial cotacaoMaterial,
			Fornecedor fornecedor, Set<Material> materiais) {
		this.cotacaoMaterial = cotacaoMaterial;
		this.fornecedor = fornecedor;
		this.materiais = materiais;
	}

	@Id
	@GeneratedValue
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fornecedor_idfornecedor", nullable = false)
	public Fornecedor getFornecedor() {
		return this.fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "participanteMaterial", cascade= CascadeType.ALL)
	public Set<Material> getMateriais() {
		return this.materiais;
	}

	public void setMateriais(Set<Material> materiais) {
		this.materiais = materiais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idparticipante == null) ? 0 : idparticipante.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParticipanteMaterial other = (ParticipanteMaterial) obj;
		if (idparticipante == null) {
			if (other.idparticipante != null)
				return false;
		} else if (!idparticipante.equals(other.idparticipante))
			return false;
		return true;
	}
	


}
