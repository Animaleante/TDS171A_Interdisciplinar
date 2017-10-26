/**
 *
 */
package com.tds171a.soboru.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.tds171a.soboru.controllers.MedidaController;
import com.tds171a.soboru.vos.Medida;

@Named("medidaBean")
@SessionScoped
/**
 * @author Sony
 *
 */
public class MedidaBean implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8410408634179869866L;

	private String routeBase = "/medida/";

	private MedidaController controller;
	private Medida medida;
	private List<Medida> medidaLista;

	/**
	 *
	 */
	public MedidaBean() {
		controller = new MedidaController();
		setMedida(new Medida());
	}

	public String listar() {
		setMedidaLista(controller.listar());

		return routeBase + "index";
	}

	public String incluir() {
	    FacesContext context = FacesContext.getCurrentInstance();
	    System.out.println("passou incluir medida.");
	    if(getMedida().getNome().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
	        return routeBase + "criar";
	    }

	    if(controller.incluir(getMedida())) {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Medida cadastrado com sucesso!", null));
	    } else {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Medida nao foi cadastrado!", null));
            return routeBase + "criar";
	    }

	    setMedida(new Medida());

	    return listar();
	}

	public String editar(Medida medida) {
		setMedida(medida);
		return routeBase + "editar";
	}

	public String editar() {
	    FacesContext context = FacesContext.getCurrentInstance();

	    if(getMedida().getNome().isEmpty()) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
	        return routeBase + "criar";
	    }

		if(controller.atualizar(getMedida())) {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Medida atualizado com sucesso!", null));
	    } else {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Medida nao foi atualizado.", null));
            return routeBase + "editar";
		}

		setMedida(new Medida());

	    return listar();
	}

	public String deletar(Medida medida) {
		setMedida(medida);
		return routeBase + "deletar";
	}

	public String deletar() {
	    FacesContext context = FacesContext.getCurrentInstance();

	    if(getMedida().getId() == -1) {
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Medida nao pode ser vazio!", null));
	        return routeBase + "criar";
	    }

		if(controller.remover(getMedida().getId())) {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Medida deletado com sucesso!", null));
	    } else {
	        context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Medida nao foi deletado.", null));
            return routeBase + "deletar";
		}

		setMedida(new Medida());

	    return listar();
	}

	/**
	 * @return the medida
	 */
	public Medida getMedida() {
		return medida;
	}

	/**
	 * @param medida the medida to set
	 */
	public void setMedida(Medida medida) {
		this.medida = medida;
	}

	/**
	 * @return the medidaLista
	 */
	public List<Medida> getMedidaLista() {
		return medidaLista;
	}

	/**
	 * @param medidaLista the medidaLista to set
	 */
	public void setMedidaLista(List<Medida> medidaLista) {
		this.medidaLista = medidaLista;
	}

}
