package br.com.aftermidnight.kartwiki.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.aftermidnight.kartwiki.dao.hibernate.UsuarioDAO;
import br.com.aftermidnight.kartwiki.model.Usuario;
import br.com.aftermidnight.kartwiki.util.StringUtils;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {
	
	@Inject
	private UsuarioDAO dao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;
		if (StringUtils.isNotBlank(value)) {
			retorno = this.dao.buscar(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Usuario) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());
			return retorno;
		}
		return "";
	}
}
