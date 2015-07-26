package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.primefaces.component.message.Message;

import br.com.synergy.model.FornecedorFerramenta;


public class FornecedorFerramentaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager entityManager;
	
	//@Inject
	@SuppressWarnings("unused")
	private Message mensagem;
	
	public List<FornecedorFerramenta> todos() {
		return entityManager.createQuery("from FornecedorFerramenta", FornecedorFerramenta.class).getResultList();
	}
	
	public void guardar(FornecedorFerramenta fornecedor){
		entityManager.persist(fornecedor);		
	}


}