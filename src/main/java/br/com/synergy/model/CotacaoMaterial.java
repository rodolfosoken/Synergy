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


@Entity
@Table(name = "cotacao_material", catalog = "sistema_gestao")
public class CotacaoMaterial implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer idcotacao;
	private String responsavel;
	private String descricao;
	private Date data;
	private Set<FornecimentoMaterial> fornecimentoMaterials = new HashSet<FornecimentoMaterial>(
			0);
	private Set<Fornecedor> fornecedors = new HashSet<Fornecedor>(0);
	private Set<Material> materials = new HashSet<Material>(0);

	public CotacaoMaterial() {
	}

	public CotacaoMaterial(String responsavel, Date data,
			Set<FornecimentoMaterial> fornecimentoMaterials,
			Set<Fornecedor> fornecedors, Set<Material> materials) {
		this.responsavel = responsavel;
		this.data = data;
		this.fornecimentoMaterials = fornecimentoMaterials;
		this.fornecedors = fornecedors;
		this.materials = materials;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idcotacao", unique = true, nullable = false)
	public Integer getIdcotacao() {
		return this.idcotacao;
	}

	public void setIdcotacao(Integer idcotacao) {
		this.idcotacao = idcotacao;
	}

	@Column(name = "responsavel")
	public String getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data", length = 10)
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	@Column(name = "descricao")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cotacaoMaterial")
	public Set<FornecimentoMaterial> getFornecimentoMaterials() {
		return this.fornecimentoMaterials;
	}

	public void setFornecimentoMaterials(
			Set<FornecimentoMaterial> fornecimentoMaterials) {
		this.fornecimentoMaterials = fornecimentoMaterials;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cotacao_material_has_fornecedor", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "cotacao_material_idcotacao", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "fornecedor_idfornecedor", nullable = false, updatable = false) })
	public Set<Fornecedor> getFornecedors() {
		return this.fornecedors;
	}

	public void setFornecedors(Set<Fornecedor> fornecedors) {
		this.fornecedors = fornecedors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cotacaoMaterial")
	public Set<Material> getMaterials() {
		return this.materials;
	}

	public void setMaterials(Set<Material> materials) {
		this.materials = materials;
	}
		

}
