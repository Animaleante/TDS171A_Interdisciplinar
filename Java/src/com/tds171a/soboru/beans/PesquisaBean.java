/**
 * 
 */
package com.tds171a.soboru.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.tds171a.soboru.vos.Ingrediente;

@Named("pesquisaBean")
@SessionScoped
/**
 * Bean de pesquisa
 */
public class PesquisaBean implements Serializable {
	
	 /**
     *criando o serial do bean
     */
	private static final long serialVersionUID = -4789696156861417503L;

	/**
	 * Recebe a rota
	 */
	private static final String ROUTE_BASE = "/pesquisa/";
	
	/**
	 * recebe os termos usados para pesquisar
	 */
	private String termoBusca;
	/**
	 * Recebe uma lista com os ingredientes
	 */
	private List<Ingrediente> listaIngredientes;

	/**
	 * Construtor da pesquisa que seta o 
	 * termo como nulo para não ter exception de 
	 * null
	 */
	public PesquisaBean() {
		setTermoBusca("");
	}
	
	/**
	 * recebe a rota para a pesquisa.
	 */
	public String pesquisar() {
		return ROUTE_BASE + "index";
	}

	/**
	 * @return the termoBusca
	 */
	public String getTermoBusca() {
		return termoBusca;
	}

	/**
	 * @param termoBusca the termoBusca to set
	 */
	public void setTermoBusca(String termoBusca) {
		this.termoBusca = termoBusca;
	}

	/**
	 * @return the listaIngredientes
	 */
	public List<Ingrediente> getListaIngredientes() {
		return listaIngredientes;
	}

	/**
	 * @param listaIngredientes the listaIngredientes to set
	 */
	public void setListaIngredientes(List<Ingrediente> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

}
