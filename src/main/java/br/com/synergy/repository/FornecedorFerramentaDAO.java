package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.primefaces.component.message.Message;

import br.com.synergy.model.FornecedorFerramenta;


public class FornecedorFerramentaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager entityManager;
	
	//@Inject
	private Message mensagem;
	
	public List<FornecedorFerramenta> todos() {
		return entityManager.createQuery("from FornecedorFerramenta", FornecedorFerramenta.class).getResultList();
	}
	public void persist(FornecedorFerramenta transientInstance) {

		try {
			entityManager.persist(transientInstance);

		} catch (RuntimeException re) {
		
			throw re;
		}
	}

	public void remove(FornecedorFerramenta persistentInstance) {

		try {
			entityManager.remove(persistentInstance);
		
		} catch (RuntimeException re) {

			throw re;
		}
	}

	public FornecedorFerramenta merge(FornecedorFerramenta detachedInstance) {

		try {
			FornecedorFerramenta result = entityManager.merge(detachedInstance);

			return result;
		} catch (RuntimeException re) {
	
			throw re;
		}
	}

	public FornecedorFerramenta findById(String id) {
	
		try {
			FornecedorFerramenta instance = entityManager.find(
					FornecedorFerramenta.class, id);
	
			return instance;
		} catch (RuntimeException re) {
		
			throw re;
		}
	}
}
