package br.com.synergy.model;

// Generated 25/07/2015 13:37:07 by Hibernate Tools 4.3.1

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
import javax.persistence.Table;

/**
 * Montagem generated by hbm2java
 */
@Entity
@Table(name = "montagem", catalog = "sistema_gestao")
public class Montagem implements java.io.Serializable {

	private Long idmontagem;
	private Conjunto conjunto;
	private Set<Peca> pecas = new HashSet<Peca>(0);
	private Set<Ferramenta> ferramentas = new HashSet<Ferramenta>(0);

	public Montagem() {
	}

	public Montagem(Conjunto conjunto) {
		this.conjunto = conjunto;
	}

	public Montagem(Conjunto conjunto, Set<Peca> pecas,
			Set<Ferramenta> ferramentas) {
		this.conjunto = conjunto;
		this.pecas = pecas;
		this.ferramentas = ferramentas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idmontagem", unique = true, nullable = false)
	public Long getIdmontagem() {
		return this.idmontagem;
	}

	public void setIdmontagem(Long idmontagem) {
		this.idmontagem = idmontagem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conjunto_idconjunto", nullable = false)
	public Conjunto getConjunto() {
		return this.conjunto;
	}

	public void setConjunto(Conjunto conjunto) {
		this.conjunto = conjunto;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "montagem_has_peca", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "montagem_idmontagem", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "peca_idpeca", nullable = false, updatable = false) })
	public Set<Peca> getPecas() {
		return this.pecas;
	}

	public void setPecas(Set<Peca> pecas) {
		this.pecas = pecas;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "montagem_has_ferramenta", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "montagem_idmontagem", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "ferramenta_idferramenta", nullable = false, updatable = false) })
	public Set<Ferramenta> getFerramentas() {
		return this.ferramentas;
	}

	public void setFerramentas(Set<Ferramenta> ferramentas) {
		this.ferramentas = ferramentas;
	}

}
