package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.synergy.model.Usuario;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public Usuario buscaPorId(Long id) {
		return this.em.find(Usuario.class, id);

	}

	public Usuario buscaPorEmail(String email) {
		Usuario usuario = null;

		try {
			usuario = this.em.createQuery("from Usuario where lower(email) = :email", Usuario.class)
					.setParameter("email", email.toLowerCase()).getSingleResult();} catch (NoResultException e) {
			// nenhum email encontrado
		}

		return usuario;

	}
	
	public List<Usuario> buscaPorNome(String nome){
		return null;
	}

	public List<Usuario> getTodos(){
		return em.createQuery("from Usuario", Usuario.class).getResultList();
	}
}
