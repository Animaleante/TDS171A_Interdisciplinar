/**
 *
 */
package com.tds171a.soboru.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

	private String routeBase = "/ingrediente/";

	private IngredienteController controller;
	private Ingrediente ingrediente;
	private List<Ingrediente> ingredienteLista;

	/**
	 *
	 */
	public IngredienteBean() {
		controller = new IngredienteController();
		setIngrediente(new Ingrediente());
	}

	public String listar() {
		setIngredienteLista(controller.listar());

		System.out.println("Tamanho lista: " + getIngredienteLista().size());

		return routeBase + "index";
	}

	public String incluir() {
	    FacesContext context = FacesContext.getCurrentInstance();

	    if(getIngrediente().getNome().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
	        return routeBase + "criar";
	    }

	    if(controller.incluir(getIngrediente())) {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingrediente cadastrado com sucesso!", null));
	    } else {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrediente nao foi cadastrado!", null));
            return routeBase + "criar";
	    }

	    setIngrediente(new Ingrediente());

	    return listar();
	}

	public String editar(Ingrediente ingrediente) {
		setIngrediente(ingrediente);
		return routeBase + "editar";
	}

	public String editar() {
	    FacesContext context = FacesContext.getCurrentInstance();

	    if(getIngrediente().getNome().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
	        return routeBase + "criar";
	    }

		if(controller.atualizar(getIngrediente())) {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingrediente atualizado com sucesso!", null));
	    } else {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrediente nao foi atualizado.", null));
            return routeBase + "editar";
		}

		setIngrediente(null);

	    return listar();
	}

	public String deletar(Ingrediente ingrediente) {
		setIngrediente(ingrediente);
		return routeBase + "deletar";
	}

	public String deletar() {
	    FacesContext context = FacesContext.getCurrentInstance();

	    if(getIngrediente() == null) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrediente nao pode ser vvazio!", null));
	        return routeBase + "criar";
	    }

		if(controller.remover(getIngrediente().getId())) {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Ingrediente deletado com sucesso!", null));
	    } else {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ingrediente nao foi deletado.", null));
            return routeBase + "deletar";
		}

		setIngrediente(null);

	    return listar();
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
