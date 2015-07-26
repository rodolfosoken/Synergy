package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.Fornecedor;


public class FornecedorFerramentaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager em;
	
	
	public List<Fornecedor> todos() {
		return em.createQuery("from Fornecedor", Fornecedor.class).getResultList();
	}
	
	public void guardar(Fornecedor fornecedor){
		em.merge(fornecedor);		
	}
	
	public void excluir(Fornecedor fornecedor){
		fornecedor = buscaPorId(fornecedor.getIdfornecedor());
		em.remove(fornecedor);
	}
	
	public Fornecedor buscaPorId(Long id){
		return em.find(Fornecedor.class, id);
	}


}