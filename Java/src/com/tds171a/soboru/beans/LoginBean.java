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
 * Bean de login
 */
public class LoginBean implements Serializable {
	
	/**
     *criando o serial do bean
     */
	private static final long serialVersionUID = 5084200841784300266L;
	
	/**
	 * variavel recebe a rota da aplica��o.
	 */
	private String route_base = "/login/";
	/**
	 * objeto do tipo controller 
	 */
	private UsuarioController controller;
	
	/**
	 * vari�vel respons�vel para manipular o
	 * email do cliente. 
	 */
	private String email;
	
	/**
	 * vari�vel que ir� receber a senha do cliente
	 */
	private String senha;

	/**
	 * contrutor que cria um novo usu�rio controller
	 * para manipula��o dos dados.
	 */
	public LoginBean() {
		setEmail("");
		setSenha("");
		controller = new UsuarioController(); 
	}
	
	/**
	 * m�todo que informa a rota da �ndex
	 * @return
	 */
	public String index() {
		return route_base + "index";
	}
	
	/**
	 * m�todo que efetua o login do cliente e cria uma sessao
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
	 * m�todo para dar logoff na sess�o
	 * @return
	 */
	public String logout() {
		SessionContext.getInstance().encerrarSessao();
		return route_base + "index?faces-redirect=true";
	}
	
	/**
	 * m�todo que verifica se a sess�o est� v�lida
	 */ 
	public boolean isLogado() {
		return SessionContext.getInstance().isLogado();
	}

	/**
	 * adiquirir o email
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * seta o email
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * adiquirir a senha
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * setar a senha.
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
