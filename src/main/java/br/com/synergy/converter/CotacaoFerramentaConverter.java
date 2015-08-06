package br.com.synergy.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.synergy.model.CotacaoFerramenta;
import br.com.synergy.repository.CotacoesFerramentas;
import br.com.synergy.util.CDIServiceLocator;

@FacesConverter(forClass = CotacaoFerramenta.class)
public class CotacaoFerramentaConverter implements Converter {

	private CotacoesFerramentas cotacoes;
	
	public CotacaoFerramentaConverter() {
	cotacoes = CDIServiceLocator.getBean(CotacoesFerramentas.class);
	
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		CotacaoFerramenta convertido = null;
		
		if (arg2 != null) {
			Long id = new Long(arg2);
			convertido = cotacoes.buscaPorId(id);
		}
		
		return convertido;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 != null){
			return String.valueOf(((CotacaoFerramenta) arg2).getIdcotacao());
		}
		return null;
	}
	
	

}
