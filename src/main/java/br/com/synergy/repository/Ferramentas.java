package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.Ferramenta;
import br.com.synergy.model.ParticipanteFerramenta;

public class Ferramentas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public List<Ferramenta> todas() {
		return em.createQuery("from Ferramenta", Ferramenta.class).getResultList();
	}

	public void guardar(Ferramenta ferramenta) {
		em.merge(ferramenta);
	}

	public void excluir(Ferramenta ferramenta) {
		ferramenta = buscaPorId(ferramenta.getIdferramenta());
		em.remove(ferramenta);
		em.flush();
	}

	public Ferramenta buscaPorId(Long id) {
		return em.find(Ferramenta.class, id);
	}
	

	public List<Ferramenta> buscaPorFerramentaNome(String nome) {
		return em.createQuery("from Ferramenta" + " where nome like :nome",
				Ferramenta.class).setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}
	
	public List<ParticipanteFerramenta> buscaPorParticipante(String nome) {
		return em.createQuery("from ParticipanteFerramenta" + " where fornecedor_idfornecedor like :nome",
				ParticipanteFerramenta.class).setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}

}
