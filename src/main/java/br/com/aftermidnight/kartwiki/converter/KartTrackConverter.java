package br.com.aftermidnight.kartwiki.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.aftermidnight.kartwiki.dao.hibernate.KartTrackDAO;
import br.com.aftermidnight.kartwiki.model.KartTrack;
import br.com.aftermidnight.kartwiki.util.StringUtils;

@FacesConverter(forClass = KartTrack.class)
public class KartTrackConverter implements Converter {
	
	@Inject
	private KartTrackDAO dao;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		KartTrack retorno = null;
		if (StringUtils.isNotBlank(value)) {
			retorno = this.dao.buscar(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((KartTrack) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());
			return retorno;
		}
		return "";
	}
}
