package br.com.synergy.model;

// Generated 24/07/2015 08:08:22 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FornecedorId generated by hbm2java
 */
@Embeddable
public class FornecedorId implements java.io.Serializable {

	private long idfornecedor;
	private long enderecoIdendereco;

	public FornecedorId() {
	}

	public FornecedorId(long idfornecedor, long enderecoIdendereco) {
		this.idfornecedor = idfornecedor;
		this.enderecoIdendereco = enderecoIdendereco;
	}

	@Column(name = "idfornecedor", nullable = false)
	public long getIdfornecedor() {
		return this.idfornecedor;
	}

	public void setIdfornecedor(long idfornecedor) {
		this.idfornecedor = idfornecedor;
	}

	@Column(name = "endereco_idendereco", nullable = false)
	public long getEnderecoIdendereco() {
		return this.enderecoIdendereco;
	}

	public void setEnderecoIdendereco(long enderecoIdendereco) {
		this.enderecoIdendereco = enderecoIdendereco;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FornecedorId))
			return false;
		FornecedorId castOther = (FornecedorId) other;

		return (this.getIdfornecedor() == castOther.getIdfornecedor())
				&& (this.getEnderecoIdendereco() == castOther
						.getEnderecoIdendereco());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getIdfornecedor();
		result = 37 * result + (int) this.getEnderecoIdendereco();
		return result;
	}

}
