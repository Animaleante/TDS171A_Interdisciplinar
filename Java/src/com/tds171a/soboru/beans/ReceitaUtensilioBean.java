package com.tds171a.soboru.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import com.tds171a.soboru.controllers.ReceitaController;
import com.tds171a.soboru.controllers.UtensilioController;
import com.tds171a.soboru.vos.Receita;
import com.tds171a.soboru.vos.Utensilio;

//@ManagedBean(name="receitaTagBean")
//@ViewScoped
@Named("receitaUtensilioBean")
@SessionScoped
public class ReceitaUtensilioBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1219962404859468474L;

	private Receita receita;
	private ReceitaController receitaController;
	private UtensilioController utensilioController;
	private List<Utensilio> lista;
	private List<Utensilio> listaUtensilios;

	public ReceitaUtensilioBean() {
		receitaController = new ReceitaController();
		utensilioController = new UtensilioController();
		lista = new ArrayList<Utensilio>();
		listaUtensilios = new ArrayList<Utensilio>();
	}

	public String criar(int receitaId) {
		setReceita(receitaController.selecionar(receitaId));
		setLista(receitaController.listarUtensilios(getReceita()));
		setListaUtensilios(utensilioController.listar());

		return "/cadastro/receita-utensilio/criar?faces-redirect=true";
	}

	public void adicionar() {
		lista.add(new Utensilio());
	}

	public void remover(Utensilio utensilio) {
	    lista.remove(utensilio);
	}

	public String salvar() {
		receitaController.registrarUtensilios(getReceita().getId(), getLista());
		return "/cadastro/receita/"+BeanBase.INDEX_PAGE+BeanBase.FACES_REDIRECT;
	}

	/**
	 * @return the lista
	 */
	public List<Utensilio> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(List<Utensilio> lista) {
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
	public List<SelectItem> getListaUtensilios() {
		List<SelectItem> items = new ArrayList<SelectItem>();
	    for (Utensilio u : this.listaUtensilios) {
	        items.add(new SelectItem(u.getId(), u.getNome()));
	    }
	    return items;
	}

	/**
	 * @param listaUtensilios the listaTags to set
	 */
	public void setListaUtensilios(List<Utensilio> listaUtensilios) {
		this.listaUtensilios = listaUtensilios;
	}

}
