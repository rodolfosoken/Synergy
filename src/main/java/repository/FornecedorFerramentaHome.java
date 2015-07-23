package repository;

// Generated 22/07/2015 20:00:09 by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.FornecedorFerramenta;



/**
 * Home object for domain model class FornecedorFerramenta.
 * 
 * @see model.FornecedorFerramenta
 * @author Hibernate Tools
 */

public class FornecedorFerramentaHome implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager entityManager;

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
