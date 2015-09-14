package br.com.synergy.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.synergy.model.Conta;


public class Contas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	
	public List<Conta> todasContas(){
		return em.createQuery("from Conta", Conta.class).getResultList();
	}
	
	public void salvar(Conta conta){
		em.merge(conta);
	}

}
