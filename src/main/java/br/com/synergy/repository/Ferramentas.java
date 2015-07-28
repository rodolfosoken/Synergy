package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.CotacaoFerramenta;
import br.com.synergy.model.Ferramenta;

public class Ferramentas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public List<Ferramenta> todas() {
		return em.createQuery("from Ferramenta", Ferramenta.class).getResultList();
	}

	public void guardar(Ferramenta material) {
		em.merge(material);
	}

	public void excluir(Ferramenta material) {
		material = buscaPorId(material.getIdferramenta());
		em.remove(material);
	}

	public Ferramenta buscaPorId(Long id) {
		return em.find(Ferramenta.class, id);
	}
	

	public List<Ferramenta> buscaPorFerramentaEspc(String nome) {
		return em.createQuery("from Ferramenta" + " where materialEspc like :nome",
				Ferramenta.class).setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}
	
	public List<CotacaoFerramenta> buscaPorCotacao(String nome) {
		return em.createQuery("from CotacaoFerramenta" + " where descricao like :nome",
				CotacaoFerramenta.class).setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}

}
