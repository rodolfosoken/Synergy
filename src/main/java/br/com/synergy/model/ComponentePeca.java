package br.com.synergy.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "componente_peca", catalog = "sistema_gestao")
public class ComponentePeca implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long idcomponentePeca;
	private Peca peca;
	private Conjunto conjunto;
	private Integer quantidade;
	private Set<Montagem> montagems = new HashSet<Montagem>(0);

	public ComponentePeca() {
	}

	public ComponentePeca(Peca peca, Conjunto conjunto) {
		this.peca = peca;
		this.conjunto = conjunto;
	}

	public ComponentePeca(Peca peca, Conjunto conjunto, Integer quantidade,
			Set<Montagem> montagems) {
		this.peca = peca;
		this.conjunto = conjunto;
		this.quantidade = quantidade;
		this.montagems = montagems;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcomponente_peca", unique = true, nullable = false)
	public Long getIdcomponentePeca() {
		return this.idcomponentePeca;
	}

	public void setIdcomponentePeca(Long idcomponentePeca) {
		this.idcomponentePeca = idcomponentePeca;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "peca_idpeca", nullable = false)
	public Peca getPeca() {
		return this.peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conjunto_idconjunto", nullable = false)
	public Conjunto getConjunto() {
		return this.conjunto;
	}

	public void setConjunto(Conjunto conjunto) {
		this.conjunto = conjunto;
	}

	@Column(name = "quantidade")
	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "montagem_has_componente_peca", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "componente_peca_idcomponente_peca", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "montagem_idmontagem", nullable = false, updatable = false) })
	public Set<Montagem> getMontagems() {
		return this.montagems;
	}

	public void setMontagems(Set<Montagem> montagems) {
		this.montagems = montagems;
	}

}
