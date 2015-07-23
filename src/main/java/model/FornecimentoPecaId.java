package model;

// Generated 23/07/2015 04:16:30 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FornecimentoPecaId generated by hbm2java
 */
@Embeddable
public class FornecimentoPecaId implements java.io.Serializable {

	private long idfornecimentoPeca;
	private long cotacaoPecaIdcotacao;

	public FornecimentoPecaId() {
	}

	public FornecimentoPecaId(long idfornecimentoPeca, long cotacaoPecaIdcotacao) {
		this.idfornecimentoPeca = idfornecimentoPeca;
		this.cotacaoPecaIdcotacao = cotacaoPecaIdcotacao;
	}

	@Column(name = "idfornecimento_peca", nullable = false)
	public long getIdfornecimentoPeca() {
		return this.idfornecimentoPeca;
	}

	public void setIdfornecimentoPeca(long idfornecimentoPeca) {
		this.idfornecimentoPeca = idfornecimentoPeca;
	}

	@Column(name = "cotacao_peca_idcotacao", nullable = false)
	public long getCotacaoPecaIdcotacao() {
		return this.cotacaoPecaIdcotacao;
	}

	public void setCotacaoPecaIdcotacao(long cotacaoPecaIdcotacao) {
		this.cotacaoPecaIdcotacao = cotacaoPecaIdcotacao;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FornecimentoPecaId))
			return false;
		FornecimentoPecaId castOther = (FornecimentoPecaId) other;

		return (this.getIdfornecimentoPeca() == castOther
				.getIdfornecimentoPeca())
				&& (this.getCotacaoPecaIdcotacao() == castOther
						.getCotacaoPecaIdcotacao());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getIdfornecimentoPeca();
		result = 37 * result + (int) this.getCotacaoPecaIdcotacao();
		return result;
	}

}
