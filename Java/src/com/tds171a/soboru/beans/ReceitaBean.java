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
import com.tds171a.soboru.controllers.ComentarioController;
import com.tds171a.soboru.controllers.IngredienteController;
import com.tds171a.soboru.controllers.MedidaController;
import com.tds171a.soboru.controllers.PontuacaoController;
import com.tds171a.soboru.controllers.ReceitaController;
import com.tds171a.soboru.controllers.ReceitaIngredienteController;
import com.tds171a.soboru.controllers.ReportController;
import com.tds171a.soboru.controllers.TagController;
import com.tds171a.soboru.controllers.UsuarioController;
import com.tds171a.soboru.controllers.UtensilioController;
import com.tds171a.soboru.vos.Categoria;
import com.tds171a.soboru.vos.Ingrediente;
import com.tds171a.soboru.vos.Medida;
import com.tds171a.soboru.vos.Receita;
import com.tds171a.soboru.vos.Tag;
import com.tds171a.soboru.vos.Utensilio;

@Named("receitaBean")
@SessionScoped
/**
 * Cria��o do bean herando de beanbase passando
 * o vo utilizada.
 */
public class ReceitaBean  extends BeanBase<Receita> {

	/**
     *criando o serial do bean
     */
	private static final long serialVersionUID = 1877717137441387967L;

	private CategoriaController categoriaController;
	private UsuarioController usuarioController;
	private UtensilioController utensilioController;
	private TagController tagController;
	private ComentarioController comentarioController;
	private ReceitaIngredienteController receitaIngredienteController;
	private IngredienteController ingredienteController;
	private MedidaController medidaController;
	private ReportController reportController;
	private PontuacaoController pontuacaoController;

	private List<Categoria> categorias;
	private List<Ingrediente> ingredientes;
	private List<Medida> medidas;
	private List<Utensilio> utensilios;
	private List<Tag> tags;

	/**
     *Construtor setando a rota e qual
     *ser� passado para o navegador.
     */
	public ReceitaBean() {
		route_base = "/cadastro/receita/";
		controller = new ReceitaController();

		categoriaController = new CategoriaController();
		usuarioController = new UsuarioController();
		utensilioController = new UtensilioController();
		tagController = new TagController();
		comentarioController = new ComentarioController();
		receitaIngredienteController = new ReceitaIngredienteController();
		ingredienteController = new IngredienteController();
		medidaController = new MedidaController();
		reportController = new ReportController();
		pontuacaoController = new PontuacaoController();
		
		setVo(new Receita());
	}

	/**
	 * recebe listas de controllers especificas
	 * para passar ao cliente e ele selecionar 
	 * quais anexar na receita.
	 */
	@Override
	public String criar() {
		setCategorias(categoriaController.listar());
		setIngredientes(ingredienteController.listar());
		setMedidas(medidaController.listar());
		setUtensilios(utensilioController.listar());
		setTags(tagController.listar());

		return super.criar();
	}
	
	/**
	 * POST do criar, onde � verificado a sess�o
	 * e se v�lida gera a inclus�o da receita.
	 */
	@Override
	public String incluir() {
		getVo().setUsuarioId(SessionContext.getInstance().getUsuarioLogado().getId());
		
		return super.incluir();
	}
	
	/**
	 * Override do exibir, onde recebe o id de todas as controllers
	 * e exibe a receita ao cliente.
	 */
	@Override
	public String exibir(Receita vo) {
		if(vo.getCategoria() == null)
			vo.setCategoria(categoriaController.selecionar(vo.getCategoriaId()));
		
		if(vo.getUsuario() == null)
			vo.setUsuario(usuarioController.selecionar(vo.getUsuarioId()));
		
		if(vo.getUtensilios() == null)
			vo.setUtensilios(((UtensilioController)utensilioController).selecionarPorReceita(vo.getId()));
		
		if(vo.getTags() == null)
			vo.setTags(((TagController) tagController).selecionarPorReceita(vo.getId()));
		
		if(vo.getReceitaIngredientes() == null)
			vo.setReceitaIngredientes(((ReceitaIngredienteController) receitaIngredienteController).selecionarPorReceita(vo.getId()));
		
		return super.exibir(vo);
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
	        return route_base + DELETAR_PAGE;
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
		setVo(new Receita());
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

	/**
	 * @return the ingredientes
	 */
	public List<SelectItem> getIngredientes() {
		List<SelectItem> items = new ArrayList<SelectItem>();
	    for (Ingrediente c : this.ingredientes) {
	        items.add(new SelectItem(c.getId(), c.getNome()));
	    }
	    return items;
	}

	/**
	 * @param ingredientes the ingredientes to set
	 */
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	/**
	 * @return the medidas
	 */
	public List<SelectItem> getMedidas() {
		List<SelectItem> items = new ArrayList<SelectItem>();
	    for (Medida c : this.medidas) {
	        items.add(new SelectItem(c.getId(), c.getNome()));
	    }
	    return items;
	}

	/**
	 * @param medidas the medidas to set
	 */
	public void setMedidas(List<Medida> medidas) {
		this.medidas = medidas;
	}

	/**
	 * @return the utensilios
	 */
	public List<SelectItem> getUtensilios() {
		List<SelectItem> items = new ArrayList<SelectItem>();
	    for (Utensilio c : this.utensilios) {
	        items.add(new SelectItem(c.getId(), c.getNome()));
	    }
	    return items;
	}

	/**
	 * @param utensilios the utensilios to set
	 */
	public void setUtensilios(List<Utensilio> utensilios) {
		this.utensilios = utensilios;
	}

	/**
	 * @return the tags
	 */
	public List<Tag> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}
