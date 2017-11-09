/**
 * 
 */
package com.tds171a.soboru.beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.tds171a.soboru.controllers.PontuacaoController;
import com.tds171a.soboru.vos.Pontuacao;

@Named("pontuacaoBean")
@SessionScoped
/**
 * @author Diogo
 *
 */
public class PontuacaoBean extends BeanBase<Pontuacao> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8215281509767049355L;
	
	public PontuacaoBean() {
		route_base = "/cadastro/pontuacao/";
		controller = new PontuacaoController();
		setVo(new Pontuacao());
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
