package br.com.synergy.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.synergy.model.ParticipanteFerramenta;

public class Participantes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public ParticipanteFerramenta buscaPorId(Long id) {
		Query query = (Query) em
				.createQuery("select c from ParticipanteFerramenta c join fetch c.fornecedor where c.id = :id");
		query.setParameter("id", id);

		ParticipanteFerramenta result = null;
		try {
			result = (ParticipanteFerramenta) query.getSingleResult();
		} catch (NoResultException e) {
			// no result found
		}

		return result;
	}

}
