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
@Table(name = "cotacao_peca", catalog = "sistema_gestao")
@PrimaryKeyJoinColumn(name="cotacao_idcotacao", referencedColumnName="idcotacao")
public class CotacaoPeca extends Cotacao implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private CompraPeca compraPeca;
	private Set<ParticipantePeca> participantePecas = new HashSet<ParticipantePeca>(
			0);

	public CotacaoPeca() {
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "compra_peca_idfornecimento_peca")
	public CompraPeca getCompraPeca() {
		return this.compraPeca;
	}

	public void setCompraPeca(CompraPeca compraPeca) {
		this.compraPeca = compraPeca;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cotacaoPeca")
	public Set<ParticipantePeca> getParticipantePecas() {
		return this.participantePecas;
	}

	public void setParticipantePecas(Set<ParticipantePeca> participantePecas) {
		this.participantePecas = participantePecas;
	}

}
