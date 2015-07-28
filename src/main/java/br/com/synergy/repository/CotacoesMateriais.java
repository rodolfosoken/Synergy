package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.CotacaoMaterial;

public class CotacoesMateriais implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	
	public List<CotacaoMaterial> todas() {
		return em.createQuery("from CotacaoMaterial", CotacaoMaterial.class).getResultList();
	}
	
	public void guardar(CotacaoMaterial cotacao){
		em.merge(cotacao);		
	}
	
	public void excluir(CotacaoMaterial cotacao){
		cotacao = buscaPorId(cotacao.getIdcotacao());
		em.remove(cotacao);
	}
	
	public CotacaoMaterial buscaPorId(Integer id){
		return em.find(CotacaoMaterial.class, id);
	}

}
