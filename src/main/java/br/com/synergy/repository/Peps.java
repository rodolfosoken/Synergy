package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.Pep;

public class Peps implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public Pep buscaPorId(Long id) {
		return em.find(Pep.class, id);
	}

	public List<Pep> buscarPorNumero(String numero) {
		return em.createQuery("from Pep where numero like :num", Pep.class)
				.setParameter("num", "%" + numero.toUpperCase() + "%")
				.getResultList();
	}

	public List<Pep> todasPeps() {
		return em.createQuery("from Pep", Pep.class).getResultList();
	}

}
