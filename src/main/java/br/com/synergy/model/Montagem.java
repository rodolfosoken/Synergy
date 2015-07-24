package br.com.synergy.model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "montagem", catalog = "sistema_gestao")
public class Montagem implements java.io.Serializable {

	private MontagemId id;
	private Conjunto conjunto;
	private Set<Peca> pecas = new HashSet<Peca>(0);
	private Set<Ferramenta> ferramentas = new HashSet<Ferramenta>(0);

	public Montagem() {
	}

	public Montagem(MontagemId id, Conjunto conjunto) {
		this.id = id;
		this.conjunto = conjunto;
	}

	public Montagem(MontagemId id, Conjunto conjunto, Set<Peca> pecas,
			Set<Ferramenta> ferramentas) {
		this.id = id;
		this.conjunto = conjunto;
		this.pecas = pecas;
		this.ferramentas = ferramentas;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idmontagem", column = @Column(name = "idmontagem", nullable = false)),
			@AttributeOverride(name = "conjuntoIdconjunto", column = @Column(name = "conjunto_idconjunto", nullable = false)) })
	public MontagemId getId() {
		return this.id;
	}

	public void setId(MontagemId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conjunto_idconjunto", nullable = false, insertable = false, updatable = false)
	public Conjunto getConjunto() {
		return this.conjunto;
	}

	public void setConjunto(Conjunto conjunto) {
		this.conjunto = conjunto;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "montagem_has_peca", catalog = "sistema_gestao", joinColumns = {
			@JoinColumn(name = "montagem_idmontagem", nullable = false, updatable = false),
			@JoinColumn(name = "montagem_conjunto_idconjunto", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "peca_idpeca", nullable = false, updatable = false),
			@JoinColumn(name = "peca_material_idmaterial", nullable = false, updatable = false),
			@JoinColumn(name = "peca_idpeca_cotacao_material_idcotacao", nullable = false, updatable = false)})
	public Set<Peca> getPecas() {
		return this.pecas;
	}

	public void setPecas(Set<Peca> pecas) {
		this.pecas = pecas;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "montagem_has_ferramenta", catalog = "sistema_gestao", joinColumns = {
			@JoinColumn(name = "montagem_idmontagem", nullable = false, updatable = false),
			@JoinColumn(name = "montagem_conjunto_idconjunto", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "ferramenta_idferramenta", nullable = false, updatable = false),
			@JoinColumn(name = "ferramenta_cotacao_ferramenta_idcotacao", nullable = false, updatable = false)})
	public Set<Ferramenta> getFerramentas() {
		return this.ferramentas;
	}

	public void setFerramentas(Set<Ferramenta> ferramentas) {
		this.ferramentas = ferramentas;
	}

}