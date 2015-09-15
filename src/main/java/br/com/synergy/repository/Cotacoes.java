package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.synergy.model.Cotacao;
import br.com.synergy.model.CotacaoFerramenta;
import br.com.synergy.model.CotacaoMaterial;

public class Cotacoes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	
	public List<Cotacao> todas() {
		return em.createQuery("from Cotacao", Cotacao.class).getResultList();
	}
	
	public List<CotacaoFerramenta> todasCotacoesFerramentas(){
		return em.createQuery("from CotacaoFerramenta",CotacaoFerramenta.class).getResultList();
	}
	
	public List<CotacaoMaterial> todasCotacoesMaterial(){
		return em.createQuery("from CotacaoMaterial",CotacaoMaterial.class).getResultList();
	}
	
	public void guardar(Cotacao cotacao){
		em.merge(cotacao);		
	}
	
	public void excluir(Cotacao cotacao){
		cotacao = buscaPorId(cotacao.getIdcotacao());
		em.remove(cotacao);
		em.flush();
	}
	
	
	public CotacaoFerramenta buscaFetchParticipantesCotacaoFerramenta(Long id){
		
		Query query = (Query) em.createQuery("select c from CotacaoFerramenta c join fetch c.participantesFerramentas where c.id = :id");
	    query.setParameter("id", id);
	 
	    CotacaoFerramenta result = null;
	    try {
	        result = (CotacaoFerramenta) query.getSingleResult();
	    } catch (NoResultException e) {
	        // no result found
	    }
		
		return result;
	}

	public CotacaoFerramenta buscaFetchCompraFerramenta(Long id) {
		Query query = (Query) em.createQuery("select c from CotacaoFerramenta c join fetch c.compraFerramenta where c.id = :id");
	    query.setParameter("id", id);
	 
	    CotacaoFerramenta result = null;
	    try {
	        result = (CotacaoFerramenta) query.getSingleResult();
	    } catch (NoResultException e) {
	        System.out.println("DEBUG:nenhuma pep encontrada");
	    }
		
		return result;
	}

	
	public Cotacao buscaPorId(Long id){
		return em.find(Cotacao.class, id);
	}
}
