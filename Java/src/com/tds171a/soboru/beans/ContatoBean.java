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
 * Cria��o do bean herando de beanbase passando
 * o vo utilizada.
 */
public class ContatoBean implements Serializable {

	/**
	 * Cria��o do serial �nico
	 */
	private static final long serialVersionUID = -4706081572950852709L;
	
	/**
	 * vari�vel do tipo String para guardar
	 * o nome do contato.
	 */
	private String nome;
	
	/**
	 * vari�vel do tipo String para guardar
	 * o email do contato.
	 */
	private String email;
	
	/**
	 * vari�vel do tipo Long para guardar
	 * o n�mero do contato.
	 */
	private Long telefone;
	
	/**
	 * vari�vel do tipo String para guardar
	 * o texto da mensagem.
	 */
	private String mensagem;
	
	/**
	 * vari�vel que recebe a rota para o
	 * navegador
	 */
	private String route_base = "/contato/";

	/**
     *Construtor setando a rota e qual
     *ser� passado para o navegador.
     */
	public ContatoBean() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * M�todo que direciona
	 * para o �ndex do contato.
	 * @return
	 */
	public String index() {
		return route_base + "index";
	}
	
	/**
	 * M�todo GET limpa os campos
	 * e envia os forms para o cliente.
	 * @return para o �ndex
	 */
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
