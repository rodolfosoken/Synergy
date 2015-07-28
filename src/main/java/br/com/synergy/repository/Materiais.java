package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.CotacaoMaterial;
import br.com.synergy.model.Material;

public class Materiais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;

	public List<Material> todos() {
		return em.createQuery("from Material", Material.class).getResultList();
	}

	public void guardar(Material material) {
		em.merge(material);
	}

	public void excluir(Material material) {
		material = buscaPorId(material.getIdmaterial());
		em.remove(material);
	}

	public Material buscaPorId(Long id) {
		return em.find(Material.class, id);
	}
	

	public List<Material> buscaPorMaterialEspc(String nome) {
		return em.createQuery("from Material" + " where materialEspc like :nome",
				Material.class).setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}
	
	public List<CotacaoMaterial> buscaPorCotacao(String nome) {
		return em.createQuery("from CotacaoMaterial" + " where descricao like :nome",
				CotacaoMaterial.class).setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}

}
