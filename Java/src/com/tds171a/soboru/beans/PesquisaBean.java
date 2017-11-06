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
 * @author Sony
 *
 */
public class PesquisaBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4789696156861417503L;

	private static final String ROUTE_BASE = "/pesquisa/";
	
	private String termoBusca;
	private List<Ingrediente> listaIngredientes;

	/**
	 * 
	 */
	public PesquisaBean() {
		setTermoBusca("");
	}
	
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
