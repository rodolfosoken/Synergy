package br.com.synergy.service;

import br.com.synergy.util.Transacional;

public interface CadastroService <T>{
	
	@Transacional
	public void salvar(T t)throws Exception;
	
	@Transacional
	public void excluir(T t)throws Exception;

}
