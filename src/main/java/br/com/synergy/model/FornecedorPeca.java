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
@DiscriminatorValue("PECA")
public class FornecedorPeca extends Fornecedor implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Set<CotacaoPeca> cotacaoPecas = new HashSet<CotacaoPeca>(0);

	public FornecedorPeca() {
	}

	public FornecedorPeca(String cnpj) {
		this.setCnpj(cnpj);
	}
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cotacao_peca_has_fornecedor", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "fornecedor_idfornecedor", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "cotacao_peca_idcotacao", nullable = false, updatable = false) })
	public Set<CotacaoPeca> getCotacaoPecas() {
		return this.cotacaoPecas;
	}

	public void setCotacaoPecas(Set<CotacaoPeca> cotacaoPecas) {
		this.cotacaoPecas = cotacaoPecas;
	}

}
