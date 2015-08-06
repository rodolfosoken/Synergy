package br.com.synergy.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.synergy.model.CotacaoMaterial;
import br.com.synergy.repository.CotacoesMateriais;
import br.com.synergy.util.CDIServiceLocator;

@FacesConverter(forClass = CotacaoMaterial.class)
public class CotacaoMaterialConverter implements Converter {

	private CotacoesMateriais cotacoes;
	
	public CotacaoMaterialConverter() {
	cotacoes = CDIServiceLocator.getBean(CotacoesMateriais.class);
	
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		CotacaoMaterial convertido = null;
		
		if (arg2 != null) {
			Long id = new Long(arg2);
			convertido = cotacoes.buscaPorId(id);
		}
		
		return convertido;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 != null){
			return String.valueOf(((CotacaoMaterial) arg2).getIdcotacao());
		}
		return null;
	}
	
	

}
