package br.com.synergy.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

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
	private Boolean disponibilidade;
	private Double valor;
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
	public Boolean getDisponibilidade() {
		return this.disponibilidade;
	}

	public void setDisponibilidade(Boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	
	@Column(name="valor")
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	@OneToOne(mappedBy="material")
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
