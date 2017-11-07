/**
 *
 */
package com.tds171a.soboru.beans;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.tds171a.soboru.controllers.MedidaController;
import com.tds171a.soboru.vos.Medida;

@Named("medidaBean")
@SessionScoped
/**
 * @author Sony
 *
 */
public class MedidaBean extends BeanBase<Medida> {

	/**
	 *
	 */
	private static final long serialVersionUID = 8410408634179869866L;

	/**
	 *
	 */
	public MedidaBean() {
		route_base = "/cadastro/medida/";
		controller = new MedidaController();
		setVo(new Medida());
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
		setVo(new Medida());
	}
}
