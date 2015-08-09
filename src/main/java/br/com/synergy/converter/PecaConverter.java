package br.com.synergy.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.synergy.model.Peca;
import br.com.synergy.repository.Pecas;
import br.com.synergy.util.CDIServiceLocator;

@FacesConverter("pecaConverter")
public class PecaConverter implements Converter {

	private Pecas pecas;
	
	public PecaConverter() {
	pecas = CDIServiceLocator.getBean(Pecas.class);
	
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Peca convertido = null;
		
		if (arg2 != null) {
			Long id = new Long(arg2);
			convertido = (Peca) pecas.buscaPorId(id);
		}
		
		return convertido;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 != null){
			return String.valueOf(((Peca) arg2).getIdpeca());
		}
		return null;
	}
	
	

}
