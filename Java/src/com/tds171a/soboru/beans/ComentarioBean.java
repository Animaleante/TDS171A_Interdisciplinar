package com.tds171a.soboru.beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.tds171a.soboru.controllers.ComentarioController;
import com.tds171a.soboru.vos.Comentario;

@Named("comentarioBean")
@SessionScoped
public class ComentarioBean extends BeanBase<Comentario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8832232472604430859L;
	
	public ComentarioBean() {
		route_base = "/cadastro/comentario/";
		controller = new ComentarioController();
		setVo(new Comentario());
	}

	@Override
	public String deletar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void limparVo() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean validarDados() {
		// TODO Auto-generated method stub
		return super.validarDados();
	}

}
