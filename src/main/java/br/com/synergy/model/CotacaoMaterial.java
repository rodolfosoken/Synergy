package br.com.synergy.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private Set<ParticipanteMaterial> participanteMaterials = new HashSet<ParticipanteMaterial>(
			0);

	public CotacaoMaterial() {
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cotacaoMaterial")
	public Set<ParticipanteMaterial> getParticipanteMaterials() {
		return this.participanteMaterials;
	}

	public void setParticipanteMaterials(
			Set<ParticipanteMaterial> participanteMaterials) {
		this.participanteMaterials = participanteMaterials;
	}

}
