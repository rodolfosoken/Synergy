package br.com.synergy.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "cotacao_peca", catalog = "sistema_gestao")
public class CotacaoPeca implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idcotacao;
	private String responsavel;
	private Date data;
	private String descricao;
	private Set<Fornecedor> fornecedors = new HashSet<Fornecedor>(0);
	private Set<FornecimentoPeca> fornecimentoPecas = new HashSet<FornecimentoPeca>(
			0);
	private Set<Peca> pecas = new HashSet<Peca>(0);

	public CotacaoPeca() {
	}

	public CotacaoPeca(String responsavel, Date data,
			Set<Fornecedor> fornecedors,
			Set<FornecimentoPeca> fornecimentoPecas, Set<Peca> pecas) {
		this.responsavel = responsavel;
		this.data = data;
		this.fornecedors = fornecedors;
		this.fornecimentoPecas = fornecimentoPecas;
		this.pecas = pecas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcotacao", unique = true, nullable = false)
	public Long getIdcotacao() {
		return this.idcotacao;
	}

	public void setIdcotacao(Long idcotacao) {
		this.idcotacao = idcotacao;
	}

	@Column(name = "responsavel")
	public String getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	@NotEmpty
	@Column(name = "descricao")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data", length = 10)
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cotacao_peca_has_fornecedor", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "cotacao_peca_idcotacao", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "fornecedor_idfornecedor", nullable = false, updatable = false) })
	public Set<Fornecedor> getFornecedors() {
		return this.fornecedors;
	}

	public void setFornecedors(Set<Fornecedor> fornecedors) {
		this.fornecedors = fornecedors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cotacaoPeca")
	public Set<FornecimentoPeca> getFornecimentoPecas() {
		return this.fornecimentoPecas;
	}

	public void setFornecimentoPecas(Set<FornecimentoPeca> fornecimentoPecas) {
		this.fornecimentoPecas = fornecimentoPecas;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cotacao_peca_has_peca", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "cotacao_peca_idcotacao", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "peca_idpeca", nullable = false, updatable = false) })
	public Set<Peca> getPecas() {
		return this.pecas;
	}

	public void setPecas(Set<Peca> pecas) {
		this.pecas = pecas;
	}

}
