package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.Conjunto;

public class Conjuntos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	
	public List<Conjunto> todos() {
		return em.createQuery("from Conjunto", Conjunto.class).getResultList();
	}
	
	public void guardar(Conjunto conjunto){
		em.merge(conjunto);		
	}
	
	public void excluir(Conjunto conjunto){
		conjunto = buscaPorId(conjunto.getIdconjunto());
		em.remove(conjunto);
	}
	
	public Conjunto buscaPorId(Long id){
		return em.find(Conjunto.class, id);
	}

}
