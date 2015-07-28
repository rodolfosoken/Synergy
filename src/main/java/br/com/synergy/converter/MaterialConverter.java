package br.com.synergy.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.synergy.model.Material;
import br.com.synergy.repository.Materiais;
import br.com.synergy.util.CDIServiceLocator;

@FacesConverter(forClass = Material.class)
public class MaterialConverter implements Converter {

	private Materiais materiais;
	
	public MaterialConverter() {
	materiais = CDIServiceLocator.getBean(Materiais.class);
	
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Material convertido = null;
		
		if (arg2 != null) {
			Long id = new Long(arg2);
			convertido = materiais.buscaPorId(id);
		}
		
		return convertido;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 != null){
			return ((Material) arg2).getIdmaterial().toString();
		}
		return null;
	}
	
	

}
