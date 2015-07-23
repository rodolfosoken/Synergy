package model;

// Generated 23/07/2015 04:16:30 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PecaId generated by hbm2java
 */
@Embeddable
public class PecaId implements java.io.Serializable {

	private long idpeca;
	private long materialIdmaterial;
	private int materialCotacaoMaterialIdcotacao;

	public PecaId() {
	}

	public PecaId(long idpeca, long materialIdmaterial,
			int materialCotacaoMaterialIdcotacao) {
		this.idpeca = idpeca;
		this.materialIdmaterial = materialIdmaterial;
		this.materialCotacaoMaterialIdcotacao = materialCotacaoMaterialIdcotacao;
	}

	@Column(name = "idpeca", nullable = false)
	public long getIdpeca() {
		return this.idpeca;
	}

	public void setIdpeca(long idpeca) {
		this.idpeca = idpeca;
	}

	@Column(name = "material_idmaterial", nullable = false)
	public long getMaterialIdmaterial() {
		return this.materialIdmaterial;
	}

	public void setMaterialIdmaterial(long materialIdmaterial) {
		this.materialIdmaterial = materialIdmaterial;
	}

	@Column(name = "material_cotacao_material_idcotacao", nullable = false)
	public int getMaterialCotacaoMaterialIdcotacao() {
		return this.materialCotacaoMaterialIdcotacao;
	}

	public void setMaterialCotacaoMaterialIdcotacao(
			int materialCotacaoMaterialIdcotacao) {
		this.materialCotacaoMaterialIdcotacao = materialCotacaoMaterialIdcotacao;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PecaId))
			return false;
		PecaId castOther = (PecaId) other;

		return (this.getIdpeca() == castOther.getIdpeca())
				&& (this.getMaterialIdmaterial() == castOther
						.getMaterialIdmaterial())
				&& (this.getMaterialCotacaoMaterialIdcotacao() == castOther
						.getMaterialCotacaoMaterialIdcotacao());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getIdpeca();
		result = 37 * result + (int) this.getMaterialIdmaterial();
		result = 37 * result + this.getMaterialCotacaoMaterialIdcotacao();
		return result;
	}

}
