package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.Fornecedor;
import br.com.synergy.model.FornecedorFerramenta;
import br.com.synergy.model.FornecedorMaterial;
import br.com.synergy.model.FornecedorPeca;

public class Fornecedores implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager em;

	public List<Fornecedor> todos(String tipo) {
		return em.createQuery("from Fornecedor" + tipo, Fornecedor.class)
				.getResultList();
	}

	public List<Fornecedor> todos() {
		return em.createQuery("from Fornecedor", Fornecedor.class)
				.getResultList();
	}

	public void guardar (Fornecedor fornecedor) {
		em.merge(fornecedor);
	}

	public void excluir(Fornecedor fornecedor) {
		fornecedor = buscaPorId(fornecedor.getIdfornecedor());
		em.remove(fornecedor);
	}

	public Fornecedor buscaPorCnpj(String cnpj) {
		return em
				.createQuery("from Fornecedor where cnpj = :cnpj",
						Fornecedor.class).setParameter("cnpj", cnpj)
				.getSingleResult();
	}

	public Fornecedor buscaPorId(Long id) {
		return em.find(Fornecedor.class, id);
	}

	public FornecedorMaterial buscaPorIdMaterial(Long id) {
		return em.find(FornecedorMaterial.class, id);
	}

	public List<FornecedorMaterial> buscaPorFornecedorMaterial(String nome) {
		return em
				.createQuery(
						"from FornecedorMaterial" + " where nome like :nome",
						FornecedorMaterial.class)
				.setParameter("nome", "%" + nome.toUpperCase() + "%")
				.getResultList();
	}

	public List<FornecedorFerramenta> buscaPorFornecedorFerramenta(String nome) {
		return em
				.createQuery(
						"from FornecedorFerramenta" + " where nome like :nome",
						FornecedorFerramenta.class)
				.setParameter("nome", "%" + nome.toUpperCase() + "%")
				.getResultList();
	}

	public List<FornecedorPeca> buscaPorFornecedorPeca(String nome) {
		return em
				.createQuery(
						"from FornecedorPeca" + " where nome like :nome",
						FornecedorPeca.class)
				.setParameter("nome", "%" + nome.toUpperCase() + "%")
				.getResultList();
	}

}