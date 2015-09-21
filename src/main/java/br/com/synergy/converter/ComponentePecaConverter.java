package br.com.synergy.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.synergy.model.ComponentePeca;
import br.com.synergy.repository.ComponentesPecas;
import br.com.synergy.util.CDIServiceLocator;

@FacesConverter("componentePecaConverter")
public class ComponentePecaConverter implements Converter {

	private ComponentesPecas componentes;
	
	public ComponentePecaConverter() {
	componentes = CDIServiceLocator.getBean(ComponentesPecas.class);
	
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		ComponentePeca convertido = null;
		
		if (arg2 != null) {
			Long id = new Long(arg2);
			convertido = (ComponentePeca) componentes.buscaPorId(id);
		}
		
		return convertido;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 != null){
			return String.valueOf(((ComponentePeca) arg2).getIdcomponentePeca());
		}
		return null;
	}
	
	

}
