package model;

// Generated 23/07/2015 04:16:30 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MaterialId generated by hbm2java
 */
@Embeddable
public class MaterialId implements java.io.Serializable {

	private long idmaterial;
	private int cotacaoMaterialIdcotacao;

	public MaterialId() {
	}

	public MaterialId(long idmaterial, int cotacaoMaterialIdcotacao) {
		this.idmaterial = idmaterial;
		this.cotacaoMaterialIdcotacao = cotacaoMaterialIdcotacao;
	}

	@Column(name = "idmaterial", nullable = false)
	public long getIdmaterial() {
		return this.idmaterial;
	}

	public void setIdmaterial(long idmaterial) {
		this.idmaterial = idmaterial;
	}

	@Column(name = "cotacao_material_idcotacao", nullable = false)
	public int getCotacaoMaterialIdcotacao() {
		return this.cotacaoMaterialIdcotacao;
	}

	public void setCotacaoMaterialIdcotacao(int cotacaoMaterialIdcotacao) {
		this.cotacaoMaterialIdcotacao = cotacaoMaterialIdcotacao;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MaterialId))
			return false;
		MaterialId castOther = (MaterialId) other;

		return (this.getIdmaterial() == castOther.getIdmaterial())
				&& (this.getCotacaoMaterialIdcotacao() == castOther
						.getCotacaoMaterialIdcotacao());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getIdmaterial();
		result = 37 * result + this.getCotacaoMaterialIdcotacao();
		return result;
	}

}
