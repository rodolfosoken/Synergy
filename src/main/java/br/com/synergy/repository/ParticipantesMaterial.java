package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.ParticipanteMaterial;

public class ParticipantesMaterial implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	
	public List<ParticipanteMaterial> todos(){
		return em.createQuery("from ParticipanteMaterial", ParticipanteMaterial.class).getResultList();
	}
	
	public void guardar(ParticipanteMaterial participante){
		em.merge(participante);
	}
	
	public void excluir(ParticipanteMaterial participante) {
		participante = buscaPorId(participante.getIdparticipante());
		em.remove(participante);
	}

	public ParticipanteMaterial buscaPorId(Long id) {
		return em.find(ParticipanteMaterial.class, id);
	}
	

}
