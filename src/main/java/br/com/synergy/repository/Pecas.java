package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.Peca;

public class Pecas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	
	public List<Peca> todas() {
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

	public List<Peca> buscaPorPecaNome(String nome) {
		return em.createQuery("from Peca" + " where partName like :nome",
				Peca.class).setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}

}
