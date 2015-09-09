package br.com.synergy.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "peca", catalog = "sistema_gestao")
public class Peca implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long idpeca;
	private Fornecedor fornecedor;
 	private Material material;
	private String pn;
	private String partName;
	private String descricao;
	private String upcFna;
	private Double valor;
	private String responsavel;
	private List<Conjunto> conjuntos = new ArrayList<Conjunto>();
	private List<Montagem> montagems = new ArrayList<Montagem>(0);

	public Peca() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idpeca", unique = true, nullable = false)
	public Long getIdpeca() {
		return this.idpeca;
	}

	public void setIdpeca(Long idpeca) {
		this.idpeca = idpeca;
	}
	
	@OneToOne
	@JoinColumn(name = "fornecedor_idfornecedor", nullable = false)
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "material_idmaterial", nullable = false)
	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Column(name = "pn")
	public String getPn() {
		return this.pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	@Column(name = "part_name")
	public String getPartName() {
		return this.partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	@Column(name = "descricao")
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "upc_fna")
	public String getUpcFna() {
		return this.upcFna;
	}

	public void setUpcFna(String upcFna) {
		this.upcFna = upcFna;
	}
	
	@Column(name="valor")
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	@Column(name="responsavel")
	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "conjunto_has_peca", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "peca_idpeca", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "conjunto_idconjunto", nullable = false, updatable = false) })
	public List<Conjunto> getConjuntos() {
		return conjuntos;
	}

	public void setConjuntos(List<Conjunto> conjuntos) {
		this.conjuntos = conjuntos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "peca")
	public List<Montagem> getMontagems() {
		return this.montagems;
	}

	public void setMontagems(List<Montagem> montagems) {
		this.montagems = montagems;
	}

}
