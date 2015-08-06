package br.com.synergy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("MATERIAL")
public class FornecedorMaterial extends Fornecedor implements
		java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Set<ParticipanteMaterial> participanteMaterials = new HashSet<ParticipanteMaterial>(
			0);

	public FornecedorMaterial() {
	}

	public FornecedorMaterial(String cnpj) {
		this.setCnpj(cnpj);
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fornecedor")
	public Set<ParticipanteMaterial> getParticipanteMaterials() {
		return this.participanteMaterials;
	}

	public void setParticipanteMaterials(
			Set<ParticipanteMaterial> participanteMaterials) {
		this.participanteMaterials = participanteMaterials;
	}

}
