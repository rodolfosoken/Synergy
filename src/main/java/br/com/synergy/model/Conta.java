package br.com.synergy.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idConta", unique = true, nullable = false)
	public long getIdConta() {
		return this.idConta;
	}

	public void setIdConta(long idConta) {
		this.idConta = idConta;
	}
	
	@NotNull
	@NotBlank
	@Column(name = "numero_conta", length = 45)
	public String getNumeroConta() {
		return this.numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conta", cascade = CascadeType.ALL)
	public List<Pep> getPeps() {
		return this.peps;
	}

	public void setPeps(List<Pep> peps) {
		this.peps = peps;
	}
	
	@NotNull
	@NotBlank
	@Column(name = "descricao")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
