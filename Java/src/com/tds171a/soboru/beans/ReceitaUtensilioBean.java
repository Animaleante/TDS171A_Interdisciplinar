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

@Named("receitaUtensilioBean")
@SessionScoped
/**
 * 
 * @author PC970
 *
 */
public class ReceitaUtensilioBean implements Serializable {

	/**
	 *Cria��o do serial �nico
	 */
	private static final long serialVersionUID = -1219962404859468474L;

	//Declara��o das vari�veis utilizadas no bean.
	private Receita receita;
	private ReceitaController receitaController;
	private UtensilioController utensilioController;
	//Declara��o de listas.
	private List<Utensilio> lista;
	private List<Utensilio> listaUtensilios;

	/**
	 * Construtor que inicia as controllers.
	 */
	public ReceitaUtensilioBean() {
		receitaController = new ReceitaController();
		utensilioController = new UtensilioController();
		lista = new ArrayList<Utensilio>();
		listaUtensilios = new ArrayList<Utensilio>();
	}

	/**
	 * M�todo GET em que tr�s as listas de ingredentte
	 * e utensilios
	 * @param receitaId
	 * @return
	 */
	public String criar(int receitaId) {
		setReceita(receitaController.selecionar(receitaId));
		setLista(receitaController.listarUtensilios(getReceita()));
		setListaUtensilios(utensilioController.listar());

		return "/cadastro/receita-utensilio/criar?faces-redirect=true";
	}

	/**
	 * Adiciona um utensilio na tela de cadastro
	 * de receita.
	 */
	public void adicionar() {
		lista.add(new Utensilio());
	}

	/**
	 * Remove um utensilio da tela de cadastro
	 * da receita.
	 * @param utensilio
	 */
	public void remover(Utensilio utensilio) {
	    lista.remove(utensilio);
	}

	/**
	 * M�todo que salva os utensilios cadastrados 
	 * na receita.
	 * @return
	 */
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
