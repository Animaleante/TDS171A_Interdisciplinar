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

import com.tds171a.soboru.controllers.CategoriaController;
import com.tds171a.soboru.vos.Categoria;

@Named("categoriaBean")
@SessionScoped
/**
 * @author Sony
 *
 */
public class CategoriaBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8410408634179869866L;

    private String routeBase = "/categoria/";

    private CategoriaController controller;
    private Categoria categoria;
    private List<Categoria> categoriaLista;

    /**
     *
     */
    public CategoriaBean() {
        controller = new CategoriaController();
        setCategoria(new Categoria());
    }

    public String listar() {
        setCategoriaLista(controller.listar());

        System.out.println("Tamanho lista: " + getCategoriaLista().size());

        return routeBase + "index";
    }

    public String incluir() {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("passou incluir categoria.");
        if(getCategoria().getNome().isEmpty()) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
            return routeBase + "criar";
        }

        if(controller.incluir(getCategoria())) {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Categoria cadastrado com sucesso!", null));
        } else {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Categoria nao foi cadastrado!", null));
            return routeBase + "criar";
        }

        setCategoria(new Categoria());

        return listar();
    }

    public String editar(Categoria categoria) {
        setCategoria(categoria);
        return routeBase + "editar";
    }

    public String editar() {
        FacesContext context = FacesContext.getCurrentInstance();

        if(getCategoria().getNome().isEmpty()) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
            return routeBase + "criar";
        }

        if(controller.atualizar(getCategoria())) {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Categoria atualizado com sucesso!", null));
        } else {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Categoria nao foi atualizado.", null));
            return routeBase + "editar";
        }

        setCategoria(new Categoria());

        return listar();
    }

    public String deletar(Categoria categoria) {
        setCategoria(categoria);
        return routeBase + "deletar";
    }

    public String deletar() {
        FacesContext context = FacesContext.getCurrentInstance();

        if(getCategoria().getId() == -1) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Categoria nao pode ser vazio!", null));
            return routeBase + "criar";
        }

        if(controller.remover(getCategoria().getId())) {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Categoria deletado com sucesso!", null));
        } else {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Categoria nao foi deletado.", null));
            return routeBase + "deletar";
        }

        setCategoria(new Categoria());

        return listar();
    }

    /**
     * @return the categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the categoriaLista
     */
    public List<Categoria> getCategoriaLista() {
        return categoriaLista;
    }

    /**
     * @param categoriaLista the categoriaLista to set
     */
    public void setCategoriaLista(List<Categoria> categoriaLista) {
        this.categoriaLista = categoriaLista;
    }

}
