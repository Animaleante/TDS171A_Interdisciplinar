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

import com.tds171a.soboru.controllers.ReceitaController;
import com.tds171a.soboru.vos.Receita;

@Named("receitaBean")
@SessionScoped
/**
 * @author Sony
 *
 */
public class ReceitaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1877717137441387967L;

	private static final String ROUTE_BASE = "/receitas/";

	private ReceitaController controller;
	private Receita receita;
	private List<Receita> lista;

	/**
	 *
	 */
	public ReceitaBean() {
		controller = new ReceitaController();
		setReceita(new Receita());
	}

	public String listar() {
		setLista(controller.listar());

		return ROUTE_BASE + "index";
	}

	public String incluir() {
	    FacesContext context = FacesContext.getCurrentInstance();

	    if(getReceita().getNome().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
	        return ROUTE_BASE + "criar";
	    }

	    if(controller.incluir(getReceita())) {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Receita cadastrada com sucesso!", null));
	    } else {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Receita nao foi cadastrada!", null));
            return ROUTE_BASE + "criar";
	    }

	    setReceita(new Receita());

	    return listar();
	}

	public String exibir(Receita receita) {
		setReceita(receita);
	    return ROUTE_BASE + "exibir";
	}

	public String editar(Receita receita) {
		setReceita(receita);
		return ROUTE_BASE + "editar";
	}

	public String editar() {
	    FacesContext context = FacesContext.getCurrentInstance();

	    if(getReceita().getNome().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
	        return ROUTE_BASE + "criar";
	    }

		if(controller.atualizar(getReceita())) {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Receita atualizada com sucesso!", null));
	    } else {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Receita nao foi atualizada.", null));
            return ROUTE_BASE + "editar";
		}

		setReceita(new Receita());

	    return listar();
	}

	public String deletar(Receita receita) {
		setReceita(receita);
		return ROUTE_BASE + "deletar";
	}

	public String deletar() {
	    FacesContext context = FacesContext.getCurrentInstance();

	    if(getReceita().getId() == -1) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Receita nao pode ser vazio!", null));
	        return ROUTE_BASE + "criar";
	    }

		if(controller.remover(getReceita().getId())) {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Receita deletada com sucesso!", null));
	    } else {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Receita nao foi deletada.", null));
            return ROUTE_BASE + "deletar";
		}

		setReceita(new Receita());

	    return listar();
	}

	/**
	 * @return the receita
	 */
	public Receita getReceita() {
		return receita;
	}

	/**
	 * @param receita the receita to set
	 */
	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	/**
	 * @return the lista
	 */
	public List<Receita> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<Receita> lista) {
		this.lista = lista;
	}

}
