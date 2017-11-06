/**
 *
 */
package com.tds171a.soboru.beans;

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
public class IngredienteBean extends BeanBase<Ingrediente> {

	/**
	 *
	 */
	private static final long serialVersionUID = 8410408634179869866L;

	/**
	 *
	 */
	public IngredienteBean() {
		route_base = "/ingrediente/";
		controller = new IngredienteController();
		setVo(new Ingrediente());
	}

	@Override

	public String incluir() {
	    FacesContext context = FacesContext.getCurrentInstance();

	    if(getVo().getNome().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
	        return route_base + CRIAR_PAGE;
	    }

	    if(controller.incluir(getVo())) {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso!", null));
	    } else {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nao foi possivel fazer o cadastro!", null));
            return route_base + CRIAR_PAGE;
	    }

	    setVo(new Ingrediente());

	    return listar();
	}

	@Override

	public String editar() {
	    FacesContext context = FacesContext.getCurrentInstance();

	    if(getVo().getNome().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
	        return route_base + CRIAR_PAGE;
	    }

		if(controller.atualizar(getVo())) {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizada com sucesso!", null));
	    } else {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nao foi possivel fazer a atualizacao.", null));
            return route_base + EDITAR_PAGE;
		}

		setVo(new Ingrediente());

	    return listar();
	}

	@Override
	public String deletar() {
	    FacesContext context = FacesContext.getCurrentInstance();

	    if(getVo().getId() == -1) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Item nao pode ser vazio!", null));
	        return route_base + CRIAR_PAGE;
	    }

		if(controller.remover(getVo().getId())) {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado com sucesso!", null));
	    } else {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nao foi possivel deletar.", null));
            return route_base + DELETAR_PAGE;
		}

		setVo(new Ingrediente());

	    return listar();
	}
}
