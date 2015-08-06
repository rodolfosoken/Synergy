package br.com.synergy.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cotacao_ferramenta", catalog = "sistema_gestao")
@PrimaryKeyJoinColumn(name="cotacao_idcotacao", referencedColumnName="idcotacao")
public class CotacaoFerramenta extends Cotacao implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private ParticipanteFerramenta participanteFerramenta;


	public CotacaoFerramenta() {
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "participante_ferramenta_idparticipante_ferramenta", nullable = false)
	public ParticipanteFerramenta getParticipanteFerramenta() {
		return this.participanteFerramenta;
	}

	public void setParticipanteFerramenta(
			ParticipanteFerramenta participanteFerramenta) {
		this.participanteFerramenta = participanteFerramenta;
	}


}
