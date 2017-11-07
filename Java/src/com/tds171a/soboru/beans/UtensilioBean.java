/**
 *
 */
package com.tds171a.soboru.beans;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.tds171a.soboru.controllers.UtensilioController;
import com.tds171a.soboru.vos.Utensilio;

@Named("utensilioBean")
@SessionScoped
/**
 * @author Sony
 *
 */
public class UtensilioBean extends BeanBase<Utensilio> {

    /**
     *
     */
    private static final long serialVersionUID = 1526925242084747984L;

    /**
     *
     */
    public UtensilioBean() {
        route_base = "/cadastro/utensilio/";
        controller = new UtensilioController();
        setVo(new Utensilio());
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

		limparVo();

	    return listar();
	}
	
	@Override
	public boolean validarDados() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(getVo().getNome().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
	        return false;
	    }
		
		return true;
	}

	@Override
	public void limparVo() {
		setVo(new Utensilio());
	}
}