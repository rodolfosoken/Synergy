package br.com.synergy.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PepId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
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
