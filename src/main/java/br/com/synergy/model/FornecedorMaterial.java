package br.com.synergy.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
@DiscriminatorValue("MATERIAL")
public class FornecedorMaterial extends Fornecedor implements java.io.Serializable {

	

	private static final long serialVersionUID = 1L;
	private Set<CotacaoMaterial> cotacaoMaterials = new HashSet<CotacaoMaterial>(
			0);

	public FornecedorMaterial() {
	}

	public FornecedorMaterial(String cnpj) {
		this.setCnpj(cnpj);
	}


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cotacao_material_has_fornecedor", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "fornecedor_idfornecedor", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "cotacao_material_idcotacao", nullable = false, updatable = false) })
	public Set<CotacaoMaterial> getCotacaoMaterials() {
		return this.cotacaoMaterials;
	}

	public void setCotacaoMaterials(Set<CotacaoMaterial> cotacaoMaterials) {
		this.cotacaoMaterials = cotacaoMaterials;
	}

}
