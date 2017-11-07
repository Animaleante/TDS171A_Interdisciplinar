/**
 * 
 */
package com.tds171a.soboru.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.tds171a.soboru.controllers.ControllerBase;

/**
 * @author Diogo
 *
 */
public abstract class BeanBase<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4706861623339777245L;
	
	protected static final String INDEX_PAGE = "index";
	protected static final String CRIAR_PAGE = "criar";
	protected static final String EXIBIR_PAGE = "exibir";
	protected static final String EDITAR_PAGE = "editar";
	protected static final String DELETAR_PAGE = "deletar";
	
	protected String route_base;
	protected ControllerBase<T> controller;
	private T vo;
	private List<T> lista;
	
	public String listar() {
	    limparVo();
	    
		setLista(controller.listar());

		return route_base + INDEX_PAGE;
	}

	public String criar() {
		limparVo();
	    return route_base + CRIAR_PAGE;
	}

//	public abstract String incluir();
	public String incluir() {
		FacesContext context = FacesContext.getCurrentInstance();

	    if(!validarDados())
	    	return route_base + CRIAR_PAGE;

	    if(controller.incluir(getVo())) {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado com sucesso!", null));
	    } else {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nao foi possivel fazer o cadastro!", null));
            return route_base + CRIAR_PAGE;
	    }

	    limparVo();

	    return listar();
	}

	public String exibir(T vo) {
		setVo(vo);
	    return route_base + EXIBIR_PAGE;
	}

	public String editar(T vo) {
		setVo(vo);
		return route_base + EDITAR_PAGE;
	}

//	public abstract String editar();
	public String editar() {
		FacesContext context = FacesContext.getCurrentInstance();

	    if(!validarDados())
	    	return route_base + EDITAR_PAGE;

	    if(controller.atualizar(getVo())) {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualizada com sucesso!", null));
	    } else {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nao foi possivel fazer a atualizacao.", null));
            return route_base + EDITAR_PAGE;
		}

	    limparVo();

	    return listar();
	}

	public String deletar(T vo) {
		setVo(vo);
		return route_base + DELETAR_PAGE;
	}

	public abstract String deletar();
	
	public boolean validarDados() {
		return true;
	}
	
	public abstract void limparVo();

	/**
	 * @return the vo
	 */
	public T getVo() {
		return vo;
	}

	/**
	 * @param vo the vo to set
	 */
	public void setVo(T vo) {
		this.vo = vo;
	}

	/**
	 * @return the lista
	 */
	public List<T> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<T> lista) {
		this.lista = lista;
	}
}
