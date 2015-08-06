package br.com.synergy.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cotacao_ferramenta", catalog = "sistema_gestao")
@PrimaryKeyJoinColumn(name="cotacao_idcotacao", referencedColumnName="idcotacao")
public class CotacaoFerramenta extends Cotacao implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Set<ParticipanteFerramenta> participanteFerramentas = new HashSet<ParticipanteFerramenta>(
			0);

	public CotacaoFerramenta() {
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cotacaoFerramenta")
	public Set<ParticipanteFerramenta> getParticipanteFerramentas() {
		return this.participanteFerramentas;
	}

	public void setParticipanteFerramentas(
			Set<ParticipanteFerramenta> participanteFerramentas) {
		this.participanteFerramentas = participanteFerramentas;
	}

}
