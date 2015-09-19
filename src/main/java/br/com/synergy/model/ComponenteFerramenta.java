package br.com.synergy.model;


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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "componente_ferramenta", catalog = "sistema_gestao")
public class ComponenteFerramenta implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long idcomponenteFerramenta;
	private Ferramenta ferramenta;
	private Conjunto conjunto;
	private Integer quantidade;
	private Set<Montagem> montagems = new HashSet<Montagem>(0);

	public ComponenteFerramenta() {
	}

	public ComponenteFerramenta(Ferramenta ferramenta, Conjunto conjunto) {
		this.ferramenta = ferramenta;
		this.conjunto = conjunto;
	}

	public ComponenteFerramenta(Ferramenta ferramenta, Conjunto conjunto,
			Integer quantidade, Set<Montagem> montagems) {
		this.ferramenta = ferramenta;
		this.conjunto = conjunto;
		this.quantidade = quantidade;
		this.montagems = montagems;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcomponente_ferramenta", unique = true, nullable = false)
	public Long getIdcomponenteFerramenta() {
		return this.idcomponenteFerramenta;
	}

	public void setIdcomponenteFerramenta(Long idcomponenteFerramenta) {
		this.idcomponenteFerramenta = idcomponenteFerramenta;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ferramenta_idferramenta", nullable = false)
	public Ferramenta getFerramenta() {
		return this.ferramenta;
	}

	public void setFerramenta(Ferramenta ferramenta) {
		this.ferramenta = ferramenta;
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
	@JoinTable(name = "montagem_has_componente_ferramenta", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "componente_ferramenta_idcomponente_ferramenta", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "montagem_idmontagem", nullable = false, updatable = false) })
	public Set<Montagem> getMontagems() {
		return this.montagems;
	}

	public void setMontagems(Set<Montagem> montagems) {
		this.montagems = montagems;
	}

}
