/**
 *
 */
package com.tds171a.soboru.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import com.tds171a.soboru.controllers.CategoriaController;
import com.tds171a.soboru.utils.Utils;
import com.tds171a.soboru.vos.Categoria;

@Named("categoriaBean")
@SessionScoped
/**
 * Criação do bean herando de beanbase passando
 * o vo utilizada.
 */
public class CategoriaBean extends BeanBase<Categoria> {

    /**
     *criando o serial do bean
     */
    private static final long serialVersionUID = 8410408634179869866L;

	private List<Categoria> categorias;
	
    /**
     *Construtor setando a rota e qual
     *será passado para o navegador.
     */
    public CategoriaBean() {
    	route_base = "/cadastro/categoria/";
        controller = new CategoriaController();
        setVo(new Categoria());
    }
    
    @Override
    public String criar() {
    	setCategorias(((CategoriaController)controller).listarGrupos());
    	getVo().setSelecionavel(!getVo().getSelecionavel());

	    return route_base + CRIAR_PAGE + FACES_REDIRECT;
    }
    
    @Override
    public String incluir() {
    	getVo().setSlug(Utils.toSlug(getVo().getNome()));
    	getVo().setSelecionavel(!getVo().getSelecionavel());
    	if(!getVo().getSelecionavel())
    		getVo().setIdSuperCategoria(-1);
    	
    	return super.incluir();
    }
    
    @Override
    public String editar(Categoria vo) {
    	setCategorias(((CategoriaController)controller).listarGrupos());
    	vo.setSelecionavel(!vo.getSelecionavel());
    	
    	return super.editar(vo);
    }
    
    @Override
    public String editar() {
    	getVo().setSlug(Utils.toSlug(getVo().getNome()));
    	getVo().setSelecionavel(!getVo().getSelecionavel());
    	if(!getVo().getSelecionavel())
    		getVo().setIdSuperCategoria(-1);
    	
    	return super.editar();
    }

    /**
     * Override do deletar, onde verifica a sessao, 
     * se existe um ítem válido e se não houver, retorna a 
     * pagina de criação.
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
	 * Verifica os dados da pagina de interação e se faltar algum dado 
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
		setVo(new Categoria());
	}

	/**
	 * @return the categorias
	 */
	public List<SelectItem> getCategorias() {
		List<SelectItem> items = new ArrayList<SelectItem>();
	    for (Categoria c : this.categorias) {
	        items.add(new SelectItem(c.getId(), c.getNome()));
	    }
	    return items;
	}

	/**
	 * @param categorias the categorias to set
	 */
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
}
