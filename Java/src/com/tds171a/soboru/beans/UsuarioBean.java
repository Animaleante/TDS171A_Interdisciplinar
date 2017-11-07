/**
 * 
 */
package com.tds171a.soboru.beans;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.tds171a.soboru.controllers.UsuarioController;
import com.tds171a.soboru.vos.Usuario;

@Named("usuarioBean")
@SessionScoped
/**
 * @author Diogo
 *
 */
public class UsuarioBean extends BeanBase<Usuario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4490606218207822710L;

	/**
	 * 
	 */
	public UsuarioBean() {
		route_base = "/cadastro/usuario/";
		controller = new UsuarioController();
		setVo(new Usuario());
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
		setVo(new Usuario());
	}
}
