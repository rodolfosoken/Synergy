package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Tarefa;
import repository.Tarefas;
import util.FacesMessages;
@Named
@ViewScoped
public class GestaoTarefaBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private Tarefas tarefas;
	
	
	@Inject
	private FacesMessages messages;
	private Tarefa tarefaSelecionada;
	
	private List<Tarefa> todasTarefas;
	
	public void consultar() {
		todasTarefas = tarefas.todas();
	}
	public List<Tarefa> getTodasTarefas() {
		return todasTarefas;
	}
	public Tarefa getTarefaSelecionada() {
		return tarefaSelecionada;
	}
	
	

}
