package br.com.synergy.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.synergy.model.CotacaoMaterial;
import br.com.synergy.repository.CotacoesMateriais;

@Named
@ViewScoped
public class CotacaoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CotacaoMaterial cotacaoMaterial;
	
	@Inject
	private CotacoesMateriais materiais;
	


}
