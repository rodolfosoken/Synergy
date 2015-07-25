package br.com.synergy.model;

// Generated 25/07/2015 13:37:07 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PepId generated by hbm2java
 */
@Embeddable
public class PepId implements java.io.Serializable {

	private long idpep;
	private long contaIdConta;

	public PepId() {
	}

	public PepId(long idpep, long contaIdConta) {
		this.idpep = idpep;
		this.contaIdConta = contaIdConta;
	}

	@Column(name = "idpep", nullable = false)
	public long getIdpep() {
		return this.idpep;
	}

	public void setIdpep(long idpep) {
		this.idpep = idpep;
	}

	@Column(name = "Conta_idConta", nullable = false)
	public long getContaIdConta() {
		return this.contaIdConta;
	}

	public void setContaIdConta(long contaIdConta) {
		this.contaIdConta = contaIdConta;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PepId))
			return false;
		PepId castOther = (PepId) other;

		return (this.getIdpep() == castOther.getIdpep())
				&& (this.getContaIdConta() == castOther.getContaIdConta());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getIdpep();
		result = 37 * result + (int) this.getContaIdConta();
		return result;
	}

}
