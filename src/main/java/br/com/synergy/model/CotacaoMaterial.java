package br.com.synergy.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "cotacao_material", catalog = "sistema_gestao")
@PrimaryKeyJoinColumn(name="cotacao_idcotacao", referencedColumnName="idcotacao")
public class CotacaoMaterial extends Cotacao implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private CompraMaterial compraMaterial;
	private Material material;
	private List<ParticipanteMaterial> participantesMateriais = new ArrayList<ParticipanteMaterial>(
			0);

	public CotacaoMaterial() {
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "material_idmaterial", nullable = false)
	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "compra_material_idcompra_material")
	public CompraMaterial getCompraMaterial() {
		return this.compraMaterial;
	}

	public void setCompraMaterial(CompraMaterial compraMaterial) {
		this.compraMaterial = compraMaterial;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cotacaoMaterial",cascade = CascadeType.ALL)
	public List<ParticipanteMaterial> getParticipantesMateriais() {
		return this.participantesMateriais;
	}

	public void setParticipantesMateriais(
			List<ParticipanteMaterial> participantesMateriais) {
		this.participantesMateriais = participantesMateriais;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CotacaoMaterial other = (CotacaoMaterial) obj;
		if (this.getIdcotacao() == null) {
			if (other.getIdcotacao() != null)
				return false;
		} else if (!this.getIdcotacao().equals(other.getIdcotacao()))
			return false;
		return true;
	}

}
