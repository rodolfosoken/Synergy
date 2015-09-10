package br.com.synergy.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.synergy.model.Usuario;
import br.com.synergy.repository.Usuarios;
import br.com.synergy.util.CDIServiceLocator;

@FacesConverter("usuarioConverter")
public class UsuarioConverter implements Converter {

	private Usuarios usuarios;

	public UsuarioConverter() {
		usuarios = (Usuarios) CDIServiceLocator
				.getBean(Usuarios.class);

	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Usuario convertido = null;
		if (arg2 != null) {
			Long id = new Long(arg2);
			convertido = usuarios.buscaPorId(id);
		}

		return convertido;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 != null) {
			return ((Usuario) arg2).getId().toString();
		}
		return "";
	}

}
