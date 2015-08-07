package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.Cotacao;

public class Cotacoes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	
	public List<Cotacao> todas() {
		return em.createQuery("from Cotacao", Cotacao.class).getResultList();
	}
	
	public void guardar(Cotacao cotacao){
		em.merge(cotacao);		
	}
	
	public void excluir(Cotacao cotacao){
		cotacao = buscaPorId(cotacao.getIdcotacao());
		em.remove(cotacao);
	}
	
	public Cotacao buscaPorId(Long id){
		return em.find(Cotacao.class, id);
	}

}
