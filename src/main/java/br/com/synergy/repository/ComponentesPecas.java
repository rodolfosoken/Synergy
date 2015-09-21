package br.com.synergy.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.ComponentePeca;

public class ComponentesPecas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public ComponentePeca buscaPorId(Long id){
		return em.find(ComponentePeca.class, id);
	}

}
