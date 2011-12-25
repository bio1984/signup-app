package org.company.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.company.model.SignupRequest;
import org.company.service.SignupRequestService;
import org.company.service.events.Approved;
import org.company.service.events.Confirmed;

@Named("loginAction")
@RequestScoped
public class LoginAction {

	@Inject
	private Logger log;

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String logout() {
		log.info("logout....@");
		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		externalContext.invalidateSession();
		return "/login?faces-redirect=true";
	}

	public String login() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		try {
			request.login(username, password);
			FacesUtil.info("Welcome back, " + this.username);

			return "/admin/unconfirmed?faces-redirect=true";
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/login?faces-redirect=true&error=1";
	}

}