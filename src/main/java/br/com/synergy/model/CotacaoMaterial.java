package br.com.synergy.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "cotacao_material", catalog = "sistema_gestao")
@PrimaryKeyJoinColumn(name="cotacao_idcotacao", referencedColumnName="idcotacao")
public class CotacaoMaterial extends Cotacao implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private ParticipanteMaterial participanteMaterial;

	public CotacaoMaterial() {
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "participante_material_idparticipante", nullable = false)
	public ParticipanteMaterial getParticipanteMaterial() {
		return this.participanteMaterial;
	}

	public void setParticipanteMaterial(
			ParticipanteMaterial participanteMaterial) {
		this.participanteMaterial = participanteMaterial;
	}


}
