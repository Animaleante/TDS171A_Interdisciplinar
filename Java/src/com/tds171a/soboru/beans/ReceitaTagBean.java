package com.tds171a.soboru.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import com.tds171a.soboru.vos.Tag;

@Named("receitaTagBean")
@ViewScoped
public class ReceitaTagBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1219962404859468474L;
	
	private List<Tag> lista;

	public ReceitaTagBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void add() {
		lista.add(null);
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

}
