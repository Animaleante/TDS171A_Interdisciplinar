/**
 * 
 */
package com.tds171a.soboru.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.tds171a.soboru.controllers.IngredienteController;
import com.tds171a.soboru.vos.Ingrediente;

@Named("ingredienteBean")
@SessionScoped
/**
 * @author Sony
 *
 */
public class IngredienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8410408634179869866L;
	
	private IngredienteController controller;
	private Ingrediente ingrediente;
	private List<Ingrediente> ingredienteLista;

	/**
	 * 
	 */
	public IngredienteBean() {
		controller = new IngredienteController();
		setIngrediente(new Ingrediente());
		//setIngredienteLista(controller.listar());
	}
	
	public String listar() {
		setIngredienteLista(controller.listar());
		
		System.out.println("Lista size: " + getIngredienteLista().size());
		
		return "/ingrediente/index";
	}

	/**
	 * @return the ingrediente
	 */
	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	/**
	 * @param ingrediente the ingrediente to set
	 */
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	/**
	 * @return the ingredienteLista
	 */
	public List<Ingrediente> getIngredienteLista() {
		return ingredienteLista;
	}

	/**
	 * @param ingredienteLista the ingredienteLista to set
	 */
	public void setIngredienteLista(List<Ingrediente> ingredienteLista) {
		this.ingredienteLista = ingredienteLista;
	}

}
