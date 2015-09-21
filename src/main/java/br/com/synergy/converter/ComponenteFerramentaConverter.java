package br.com.synergy.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.synergy.model.ComponenteFerramenta;
import br.com.synergy.repository.ComponentesFerramentas;
import br.com.synergy.util.CDIServiceLocator;

@FacesConverter("componenteFerramentaConverter")
public class ComponenteFerramentaConverter implements Converter {

	private ComponentesFerramentas componentes;
	
	public ComponenteFerramentaConverter() {
	componentes = CDIServiceLocator.getBean(ComponentesFerramentas.class);
	
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		ComponenteFerramenta convertido = null;
		
		if (arg2 != null) {
			Long id = new Long(arg2);
			convertido = (ComponenteFerramenta) componentes.buscaPorId(id);
		}
		
		return convertido;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 != null){
			return String.valueOf(((ComponenteFerramenta) arg2).getIdcomponenteFerramenta());
		}
		return null;
	}
	
	

}
