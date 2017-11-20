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
 * Cria��o do bean herando de beanbase passando
 * o vo utilizada.
 */
public class UtensilioBean extends BeanBase<Utensilio> {

	/**
     *criando o serial do bean
     */
    private static final long serialVersionUID = 1526925242084747984L;

    /**
     *Construtor setando a rota e qual
     *ser� passado para o navegador.
     */
    public UtensilioBean() {
        route_base = "/cadastro/utensilio/";
        controller = new UtensilioController();
        setVo(new Utensilio());
    }

    /**
     * Override do deletar, onde verifica a sessao, 
     * se existe um �tem v�lido e se n�o houver, retorna a 
     * pagina de cria��o.
     */
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
	
	/**
	 * Verifica os dados da pagina de intera��o e se faltar algum dado 
	 * informa ao cliente.
	 */
	@Override
	public boolean validarDados() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(getVo().getNome().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
	        return false;
	    }
		
		return true;
	}

	/**
	 * Cria uma nova vo para limpar os campos para um novo registro
	 * sem interferencia de dados cadastrados anteriormente.
	 */
	@Override
	public void limparVo() {
		setVo(new Utensilio());
	}
}
