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
import com.tds171a.soboru.controllers.IngredienteController;
import com.tds171a.soboru.controllers.MedidaController;
import com.tds171a.soboru.controllers.ReceitaController;
import com.tds171a.soboru.controllers.UtensilioController;
import com.tds171a.soboru.vos.Categoria;
import com.tds171a.soboru.vos.Ingrediente;
import com.tds171a.soboru.vos.Medida;
import com.tds171a.soboru.vos.Receita;
import com.tds171a.soboru.vos.Utensilio;

@Named("receitaBean")
@SessionScoped
/**
 * @author Sony
 *
 */
public class ReceitaBean  extends BeanBase<Receita> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1877717137441387967L;

	private List<Categoria> categorias;
	private List<Ingrediente> ingredientes;
	private List<Medida> medidas;
	private List<Utensilio> utensilios;

	/**
	 *
	 */
	public ReceitaBean() {
		route_base = "/cadastro/receita/";
		controller = new ReceitaController();
		setCategorias(new ArrayList<Categoria>());
		setIngredientes(new ArrayList<Ingrediente>());
		setMedidas(new ArrayList<Medida>());
		setUtensilios(new ArrayList<Utensilio>());
		setVo(new Receita());
	}

	@Override
	public String criar() {
		CategoriaController categoriaController = new CategoriaController();
		setCategorias(categoriaController.listar());

		IngredienteController ingredienteController = new IngredienteController();
		setIngredientes(ingredienteController.listar());

		MedidaController medidaController = new MedidaController();
		setMedidas(medidaController.listar());

		UtensilioController utensilioController = new UtensilioController();
		setUtensilios(utensilioController.listar());

		return super.criar();
	}

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

	@Override
	public boolean validarDados() {
		FacesContext context = FacesContext.getCurrentInstance();

		if(getVo().getNome().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
	        return false;
	    }

		return true;
	}

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
}
