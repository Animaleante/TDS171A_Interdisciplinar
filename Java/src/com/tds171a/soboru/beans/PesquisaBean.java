/**
 * 
 */
package com.tds171a.soboru.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import com.tds171a.soboru.controllers.CategoriaController;
import com.tds171a.soboru.controllers.IngredienteController;
import com.tds171a.soboru.controllers.ReceitaController;
import com.tds171a.soboru.vos.Categoria;
import com.tds171a.soboru.vos.Ingrediente;
import com.tds171a.soboru.vos.Receita;

@Named("pesquisaBean")
@SessionScoped
/**
 * Bean de pesquisa
 */
public class PesquisaBean implements Serializable {
	
	 /**
     *criando o serial do bean
     */
	private static final long serialVersionUID = -4789696156861417503L;

	/**
	 * Recebe a rota
	 */
	private static final String ROUTE_BASE = "/pesquisa/";
	
	/**
	 * Controlador de Receita
	 */
	private ReceitaController receitaController;
	
	/**
	 * Controlador de Ingrediente
	 */
	private IngredienteController ingredienteController;
	
	/**
	 * Controlador de categoria
	 */
	private CategoriaController categoriaController;
	
	/**
	 * Recebe os ingredientes a serem usados na pesquisa
	 */
	private List<Integer> lista;
	
	/**
	 * Recebe os termos usados para pesquisar
	 */
	private String termoBusca;
	
	/**
	 * Recebe o id da categoria para pesquisar
	 */
	private int categoriaId;
	
	/**
	 * Recebe uma lista com os ingredientes
	 */
	private List<Ingrediente> listaIngredientes;
	
	/**
	 * Recebe uma lista com as categorias existentes
	 */
	private List<Categoria> listaCategorias;
	
	/**
	 * Recebe uma lista de receitas que vieram como resultados da pesquisa
	 */
	private List<Receita> resultados;

	/**
	 * Construtor da pesquisa que seta o 
	 * termo como nulo para não ter exception de 
	 * null
	 */
	public PesquisaBean() {
		receitaController = new ReceitaController();
		ingredienteController = new IngredienteController();
		categoriaController = new CategoriaController();
		
		setLista(new ArrayList<Integer>());
		setTermoBusca("");
		setCategoriaId(0);
		setResultados(new ArrayList<Receita>());
		setListaIngredientes(ingredienteController.listar());
		setListaCategorias(categoriaController.listar());
	}
	
	public String index() {
		setLista(new ArrayList<Integer>());
		setTermoBusca("");
		setCategoriaId(0);
		setResultados(new ArrayList<Receita>());
		setListaIngredientes(ingredienteController.listar());
		setListaCategorias(categoriaController.listar());
		
		return ROUTE_BASE+BeanBase.INDEX_PAGE+BeanBase.FACES_REDIRECT;
	}
	
	/**
	 * recebe a rota para a pesquisa.
	 */
	public String pesquisar() {
		lista.add(1);
		lista.add(3);
		
		if(!getTermoBusca().isEmpty() && getLista().size() > 0) {
			setResultados(receitaController.selecionarPorNomeEIngredientes(getTermoBusca(), getLista()));
		} else if(!getTermoBusca().isEmpty()) {
			setResultados(receitaController.selecionarPorNome(getTermoBusca()));
		} else if(getLista().size() > 0) {
			receitaController.selecionarPorIngredientes(getLista());
		}

		return ROUTE_BASE+BeanBase.INDEX_PAGE+BeanBase.FACES_REDIRECT;
	}

	/**
	 * @return the termoBusca
	 */
	public String getTermoBusca() {
		return termoBusca.trim();
	}

	/**
	 * @param termoBusca the termoBusca to set
	 */
	public void setTermoBusca(String termoBusca) {
		this.termoBusca = termoBusca;
	}

	/**
	 * @return the listaIngredientes
	 */
	public List<Ingrediente> getListaIngredientes() {
		return listaIngredientes;
	}

	/**
	 * @param listaIngredientes the listaIngredientes to set
	 */
	public void setListaIngredientes(List<Ingrediente> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

	/**
	 * @return the listaCategorias
	 */
	public List<SelectItem> getListaCategorias() {
		List<SelectItem> items = new ArrayList<SelectItem>();
	    for (Categoria c : this.listaCategorias) {
	        items.add(new SelectItem(c.getId(), c.getNome()));
	    }
	    return items;
	}

	/**
	 * @param listaCategorias the listaCategorias to set
	 */
	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	/**
	 * @return the categoriaId
	 */
	public int getCategoriaId() {
		return categoriaId;
	}

	/**
	 * @param categoriaId the categoriaId to set
	 */
	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}

	/**
	 * @return the resultados
	 */
	public List<Receita> getResultados() {
		return resultados;
	}

	/**
	 * @param resultados the resultados to set
	 */
	public void setResultados(List<Receita> resultados) {
		this.resultados = resultados;
	}

	/**
	 * @return the lista
	 */
	public List<Integer> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<Integer> lista) {
		this.lista = lista;
	}

}
