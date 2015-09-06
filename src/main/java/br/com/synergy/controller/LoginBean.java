package br.com.synergy.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Named
@SessionScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private FacesContext facesContext = FacesContext.getCurrentInstance();
	
	private ExternalContext externalContext = facesContext.getExternalContext();
	
	private HttpServletRequest request= (HttpServletRequest) externalContext.getRequest();
	
	private HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		
	private String email;
	
	public void login() throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward(request, response);
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	


}
