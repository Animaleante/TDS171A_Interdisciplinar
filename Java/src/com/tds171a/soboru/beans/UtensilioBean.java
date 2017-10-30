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

import com.tds171a.soboru.controllers.UtensilioController;
import com.tds171a.soboru.vos.Utensilio;

@Named("utensilioBean")
@SessionScoped
/**
 * @author Sony
 *
 */
public class UtensilioBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1526925242084747984L;


    private String routeBase = "/utensilio/";

    private UtensilioController controller;
    private Utensilio utensilio;
    private List<Utensilio> utensilioLista;

    /**
     *
     */
    public UtensilioBean() {
        controller = new UtensilioController();
        setUtensilio(new Utensilio());
    }

    public String listar() {
        setUtensilioLista(controller.listar());

        return routeBase + "index";
    }

    public String incluir() {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("Passou incluir utensilio");
        if(getUtensilio().getNome().isEmpty()) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
            return routeBase + "criar";
        }

        if(controller.incluir(getUtensilio())) {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Utensilio cadastrado com sucesso!", null));
        } else {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Utensilio nao foi cadastrado!", null));
            return routeBase + "criar";
        }

        setUtensilio(new Utensilio());

        return listar();
    }

    public String editar(Utensilio utensilio) {
        setUtensilio(utensilio);
        return routeBase + "editar";
    }

    public String editar() {
        FacesContext context = FacesContext.getCurrentInstance();

        if(getUtensilio().getNome().isEmpty()) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
            return routeBase + "editar";
        }

        if(controller.atualizar(getUtensilio())) {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Utensilio atualizado com sucesso!", null));
        } else {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Utensilio nao foi atualizado.", null));
            return routeBase + "editar";
        }

        setUtensilio(new Utensilio());

        return listar();
    }

    public String deletar(Utensilio utensilio) {
        setUtensilio(utensilio);
        return routeBase + "deletar";
    }

    public String deletar() {
        FacesContext context = FacesContext.getCurrentInstance();

        if(getUtensilio().getId() == -1) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Utensilio nao pode ser vazio!", null));
            return routeBase + "criar";
        }

        if(controller.remover(getUtensilio().getId())) {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Utensilio deletado com sucesso!", null));
        } else {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Utensilio nao foi deletado.", null));
            return routeBase + "deletar";
        }

        setUtensilio(new Utensilio());

        return listar();
    }

    /**
     * @return the utensilio
     */
    public Utensilio getUtensilio() {
        return utensilio;
    }

    /**
     * @param utensilio the utensilio to set
     */
    public void setUtensilio(Utensilio utensilio) {
        this.utensilio = utensilio;
    }

    /**
     * @return the UtensilioLista
     */
    public List<Utensilio> getUtensilioLista() {
        return utensilioLista;
    }

    /**
     * @param utensilioLista the utensilioLista to set
     */
    public void setUtensilioLista(List<Utensilio> utensilioLista) {
        this.utensilioLista = utensilioLista;
    }

}
