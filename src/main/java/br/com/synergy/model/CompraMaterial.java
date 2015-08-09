package br.com.synergy.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "compra_material", catalog = "sistema_gestao")
public class CompraMaterial implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer idfornecimentoMaterial;
	private Pep pep;
	private Material material;
	private Boolean okPrazo;
	private Boolean okEspec;
	private Boolean okVisita;
	private Boolean okAssist;
	private Date dataAquisicao;
	private Double preco;

	public CompraMaterial() {
	}

	public CompraMaterial(Pep pep, Material material) {
		this.pep = pep;
		this.material = material;
	}

	public CompraMaterial(Pep pep, Material material, Boolean okPrazo,
			Boolean okEspec, Boolean okVisita, Boolean okAssist,
			Date dataAquisicao, Double preco) {
		this.pep = pep;
		this.material = material;
		this.okPrazo = okPrazo;
		this.okEspec = okEspec;
		this.okVisita = okVisita;
		this.okAssist = okAssist;
		this.dataAquisicao = dataAquisicao;
		this.preco = preco;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idfornecimento_material", unique = true, nullable = false)
	public Integer getIdfornecimentoMaterial() {
		return this.idfornecimentoMaterial;
	}

	public void setIdfornecimentoMaterial(Integer idfornecimentoMaterial) {
		this.idfornecimentoMaterial = idfornecimentoMaterial;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "pep_idpep", referencedColumnName = "idpep", nullable = false),
			@JoinColumn(name = "pep_Conta_idConta", referencedColumnName = "Conta_idConta", nullable = false) })
	public Pep getPep() {
		return this.pep;
	}

	public void setPep(Pep pep) {
		this.pep = pep;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "material_idmaterial", nullable = false)
	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Column(name = "ok_prazo")
	public Boolean getOkPrazo() {
		return this.okPrazo;
	}

	public void setOkPrazo(Boolean okPrazo) {
		this.okPrazo = okPrazo;
	}

	@Column(name = "ok_espec")
	public Boolean getOkEspec() {
		return this.okEspec;
	}

	public void setOkEspec(Boolean okEspec) {
		this.okEspec = okEspec;
	}

	@Column(name = "ok_visita")
	public Boolean getOkVisita() {
		return this.okVisita;
	}

	public void setOkVisita(Boolean okVisita) {
		this.okVisita = okVisita;
	}

	@Column(name = "ok_assist")
	public Boolean getOkAssist() {
		return this.okAssist;
	}

	public void setOkAssist(Boolean okAssist) {
		this.okAssist = okAssist;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_aquisicao", length = 10)
	public Date getDataAquisicao() {
		return this.dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	@Column(name = "preco", precision = 22, scale = 0)
	public Double getPreco() {
		return this.preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
