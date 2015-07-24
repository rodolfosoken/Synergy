package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.FornecedorFerramenta;


public class DAOFornecedorFerramenta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager em;
		
	
	public FornecedorFerramenta porId(Long id){
		return em.find(FornecedorFerramenta.class, id);
	}
	
	public List<FornecedorFerramenta> listarTodos() {
		return em.createQuery("from FornecedorFerramenta", FornecedorFerramenta.class).getResultList();
	}
	
	public FornecedorFerramenta guardar(FornecedorFerramenta fornecedor){
		return em.merge(fornecedor);
	}
	
	public void remover(FornecedorFerramenta fornecedor){
		em.remove(fornecedor);
	}
	
	
}
