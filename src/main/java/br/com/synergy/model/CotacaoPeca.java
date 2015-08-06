package br.com.synergy.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "cotacao_peca", catalog = "sistema_gestao")
@PrimaryKeyJoinColumn(name="cotacao_idcotacao", referencedColumnName="idcotacao")
public class CotacaoPeca extends Cotacao implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private ParticipantePeca participantePeca;

	public CotacaoPeca() {
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "participante_peca_idparticipante_peca", nullable = false)
	public ParticipantePeca getParticipantePeca() {
		return this.participantePeca;
	}

	public void setParticipantePeca(ParticipantePeca participantePeca) {
		this.participantePeca = participantePeca;
	}



}
