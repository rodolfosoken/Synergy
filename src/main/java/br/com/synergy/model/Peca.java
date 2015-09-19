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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

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
	private String upc;
	private String fna;
	private Double valor;
	private String responsavel;
	private List<ComponentePeca> componentes = new ArrayList<ComponentePeca>(0);

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

	@NotNull
	@NotBlank
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

	@Column(name = "upc")
	public String getUpc() {
		return this.upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
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
	
	@Column(name="fna")
	public String getFna() {
		return fna;
	}

	public void setFna(String fna) {
		this.fna = fna;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "peca")
	public List<ComponentePeca> getComponentePecas() {
		return this.componentes;
	}

	public void setComponentePecas(List<ComponentePeca> componentes) {
		this.componentes = componentes;
	}

}
