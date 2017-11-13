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
	 * Cria��o do serial �nico.
	 */
	private static final long serialVersionUID = -4706861623339777245L;
	
	/**
	 * Setado as est�ticas com o final da rota
	 * para facilitar a manipula��o dos m�todos.
	 */
	protected static final String INDEX_PAGE = "index";
	protected static final String CRIAR_PAGE = "criar";
	protected static final String EXIBIR_PAGE = "exibir";
	protected static final String EDITAR_PAGE = "editar";
	protected static final String DELETAR_PAGE = "deletar";
	protected static final String FACES_REDIRECT = "?faces-redirect=true";
	
	/**
	 * Vari�vel para receber a rota do bean que implementou.
	 */
	protected String route_base;
	
	/**
	 * Vari�vel que recebe a controler que ir� auxiliar o bean.
	 */
	protected ControllerBase<T> controller;
	/**
	 * Vari�vel que ir� receber o vo que est� sendo usado.
	 */
	private T vo;
	/**
	 * Lista que ir� receber os itens para apresenta��o na p�gina.
	 */
	private List<T> lista;
	
	/**
	 * M�todo que lista todos os itens cadastrados referente a controller que est� sendo utilizada.
	 */
	public String listar() {
	    limparVo();
	    
		setLista(controller.listar());

		return route_base + INDEX_PAGE + FACES_REDIRECT;
	}

	/**
	 * M�todo que ir� chamar a tela de cria��o, referente a controller que est� sendo utilizada.
	 */
	public String criar() {
		limparVo();
	    return route_base + CRIAR_PAGE + FACES_REDIRECT;
	}

//	public abstract String incluir();
	/**
	 * M�todo que ir� adicionar o item, referente a controller que est� sendo utilizada.
	 */
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

	/**
	 * M�todo que chamar a p�gina para exibir o �tem.
	 */
	public String exibir(T vo) {
		setVo(vo);
	    return route_base + EXIBIR_PAGE + FACES_REDIRECT;
	}

	/**
	 * M�todo para chamar a p�gina para editar o �tem.
	 */
	public String editar(T vo) {
		setVo(vo);
		return route_base + EDITAR_PAGE + FACES_REDIRECT;
	}

	/**
	 * POST
	 * M�todo que edita o �tem e retorna para a lista se der certo. 
	 */
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

	/**
	 * M�todo que chama a p�gina para apagar um �tem.
	 */
	public String deletar(T vo) {
		setVo(vo);
		return route_base + DELETAR_PAGE + FACES_REDIRECT;
	}

	/**
	 * POST
	 * Ser� dado um Override no Bean que implementa. 
	 */
	public abstract String deletar();
	
	/**
	 * M�todo para validar os dados inclu�dos. 
	 * Ser� dado um Override no Bean que implementa.
	 */
	public boolean validarDados() {
		return true;
	}
	
	/**
	 * M�todo para limpar os campos de intera��o.
	 * Ser� dado um Override no Bean que implementa.
	 */
	public abstract void limparVo();

	/**
	 * M�todo que aquisi��o do VO
	 * @return vo
	 */
	public T getVo() {
		return vo;
	}

	/**
	 * M�todo para setar o vo
	 * @param vo para vo para setar
	 */
	public void setVo(T vo) {
		this.vo = vo;
	}

	/**
	 * M�roto para adiquirir uma lista de �tens.
	 * @return a lista
	 */
	public List<T> getLista() {
		return lista;
	}

	/**
	 * M�todo para puxar uma lista de �tens do banco
	 * @param lista the lista to set
	 */
	public void setLista(List<T> lista) {
		this.lista = lista;
	}
}
