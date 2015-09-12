package br.com.synergy.model;


import java.util.ArrayList;
import java.util.List;

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
	private String descricao;
	private List<Pep> peps = new ArrayList<Pep>();

	public Conta() {
	}

	public Conta(long idConta) {
		this.idConta = idConta;
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
	public List<Pep> getPeps() {
		return this.peps;
	}

	public void setPeps(List<Pep> peps) {
		this.peps = peps;
	}
	
	@Column(name="descricao")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
