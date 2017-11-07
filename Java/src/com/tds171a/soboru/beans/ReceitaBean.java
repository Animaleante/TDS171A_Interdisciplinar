/**
 * 
 */
package com.tds171a.soboru.beans;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.tds171a.soboru.controllers.ReceitaController;
import com.tds171a.soboru.vos.Receita;

@Named("receitaBean")
@SessionScoped
/**
 * @author Sony
 *
 */
public class ReceitaBean  extends BeanBase<Receita> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1877717137441387967L;

	/**
	 *
	 */
	public ReceitaBean() {
		route_base = "/cadastro/receita/";
		controller = new ReceitaController();
		setVo(new Receita());
	}
	
	/*@Override
	public String listar() {
		if(!SessionContext.getInstance().isLogado()) {
			return "/login/index";
		}
		
		return super.listar();
	}*/

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
		setVo(new Receita());
	}
}
