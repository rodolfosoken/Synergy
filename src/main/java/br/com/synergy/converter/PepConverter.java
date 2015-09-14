package br.com.synergy.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.synergy.model.Pep;
import br.com.synergy.repository.Peps;
import br.com.synergy.util.CDIServiceLocator;

@FacesConverter("pepConverter")
public class PepConverter implements Converter {

	private Peps peps;

	public PepConverter() {
		peps = (Peps) CDIServiceLocator.getBean(Peps.class);

	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Pep convertido = null;
		if (arg2 != null) {
			Long id = new Long(arg2);
			convertido = peps.buscaPorId(id);
		}

		return convertido;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((Pep) arg2).getId().toString();
		}
		return "";
	}

}
