package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.Fornecedor;
import br.com.synergy.model.FornecedorMaterial;

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

	public void guardar(Fornecedor fornecedor) {
		em.merge(fornecedor);
	}

	public void excluir(Fornecedor fornecedor) {
		fornecedor = buscaPorId(fornecedor.getIdfornecedor());
		em.remove(fornecedor);
	}

	public Fornecedor buscaPorId(Long id) {
		return em.find(Fornecedor.class, id);
	}
	
	public FornecedorMaterial buscaPorIdMaterial(Long id) {
		return em.find(FornecedorMaterial.class, id);
	}

	public List<Fornecedor> buscaPorNome(String nome) {
		return em.createQuery("from Fornecedor" + " where nome like :nome",
				Fornecedor.class).setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}

}