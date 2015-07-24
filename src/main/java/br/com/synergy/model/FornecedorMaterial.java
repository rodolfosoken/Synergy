package br.com.synergy.model;

// Generated 23/07/2015 04:16:30 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * FornecedorMaterial generated by hbm2java
 */
@Entity
@DiscriminatorValue("MATERIAL")
public class FornecedorMaterial extends Fornecedor implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set<CotacaoMaterial> cotacaoMaterials = new HashSet<CotacaoMaterial>(
			0);

	public FornecedorMaterial() {
	}

	public FornecedorMaterial(String cnpj) {
		this.setCnpj(cnpj);
	}



	@ManyToMany(fetch = FetchType.LAZY)
<<<<<<< HEAD
<<<<<<< HEAD
	@JoinTable(name = "cotacao_material_has_fornecedor", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "fornecedor_idfornecedor", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "cotacao_material_idcotacao", nullable = false, updatable = false) })
=======
	@JoinTable(name = "cotacao_material_has_fornecedor", catalog = "sistema_gestao", joinColumns = {
			@JoinColumn(name = "fornecedor_idfornecedor", nullable = false, updatable = false),
			@JoinColumn(name = "fornecedor_endereco_idendereco", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "cotacao_material_idcotacao", nullable = false, updatable = false) })
>>>>>>> parent of 789e1e2... Bug corrigido, fornecedor centralizado
=======
	@JoinTable(name = "cotacao_material_has_fornecedor", catalog = "sistema_gestao", joinColumns = {
			@JoinColumn(name = "fornecedor_idfornecedor", nullable = false, updatable = false),
			@JoinColumn(name = "fornecedor_endereco_idendereco", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "cotacao_material_idcotacao", nullable = false, updatable = false) })
>>>>>>> parent of 789e1e2... Bug corrigido, fornecedor centralizado
	public Set<CotacaoMaterial> getCotacaoMaterials() {
		return this.cotacaoMaterials;
	}

	public void setCotacaoMaterials(Set<CotacaoMaterial> cotacaoMaterials) {
		this.cotacaoMaterials = cotacaoMaterials;
	}

}
