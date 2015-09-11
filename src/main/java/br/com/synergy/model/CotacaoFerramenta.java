package br.com.synergy.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table(name = "cotacao_ferramenta", catalog = "sistema_gestao")
@PrimaryKeyJoinColumn(name="cotacao_idcotacao", referencedColumnName="idcotacao")
public class CotacaoFerramenta extends Cotacao implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Ferramenta ferramenta;
	private CompraFerramenta compraFerramenta;
	private String sor;
	private List<ParticipanteFerramenta> participantesFerramentas = new ArrayList<ParticipanteFerramenta>(
			0);

	public CotacaoFerramenta() {
	}
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "ferramenta_idferramenta", nullable = false)
	public Ferramenta getFerramenta() {
		return this.ferramenta;
	}

	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
	}
	

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "compra_ferramenta_idcompra_ferramenta")
	public CompraFerramenta getCompraFerramenta() {
		return this.compraFerramenta;
	}

	public void setCompraFerramenta(CompraFerramenta compraFerramenta) {
		this.compraFerramenta = compraFerramenta;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cotacaoFerramenta", cascade= CascadeType.ALL)
	public List<ParticipanteFerramenta> getParticipantesFerramentas() {
		return this.participantesFerramentas;
	}

	public void setParticipantesFerramentas(
			List<ParticipanteFerramenta> participantesFerramentas) {
		this.participantesFerramentas = participantesFerramentas;
	}
	
	@Column(name = "SOR")
	public String getSor() {
		return this.sor;
	}

	public void setSor(String sor) {
		this.sor = sor;
	}
	

}
