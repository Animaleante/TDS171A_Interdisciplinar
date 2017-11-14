/**
 * 
 */
package com.tds171a.soboru.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("contatoBean")
@SessionScoped
/**
 * Criação do bean herando de beanbase passando
 * o vo utilizada.
 */
public class ContatoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4706081572950852709L;
	
	private String nome;
	
	private String email;
	
	private Long telefone;
	
	private String mensagem;
	
	private String route_base = "/contato/";

	/**
     *Construtor setando a rota e qual
     *será passado para o navegador.
     */
	public ContatoBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String index() {
		return route_base + "index";
	}
	
	public String enviar() {
		// TODO - enviar mensagem
		
		setNome("");
		setEmail("");
		setTelefone(null);
		setMensagem("");
		
		return index();
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
	 * @return the telefone
	 */
	public Long getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * @param mensagem the mensagem to set
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
