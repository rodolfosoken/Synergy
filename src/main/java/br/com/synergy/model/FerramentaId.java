package br.com.synergy.model;

// Generated 23/07/2015 04:16:30 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FerramentaId generated by hbm2java
 */
@Embeddable
public class FerramentaId implements java.io.Serializable {

	private long idferramenta;
	private long cotacaoFerramentaIdcotacao;

	public FerramentaId() {
	}

	public FerramentaId(long idferramenta, long cotacaoFerramentaIdcotacao) {
		this.idferramenta = idferramenta;
		this.cotacaoFerramentaIdcotacao = cotacaoFerramentaIdcotacao;
	}

	@Column(name = "idferramenta", nullable = false)
	public long getIdferramenta() {
		return this.idferramenta;
	}

	public void setIdferramenta(long idferramenta) {
		this.idferramenta = idferramenta;
	}

	@Column(name = "cotacao_ferramenta_idcotacao", nullable = false)
	public long getCotacaoFerramentaIdcotacao() {
		return this.cotacaoFerramentaIdcotacao;
	}

	public void setCotacaoFerramentaIdcotacao(long cotacaoFerramentaIdcotacao) {
		this.cotacaoFerramentaIdcotacao = cotacaoFerramentaIdcotacao;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FerramentaId))
			return false;
		FerramentaId castOther = (FerramentaId) other;

		return (this.getIdferramenta() == castOther.getIdferramenta())
				&& (this.getCotacaoFerramentaIdcotacao() == castOther
						.getCotacaoFerramentaIdcotacao());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getIdferramenta();
		result = 37 * result + (int) this.getCotacaoFerramentaIdcotacao();
		return result;
	}

}