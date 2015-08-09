package br.com.synergy.model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "conta", catalog = "sistema_gestao")
public class Conta implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private long idConta;
	private String numeroConta;
	private Set<Pep> peps = new HashSet<Pep>(0);

	public Conta() {
	}

	public Conta(long idConta) {
		this.idConta = idConta;
	}

	public Conta(long idConta, String numeroConta, Set<Pep> peps) {
		this.idConta = idConta;
		this.numeroConta = numeroConta;
		this.peps = peps;
	}

	@Id
	@Column(name = "idConta", unique = true, nullable = false)
	public long getIdConta() {
		return this.idConta;
	}

	public void setIdConta(long idConta) {
		this.idConta = idConta;
	}

	@Column(name = "numero_conta", length = 45)
	public String getNumeroConta() {
		return this.numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conta")
	public Set<Pep> getPeps() {
		return this.peps;
	}

	public void setPeps(Set<Pep> peps) {
		this.peps = peps;
	}

}
