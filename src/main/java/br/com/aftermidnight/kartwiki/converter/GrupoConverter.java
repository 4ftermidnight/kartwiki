package br.com.aftermidnight.kartwiki.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.aftermidnight.kartwiki.dao.hibernate.GrupoDAO;
import br.com.aftermidnight.kartwiki.model.Grupo;
import br.com.aftermidnight.kartwiki.util.StringUtils;

@FacesConverter(value="grupoConverter", forClass = Grupo.class)
public class GrupoConverter implements Converter {
	
	@Inject
	private GrupoDAO dao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Grupo retorno = null;
		if (StringUtils.isNotBlank(value)) {
			retorno = this.dao.buscar(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Grupo) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());
			return retorno;
		}
		return "";
	}
}
