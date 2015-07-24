package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.primefaces.component.message.Message;

import br.com.synergy.model.Fornecedor;


public class FornecedorFerramentaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager entityManager;
	
	//@Inject
	private Message mensagem;
	
	public List<Fornecedor> todos() {
		return entityManager.createQuery("from Fornecedor", Fornecedor.class).getResultList();
	}
	public void persist(Fornecedor transientInstance) {

		try {
			entityManager.persist(transientInstance);

		} catch (RuntimeException re) {
		
			throw re;
		}
	}

	public void remove(Fornecedor persistentInstance) {

		try {
			entityManager.remove(persistentInstance);
		
		} catch (RuntimeException re) {

			throw re;
		}
	}

	public Fornecedor merge(Fornecedor detachedInstance) {

		try {
			Fornecedor result = entityManager.merge(detachedInstance);

			return result;
		} catch (RuntimeException re) {
	
			throw re;
		}
	}

	public Fornecedor findById(String id) {
	
		try {
			Fornecedor instance = entityManager.find(
					Fornecedor.class, id);
	
			return instance;
		} catch (RuntimeException re) {
		
			throw re;
		}
	}
}
