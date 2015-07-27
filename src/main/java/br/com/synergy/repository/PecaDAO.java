package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.Peca;

public class PecaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	
	public List<Peca> todos(String tipo) {
		return em.createQuery("from Peca"+tipo, Peca.class).getResultList();
	}
	
	public List<Peca> todos() {
		return em.createQuery("from Peca", Peca.class).getResultList();
	}
	
	public void guardar(Peca peca){
		em.merge(peca);		
	}
	
	public void excluir(Peca peca){
		peca = buscaPorId(peca.getIdpeca());
		em.remove(peca);
	}
	
	public Peca buscaPorId(Long id){
		return em.find(Peca.class, id);
	}

}
