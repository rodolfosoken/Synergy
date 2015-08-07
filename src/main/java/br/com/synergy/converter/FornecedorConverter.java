package br.com.synergy.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.synergy.model.Fornecedor;
import br.com.synergy.model.FornecedorMaterial;
import br.com.synergy.repository.Fornecedores;
import br.com.synergy.util.CDIServiceLocator;

@FacesConverter("fornecedorConverter")
public class FornecedorConverter implements Converter {

	private Fornecedores fornecedores;

	public FornecedorConverter() {
		fornecedores = (Fornecedores) CDIServiceLocator
				.getBean(Fornecedores.class);

	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		FornecedorMaterial convertido = null;
		if (arg2 != null) {
			Long id = new Long(arg2);
			convertido = fornecedores.buscaPorIdMaterial(id);
		}

		return convertido;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((Fornecedor) arg2).getIdfornecedor().toString();
		}
		return "";
	}

}
