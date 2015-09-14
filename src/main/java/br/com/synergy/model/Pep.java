package br.com.synergy.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "pep", catalog = "sistema_gestao")
public class Pep implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long id;
	private Conta conta;
	private String numero;
	private Double valor;
	private String descricao;
	private List<CompraFerramenta> compraFerramentas = new ArrayList<CompraFerramenta>(
			0);
	private List<CompraMaterial> compraMaterials = new ArrayList<CompraMaterial>(0);

	public Pep() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idpep", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Conta_idConta")
	public Conta getConta() {
		return this.conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	@NotNull
	@NotBlank
	@Column(name = "numero", length = 45)
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pep")
	public List<CompraFerramenta> getCompraFerramentas() {
		return this.compraFerramentas;
	}

	public void setCompraFerramentas(List<CompraFerramenta> compraFerramentas) {
		this.compraFerramentas = compraFerramentas;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pep")
	public List<CompraMaterial> getCompraMaterials() {
		return this.compraMaterials;
	}

	public void setCompraMaterials(List<CompraMaterial> compraMaterials) {
		this.compraMaterials = compraMaterials;
	}
	
	@NotNull
	@Column(name="valor")
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	@NotNull
	@NotBlank
	@Column(name="descricao")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
