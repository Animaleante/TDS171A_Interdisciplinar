package com.tds171a.soboru.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import com.tds171a.soboru.controllers.ReceitaController;
import com.tds171a.soboru.controllers.TagController;
import com.tds171a.soboru.vos.Receita;
import com.tds171a.soboru.vos.Tag;

//@ManagedBean(name="receitaTagBean")
//@ViewScoped
@Named("receitaTagBean")
@SessionScoped
public class ReceitaTagBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1219962404859468474L;

	private Receita receita;
	private ReceitaController receitaController;
	private TagController tagController;
	private List<Tag> lista;
	private List<Tag> listaTags;

	public ReceitaTagBean() {
		receitaController = new ReceitaController();
		tagController = new TagController();
		lista = new ArrayList<Tag>();
		listaTags = new ArrayList<Tag>();
	}

	public String criar(int receitaId) {
		setReceita(receitaController.selecionar(receitaId));
		setLista(receitaController.listarTags(getReceita()));
		setListaTags(tagController.listar());

		System.out.println("ReceitaId: " + getReceita().getId());
		System.out.println("Current num tags: " + getLista().size());
		System.out.println("Available tags: " + getListaTags().size());

		return "/cadastro/receita-tag/criar?faces-redirect=true";
	}

	public void adicionar() {
		lista.add(new Tag());
	}

	public void remover(int index) {
	    lista.remove(index);
	}

	public String salvar() {
		System.out.println("Salvar: " + lista.size());
		receitaController.registrarTags(getLista());
		return "";
	}

	/**
	 * @return the lista
	 */
	public List<Tag> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<Tag> lista) {
		this.lista = lista;
	}

	/**
	 * @return the receita
	 */
	public Receita getReceita() {
		return receita;
	}

	/**
	 * @param receita the receita to set
	 */
	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	/**
	 * @return the listaTags
	 */
	public List<SelectItem> getListaTags() {
		List<SelectItem> items = new ArrayList<SelectItem>();
	    for (Tag t : this.listaTags) {
	        items.add(new SelectItem(t.getId(), t.getNome()));
	    }
	    return items;
	}

	/**
	 * @param listaTags the listaTags to set
	 */
	public void setListaTags(List<Tag> listaTags) {
		this.listaTags = listaTags;
	}

}
