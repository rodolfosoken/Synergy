package repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.Tarefa;

public class Tarefas implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Tarefa> todas() {
		return manager.createQuery("from Tarefa", Tarefa.class).getResultList();
	}

}
