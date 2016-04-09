package br.com.aftermidnight.kartwiki.util.jsf;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

public class FacesProducer {

	@Produces
	@RequestScoped
	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	@Produces
	@RequestScoped
	public ExternalContext getExternalContext() {
		return getFacesContext().getExternalContext();
	}
	
//	Não precisa pq o JEE7 já possui um produtor padrão de request
//	@Produces
//	@RequestScoped
//	public HttpServletRequest getHttpServletRequest() {
//		return ((HttpServletRequest) getExternalContext().getRequest());	
//	}
	
	@Produces
	@RequestScoped
	public HttpServletResponse getHttpServletResponse() {
		return ((HttpServletResponse) getExternalContext().getResponse());	
	}
	
}
