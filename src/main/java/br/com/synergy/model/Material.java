package br.com.synergy.model;

// Generated 23/07/2015 04:16:30 by Hibernate Tools 4.3.1

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

/**
 * Material generated by hbm2java
 */
@Entity
@Table(name = "material", catalog = "sistema_gestao")
public class Material implements java.io.Serializable {

	private MaterialId id;
	private CotacaoMaterial cotacaoMaterial;
	private String materialEspc;
	private String material;
	private String desc;
	private Set<Peca> pecas = new HashSet<Peca>(0);

	public Material() {
	}

	public Material(MaterialId id, CotacaoMaterial cotacaoMaterial,
			String materialEspc) {
		this.id = id;
		this.cotacaoMaterial = cotacaoMaterial;
		this.materialEspc = materialEspc;
	}

	public Material(MaterialId id, CotacaoMaterial cotacaoMaterial,
			String materialEspc, String material, String desc, Set<Peca> pecas) {
		this.id = id;
		this.cotacaoMaterial = cotacaoMaterial;
		this.materialEspc = materialEspc;
		this.material = material;
		this.desc = desc;
		this.pecas = pecas;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idmaterial", column = @Column(name = "idmaterial", nullable = false)),
			@AttributeOverride(name = "cotacaoMaterialIdcotacao", column = @Column(name = "cotacao_material_idcotacao", nullable = false)) })
	public MaterialId getId() {
		return this.id;
	}

	public void setId(MaterialId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cotacao_material_idcotacao", nullable = false, insertable = false, updatable = false)
	public CotacaoMaterial getCotacaoMaterial() {
		return this.cotacaoMaterial;
	}

	public void setCotacaoMaterial(CotacaoMaterial cotacaoMaterial) {
		this.cotacaoMaterial = cotacaoMaterial;
	}

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

	@Column(name = "desc")
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "material")
	public Set<Peca> getPecas() {
		return this.pecas;
	}

	public void setPecas(Set<Peca> pecas) {
		this.pecas = pecas;
	}

}