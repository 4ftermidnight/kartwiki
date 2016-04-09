package br.com.aftermidnight.kartwiki.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aftermidnight.kartwiki.util.jsf.FacesUtil;


@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext facesContext;
	
	@Inject
	private HttpServletRequest request;
	
	@Inject
	private HttpServletResponse response;
	
	private String email;

	public void preRender() {
		if ("true".equals(request.getParameter("invalid"))) {
			FacesUtil.error("Usuário ou senha inválido!");
		}
	}
	
	public void login() throws ServletException, IOException {
		
		request.getCookies();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
		
		//apenas um exemplo de como adicionar cookie, para, por exemplo, guardar o ultimo login do usuario
		Cookie cookie = new Cookie("kartwiki-last-login", new Date().toString());
		cookie.setMaxAge(1*60*60*24); // 1 dia
		response.addCookie(cookie);
		
		dispatcher.forward(request, response);
		
		facesContext.responseComplete();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}