package br.com.synergy.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private CompraFerramenta compraFerramenta;
	private Set<ParticipanteFerramenta> participantesFerramentas = new HashSet<ParticipanteFerramenta>(
			0);

	public CotacaoFerramenta() {
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "compra_ferramenta_idfornecimento_ferramenta")
	public CompraFerramenta getCompraFerramenta() {
		return this.compraFerramenta;
	}

	public void setCompraFerramenta(CompraFerramenta compraFerramenta) {
		this.compraFerramenta = compraFerramenta;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cotacaoFerramenta", cascade= CascadeType.ALL)
	public Set<ParticipanteFerramenta> getParticipantesFerramentas() {
		return this.participantesFerramentas;
	}

	public void setParticipantesFerramentas(
			Set<ParticipanteFerramenta> participantesFerramentas) {
		this.participantesFerramentas = participantesFerramentas;
	}

}
