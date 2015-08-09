package br.com.synergy.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "material", catalog = "sistema_gestao")
public class Material implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Long idmaterial;
	private ParticipanteMaterial participanteMaterial;
	private String materialEspc;
	private String material;
	private String desc;
	private Boolean disponibilidade;
	private Double valor;
	private Set<CompraMaterial> compraMaterials = new HashSet<CompraMaterial>(0);
	private Set<Peca> pecas = new HashSet<Peca>(0);

	public Material() {
	}

	public Material(ParticipanteMaterial participanteMaterial,
			String materialEspc) {
		this.participanteMaterial = participanteMaterial;
		this.materialEspc = materialEspc;
	}

	public Material(ParticipanteMaterial participanteMaterial,
			String materialEspc, String material, String desc,
			Boolean disponibilidade, Set<CompraMaterial> compraMaterials,
			Set<Peca> pecas) {
		this.participanteMaterial = participanteMaterial;
		this.materialEspc = materialEspc;
		this.material = material;
		this.desc = desc;
		this.disponibilidade = disponibilidade;
		this.compraMaterials = compraMaterials;
		this.pecas = pecas;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "participante_material_idparticipante", nullable = false)
	public ParticipanteMaterial getParticipanteMaterial() {
		return this.participanteMaterial;
	}

	public void setParticipanteMaterial(
			ParticipanteMaterial participanteMaterial) {
		this.participanteMaterial = participanteMaterial;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "material")
	public Set<CompraMaterial> getCompraMaterials() {
		return this.compraMaterials;
	}

	public void setCompraMaterials(Set<CompraMaterial> compraMaterials) {
		this.compraMaterials = compraMaterials;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "material")
	public Set<Peca> getPecas() {
		return this.pecas;
	}

	public void setPecas(Set<Peca> pecas) {
		this.pecas = pecas;
	}



}
