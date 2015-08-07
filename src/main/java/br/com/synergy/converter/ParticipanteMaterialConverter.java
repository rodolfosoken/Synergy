package br.com.synergy.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.synergy.model.ParticipanteMaterial;
import br.com.synergy.repository.ParticipantesMaterialRepositorio;
import br.com.synergy.util.CDIServiceLocator;

@FacesConverter(forClass = ParticipanteMaterial.class)
public class ParticipanteMaterialConverter implements Converter {

	private ParticipantesMaterialRepositorio cotacoes;
	
	public ParticipanteMaterialConverter() {
	cotacoes = CDIServiceLocator.getBean(ParticipantesMaterialRepositorio.class);
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		ParticipanteMaterial convertido = null;
		
		if (arg2 != null) {
			Long id = new Long(arg2);
			convertido = cotacoes.buscaPorId(id);
		}
		
		return convertido;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 != null){
			return String.valueOf(((ParticipanteMaterial) arg2).getIdparticipante());
		}
		return null;
	}
	
	

}
