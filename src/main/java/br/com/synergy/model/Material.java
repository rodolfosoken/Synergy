package br.com.synergy.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "material", catalog = "sistema_gestao")
public class Material implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long idmaterial;
	private String materialEspc;
	private String material;
	private String desc;
	private Boolean disponivel;
	private Double valor;
	private String kardex;
	private String qk;
	private String cor;
	private String textura;
	private Double contracao;
	private Double matl_recup;
	private Double espessura;
	private Double erro_espessura;
	private CotacaoMaterial cotacao;
	private List<Peca> pecas = new ArrayList<Peca>(0);

	public Material() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idmaterial", unique = true, nullable = false)
	public Long getIdmaterial() {
		return this.idmaterial;
	}

	public void setIdmaterial(Long idmaterial) {
		this.idmaterial = idmaterial;
	}
	
	@NotBlank
	@NotNull
	@Column(name = "material_espc", nullable = false)
	public String getMaterialEspc() {
		return this.materialEspc;
	}

	public void setMaterialEspc(String materialEspc) {
		this.materialEspc = materialEspc;
	}

	@Column(name = "material")
	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Column(name = "descricao")
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "disponibilidade")
	public Boolean getDisponivel() {
		return this.disponivel;
	}

	public void setDisponivel(Boolean disponibilidade) {
		this.disponivel = disponibilidade;
	}
		
	@Column(name="valor")
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	@Column(name="kardex")	
	public String getKardex() {
		return kardex;
	}

	public void setKardex(String kardex) {
		this.kardex = kardex;
	}
	
	@Column(name="qk")
	public String getQk() {
		return qk;
	}

	public void setQk(String qk) {
		this.qk = qk;
	}
	
	@Column(name="cor")
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	@Column(name="textura")
	public String getTextura() {
		return textura;
	}

	public void setTextura(String textura) {
		this.textura = textura;
	}
	
	@Column(name="contracao")
	public Double getContracao() {
		return contracao;
	}

	public void setContracao(Double contracao) {
		this.contracao = contracao;
	}
	
	@Column(name="matl_recup")
	public Double getMatl_recup() {
		return matl_recup;
	}
	
	public void setMatl_recup(Double matl_recup) {
		this.matl_recup = matl_recup;
	}

	@Column(name="espessura")
	public Double getEspessura() {
		return espessura;
	}

	public void setEspessura(Double espessura) {
		this.espessura = espessura;
	}

	@Column(name="erro_espessura")
	public Double getErro_espessura() {
		return erro_espessura;
	}

	public void setErro_espessura(Double erro_espessura) {
		this.erro_espessura = erro_espessura;
	}

	@OneToOne(fetch=FetchType.LAZY , mappedBy="material",cascade=CascadeType.ALL,orphanRemoval=true)
	public CotacaoMaterial getCotacao() {
		return cotacao;
	}

	public void setCotacao(CotacaoMaterial cotacao) {
		this.cotacao = cotacao;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "material")
	public List<Peca> getPecas() {
		return this.pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}



}
