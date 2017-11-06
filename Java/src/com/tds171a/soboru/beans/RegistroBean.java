/**
 * 
 */
package com.tds171a.soboru.beans;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.tds171a.soboru.controllers.UsuarioController;
import com.tds171a.soboru.vos.Usuario;

@Named("registroBean")
@SessionScoped
/**
 * @author Diogo
 *
 */
public class RegistroBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3690960600864076027L;
	
	private String route_base = "/registrar/";
	private UsuarioController controller;
	
	private String nome;
	private String email;
	private String senha;
	private String senhaConfirmacao;
	private Date nasc;
	private int sexo;
	private boolean notificacaoEmail;

	/**
	 * 
	 */
	public RegistroBean() {
		setNome("");
		setEmail("");
		setSenha("");
		setSenhaConfirmacao("");
		setNasc(null);
		setSexo(1);
		setNotificacaoEmail(true);
		
		controller = new UsuarioController();
	}
	
	public String incluir() {
	    FacesContext context = FacesContext.getCurrentInstance();
	    
		if(!getSenha().equals(getSenhaConfirmacao())) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas nao sao identicas!", null));
		} else {
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setNasc(nasc);
			usuario.setSexo(sexo);
			usuario.setRoleId(1);
			usuario.setNotificacaoEmail(notificacaoEmail);
			
			if(controller.incluir(usuario)) {
				setNome("");
				setEmail("");
				setSenha("");
				setSenhaConfirmacao("");
				setNasc(null);
				setSexo(1);
				setNotificacaoEmail(true);
				
				return route_base + "successo";	
			} else {
				setSenha("");
				setSenhaConfirmacao("");
		        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nao foi possivel registrar um usuario!", null));
			}
		}
		
		return route_base + "index";
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
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

	/**
	 * @return the senhaConfirmacao
	 */
	public String getSenhaConfirmacao() {
		return senhaConfirmacao;
	}

	/**
	 * @param senhaConfirmacao the senhaConfirmacao to set
	 */
	public void setSenhaConfirmacao(String senhaConfirmacao) {
		this.senhaConfirmacao = senhaConfirmacao;
	}

	/**
	 * @return the nasc
	 */
	public Date getNasc() {
		return nasc;
	}

	/**
	 * @param nasc the nasc to set
	 */
	public void setNasc(Date nasc) {
		this.nasc = nasc;
	}

	/**
	 * @return the sexo
	 */
	public int getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the notificacaoEmail
	 */
	public boolean isNotificacaoEmail() {
		return notificacaoEmail;
	}

	/**
	 * @param notificacaoEmail the notificacaoEmail to set
	 */
	public void setNotificacaoEmail(boolean notificacaoEmail) {
		this.notificacaoEmail = notificacaoEmail;
	}

}
