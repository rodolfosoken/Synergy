package br.com.synergy.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.Endereco;

public class EnderecoDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager entityManager;
	
	public void persist(Endereco transientInstance) {

		try {
			entityManager.persist(transientInstance);

		} catch (RuntimeException re) {
		
			throw re;
		}
	}

}
