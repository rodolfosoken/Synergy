package br.com.synergy.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.synergy.model.Ferramenta;
import br.com.synergy.repository.Ferramentas;
import br.com.synergy.util.CDIServiceLocator;

@FacesConverter("ferramentaConverter")
public class FerramentaConverter implements Converter {

	private Ferramentas ferramentas;
	
	public FerramentaConverter() {
	ferramentas = CDIServiceLocator.getBean(Ferramentas.class);
	
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Ferramenta convertido = null;
		
		if (arg2 != null) {
			Long id = new Long(arg2);
			convertido = (Ferramenta) ferramentas.buscaPorId(id);
		}
		
		return convertido;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 != null){
			return String.valueOf(((Ferramenta) arg2).getIdferramenta());
		}
		return null;
	}
	
	

}
