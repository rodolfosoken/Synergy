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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "pep", catalog = "sistema_gestao")
public class Pep implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private PepId id;
	private Conta conta;
	private String numero;
	private Set<CompraFerramenta> compraFerramentas = new HashSet<CompraFerramenta>(
			0);
	private Set<CompraPeca> compraPecas = new HashSet<CompraPeca>(0);
	private Set<CompraMaterial> compraMaterials = new HashSet<CompraMaterial>(0);

	public Pep() {
	}

	public Pep(PepId id, Conta conta) {
		this.id = id;
		this.conta = conta;
	}

	public Pep(PepId id, Conta conta, String numero,
			Set<CompraFerramenta> compraFerramentas,
			Set<CompraPeca> compraPecas, Set<CompraMaterial> compraMaterials) {
		this.id = id;
		this.conta = conta;
		this.numero = numero;
		this.compraFerramentas = compraFerramentas;
		this.compraPecas = compraPecas;
		this.compraMaterials = compraMaterials;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idpep", column = @Column(name = "idpep", nullable = false)),
			@AttributeOverride(name = "contaIdConta", column = @Column(name = "Conta_idConta", nullable = false)) })
	public PepId getId() {
		return this.id;
	}

	public void setId(PepId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Conta_idConta", nullable = false, insertable = false, updatable = false)
	public Conta getConta() {
		return this.conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Column(name = "numero", length = 45)
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pep")
	public Set<CompraFerramenta> getCompraFerramentas() {
		return this.compraFerramentas;
	}

	public void setCompraFerramentas(Set<CompraFerramenta> compraFerramentas) {
		this.compraFerramentas = compraFerramentas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pep")
	public Set<CompraPeca> getCompraPecas() {
		return this.compraPecas;
	}

	public void setCompraPecas(Set<CompraPeca> compraPecas) {
		this.compraPecas = compraPecas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pep")
	public Set<CompraMaterial> getCompraMaterials() {
		return this.compraMaterials;
	}

	public void setCompraMaterials(Set<CompraMaterial> compraMaterials) {
		this.compraMaterials = compraMaterials;
	}

}
