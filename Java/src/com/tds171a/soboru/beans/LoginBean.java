/**
 * 
 */
package com.tds171a.soboru.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.tds171a.soboru.controllers.UsuarioController;
import com.tds171a.soboru.vos.Usuario;

@ManagedBean(eager = true)
@SessionScoped
/**
 * @author Diogo
 *
 */
public class LoginBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5084200841784300266L;
	
	private String route_base = "/login/";
	private UsuarioController controller;
	
	/**
	 * 
	 */
	private String email;
	
	/**
	 * 
	 */
	private String senha;

	/**
	 * 
	 */
	public LoginBean() {
		setEmail("");
		setSenha("");
		controller = new UsuarioController(); 
	}
	
	/**
	 * 
	 * @return
	 */
	public String login() {
		Usuario usuario = controller.loginUsuario(getEmail(), getSenha());
		
		if(usuario == null) {
			FacesContext.getCurrentInstance().validationFailed();
			return "";
		}
		
		SessionContext.getInstance().setUsuarioLogado(usuario);
		
		return "/index.xhtml?faces-redirect=true";
	}
	
	/**
	 * 
	 * @return
	 */
	public String logout() {
		SessionContext.getInstance().encerrarSessao();
		return route_base + "index?faces-redirect=true";
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
