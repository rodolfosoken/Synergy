package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.synergy.model.Conjunto;

public class Conjuntos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public List<Conjunto> todos() {
		return em.createQuery("from Conjunto", Conjunto.class).getResultList();
	}

	public void guardar(Conjunto conjunto) {
		em.merge(conjunto);
	}

	public void excluir(Conjunto conjunto) {
		conjunto = buscaPorId(conjunto.getIdconjunto());
		em.remove(conjunto);
	}

	public Conjunto buscaPorId(Long id) {
		return em.find(Conjunto.class, id);
	}

	public Conjunto buscaFetchComponentesFerramentas(Long id) {
		Query query = (Query) em
				.createQuery("select c from Conjunto c join fetch c.componentesFerramentas where c.id = :id");
		query.setParameter("id", id);

		Conjunto result = null;
		try {
			result = (Conjunto) query.getSingleResult();
		} catch (NoResultException e) {
			// no result found
		}

		return result;

	}

	public Conjunto buscaFetchComponentesPecas(Long id) {
		Query query = (Query) em
				.createQuery("select c from Conjunto c join fetch c.componentesPecas where c.id = :id");
		query.setParameter("id", id);

		Conjunto result = null;
		try {
			result = (Conjunto) query.getSingleResult();
		} catch (NoResultException e) {
			// no result found
		}

		return result;
	}

	public Conjunto buscaFetchMontagens(Long id) {
		Query query = (Query) em.createQuery("select c from Conjunto c join fetch c.montagens where c.id = :id");
	    query.setParameter("id", id);
	 
	    Conjunto result = null;
	    try {
	        result = (Conjunto) query.getSingleResult();
	    } catch (NoResultException e) {
	        // no result found
	    }
		
		return result;
	}

}
