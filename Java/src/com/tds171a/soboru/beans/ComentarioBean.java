package com.tds171a.soboru.beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.tds171a.soboru.controllers.ComentarioController;
import com.tds171a.soboru.vos.Comentario;

@Named("comentarioBean")
@SessionScoped
/**
 * Criação do bean herando de beanbase passando
 * o vo utilizada.
 */
public class ComentarioBean extends BeanBase<Comentario> {

	/**
     *criando o serial do bean
     */
	private static final long serialVersionUID = 8832232472604430859L;
	
	/**
     *Construtor setando a rota e qual
     *será passado para o navegador.
     */
	public ComentarioBean() {
		route_base = "/cadastro/comentario/";
		controller = new ComentarioController();
		setVo(new Comentario());
	}

	/**
     * Override do deletar, onde verifica a sessao, 
     * se existe um ítem válido e se não houver, retorna a 
     * pagina de criação.
     */
	@Override
	public String deletar() {
		// TODO Auto-generated method stub
		return null;
	}

		
	/**
	 * Verifica os dados da pagina de interação e se faltar algum dado 
	 * informa ao cliente.
	 */
	@Override
	public boolean validarDados() {
		// TODO Auto-generated method stub
		return super.validarDados();
	}

	/**
	 * Cria uma nova vo para limpar os campos para um novo registro
	 * sem interferencia de dados cadastrados anteriormente.
	 */
	@Override
	public void limparVo() {
		// TODO Auto-generated method stub
		
	}
}
