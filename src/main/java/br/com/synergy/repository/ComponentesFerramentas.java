package br.com.synergy.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.ComponenteFerramenta;

public class ComponentesFerramentas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public ComponenteFerramenta buscaPorId(Long id){
		return em.find(ComponenteFerramenta.class, id);
	}

}
