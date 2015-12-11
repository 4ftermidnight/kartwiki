package br.com.aftermidnight.kartwiki.util.jsf;


import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class FacesUtil {

	public static boolean isPostback(){
		return FacesContext.getCurrentInstance().isPostback();
	}
	
	public static boolean isNotPostback(){
		return !isPostback();
	}
	
//	static public void addErrorMessage(String msg) {
//		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
//	}
//	
//	static public void addInfoMessage(String msg) {
//		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
//	}
	
	static private void add(String message, Severity severity) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(message);
		msg.setSeverity(severity);
		
		context.addMessage(null, msg);
	}
	
	static public void info(String message) {
		add(message, FacesMessage.SEVERITY_INFO);
	}
	
	static public void error(String message) {
		add(message, FacesMessage.SEVERITY_ERROR);
	}
}
