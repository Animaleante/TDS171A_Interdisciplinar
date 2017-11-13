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

	/**
     *Construtor setando a rota e qual
     *será passado para o navegador.
     */
	public ContatoBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String index() {
		// TODO
		return "";
	}

}
