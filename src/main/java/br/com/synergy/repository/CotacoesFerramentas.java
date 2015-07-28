package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.CotacaoFerramenta;

public class CotacoesFerramentas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	
	public List<CotacaoFerramenta> todas() {
		return em.createQuery("from CotacaoFerramenta", CotacaoFerramenta.class).getResultList();
	}
	
	public void guardar(CotacaoFerramenta cotacao){
		em.merge(cotacao);		
	}
	
	public void excluir(CotacaoFerramenta cotacao){
		cotacao = buscaPorId(cotacao.getIdcotacao());
		em.remove(cotacao);
	}
	
	public CotacaoFerramenta buscaPorId(Long id){
		return em.find(CotacaoFerramenta.class, id);
	}

}
