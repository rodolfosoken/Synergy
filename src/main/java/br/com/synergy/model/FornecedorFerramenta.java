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
 * FornecedorFerramenta generated by hbm2java
 */
@Entity
@DiscriminatorValue("FERRAMENTA")
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
public class FornecedorFerramenta extends Fornecedor implements java.io.Serializable {
=======
public class FornecedorFerramenta extends Fornecedor implements
		java.io.Serializable {
>>>>>>> parent of 789e1e2... Bug corrigido, fornecedor centralizado
=======
public class FornecedorFerramenta extends Fornecedor implements
		java.io.Serializable {
>>>>>>> parent of 789e1e2... Bug corrigido, fornecedor centralizado
=======
public class FornecedorFerramenta extends Fornecedor implements
		java.io.Serializable {
>>>>>>> parent of 789e1e2... Bug corrigido, fornecedor centralizado

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	private Set<CotacaoFerramenta> cotacaoFerramentas = new HashSet<CotacaoFerramenta>(
			0);
=======
	private Set<CotacaoFerramenta> cotacaoFerramentas = new HashSet<CotacaoFerramenta>(0);
>>>>>>> parent of 789e1e2... Bug corrigido, fornecedor centralizado
=======
	private Set<CotacaoFerramenta> cotacaoFerramentas = new HashSet<CotacaoFerramenta>(0);
>>>>>>> parent of 789e1e2... Bug corrigido, fornecedor centralizado
=======
	private Set<CotacaoFerramenta> cotacaoFerramentas = new HashSet<CotacaoFerramenta>(0);
>>>>>>> parent of 789e1e2... Bug corrigido, fornecedor centralizado

	public FornecedorFerramenta() {
	}

	public FornecedorFerramenta(String cnpj) {
		this.setCnpj(cnpj);
	}

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cotacao_ferramenta_has_fornecedor", catalog = "sistema_gestao", joinColumns = { @JoinColumn(name = "fornecedor_idfornecedor", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "cotacao_ferramenta_idcotacao", nullable = false, updatable = false) })
=======
=======
>>>>>>> parent of 789e1e2... Bug corrigido, fornecedor centralizado
=======
>>>>>>> parent of 789e1e2... Bug corrigido, fornecedor centralizado
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "cotacao_ferramenta_has_fornecedor", catalog = "sistema_gestao", joinColumns = {
			@JoinColumn(name = "fornecedor_idfornecedor", nullable = false, updatable = false),
			@JoinColumn(name = "fornecedor_endereco_idendereco", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "cotacao_ferramenta_idcotacao", nullable = false, updatable = false) })
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 789e1e2... Bug corrigido, fornecedor centralizado
=======
>>>>>>> parent of 789e1e2... Bug corrigido, fornecedor centralizado
=======
>>>>>>> parent of 789e1e2... Bug corrigido, fornecedor centralizado
	public Set<CotacaoFerramenta> getCotacaoFerramentas() {
		return this.cotacaoFerramentas;
	}

	public void setCotacaoFerramentas(Set<CotacaoFerramenta> cotacaoFerramentas) {
		this.cotacaoFerramentas = cotacaoFerramentas;
	}

}
