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
@DiscriminatorValue("FERRAMENTA")
public class FornecedorFerramenta extends Fornecedor implements java.io.Serializable {


	
	private static final long serialVersionUID = 1L;
	private Set<CotacaoFerramenta> cotacaoFerramentas = new HashSet<CotacaoFerramenta>(0);

	public FornecedorFerramenta() {

	}

	public FornecedorFerramenta(String cnpj) {
		this.setCnpj(cnpj);
	}


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cotacao_ferramenta_has_fornecedor", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "fornecedor_idfornecedor", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "cotacao_ferramenta_idcotacao", nullable = false, updatable = false) })
	public Set<CotacaoFerramenta> getCotacaoFerramentas() {
		return this.cotacaoFerramentas;
	}

	public void setCotacaoFerramentas(Set<CotacaoFerramenta> cotacaoFerramentas) {
		this.cotacaoFerramentas = cotacaoFerramentas;
	}

}
