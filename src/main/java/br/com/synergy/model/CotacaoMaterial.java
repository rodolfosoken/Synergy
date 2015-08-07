package br.com.synergy.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "cotacao_material", catalog = "sistema_gestao")
@PrimaryKeyJoinColumn(name="cotacao_idcotacao", referencedColumnName="idcotacao")
public class CotacaoMaterial extends Cotacao implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CompraMaterial compraMaterial;
	private Set<ParticipanteMaterial> participanteMateriais = new HashSet<ParticipanteMaterial>(
			0);

	public CotacaoMaterial() {
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "compra_material_idfornecimento_material")
	public CompraMaterial getCompraMaterial() {
		return this.compraMaterial;
	}

	public void setCompraMaterial(CompraMaterial compraMaterial) {
		this.compraMaterial = compraMaterial;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cotacaoMaterial")
	public Set<ParticipanteMaterial> getParticipanteMateriais() {
		return this.participanteMateriais;
	}

	public void setParticipanteMateriais(
			Set<ParticipanteMaterial> participanteMateriais) {
		this.participanteMateriais = participanteMateriais;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CotacaoMaterial other = (CotacaoMaterial) obj;
		if (this.getIdcotacao() == null) {
			if (other.getIdcotacao() != null)
				return false;
		} else if (!this.getIdcotacao().equals(other.getIdcotacao()))
			return false;
		return true;
	}

}
