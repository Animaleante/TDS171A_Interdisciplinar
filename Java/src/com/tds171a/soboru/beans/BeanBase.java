/**
 * 
 */
package com.tds171a.soboru.beans;

import java.io.Serializable;
import java.util.List;

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
		setLista(controller.listar());

		return route_base + INDEX_PAGE;
	}

	public abstract String incluir();

	public String exibir(T vo) {
		setVo(vo);
	    return route_base + EXIBIR_PAGE;
	}

	public String editar(T vo) {
		setVo(vo);
		return route_base + EDITAR_PAGE;
	}

	public abstract String editar();

	public String deletar(T vo) {
		setVo(vo);
		return route_base + DELETAR_PAGE;
	}

	public abstract String deletar();

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
