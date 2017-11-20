package com.tds171a.soboru.beans;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.tds171a.soboru.controllers.ComentarioController;
import com.tds171a.soboru.vos.Comentario;

@Named("comentarioBean")
@SessionScoped
/**
 * Cria��o do bean herando de beanbase passando
 * o vo utilizada.
 */
public class ComentarioBean extends BeanBase<Comentario> {

	/**
     *criando o serial do bean
     */
	private static final long serialVersionUID = 8832232472604430859L;
	
	/**
     *Construtor setando a rota e qual
     *ser� passado para o navegador.
     */
	public ComentarioBean() {
		route_base = "/cadastro/comentario/";
		controller = new ComentarioController();
		setVo(new Comentario());
	}
	
	public String incluir(int receitaId){
		getVo().setReceitaId(receitaId);
		return incluir();
	}
	
	public String incluir(){
		getVo().setUsuarioId(SessionContext.getInstance().getUsuarioLogado().getId());
		
		super.incluir();
		
		return "/receita/"+EXIBIR_PAGE+FACES_REDIRECT;
	}

	/**
     * Override do deletar, onde verifica a sessao, 
     * se existe um �tem v�lido e se n�o houver, retorna a 
     * pagina de cria��o.
     */
	@Override
	public String deletar() {
        FacesContext context = FacesContext.getCurrentInstance();

        if(((ComentarioController)controller).remover(getVo().getReceitaId(), getVo().getUsuarioId())) {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado com sucesso!", null));
        } else {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nao foi possivel deletar.", null));
            return route_base + DELETAR_PAGE;
        }

        limparVo();

        return listar();
	}

	/**
	 * Cria uma nova vo para limpar os campos para um novo registro
	 * sem interferencia de dados cadastrados anteriormente.
	 */
	@Override
	public void limparVo() {
		setVo(new Comentario());
	}
}
