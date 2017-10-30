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

import com.tds171a.soboru.controllers.TagController;
import com.tds171a.soboru.vos.Tag;

@Named("tagBean")
@SessionScoped
/**
 * @author Sony
 *
 */
public class TagBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8410408634179869866L;

    private String routeBase = "/tag/";

    private TagController controller;
    private Tag tag;
    private List<Tag> tagLista;

    /**
     *
     */
    public TagBean() {
        controller = new TagController();
        setTag(new Tag());
    }

    public String listar() {
        setTagLista(controller.listar());

        System.out.println("Tamanho lista: " + getTagLista().size());

        return routeBase + "index";
    }

    public String incluir() {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("passou incluir tag.");
        if(getTag().getNome().isEmpty()) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
            return routeBase + "criar";
        }

        if(controller.incluir(getTag())) {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Tag cadastrado com sucesso!", null));
        } else {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tag nao foi cadastrado!", null));
            return routeBase + "criar";
        }

        setTag(new Tag());

        return listar();
    }

    public String editar(Tag tag) {
        setTag(tag);
        return routeBase + "editar";
    }

    public String editar() {
        FacesContext context = FacesContext.getCurrentInstance();

        if(getTag().getNome().isEmpty()) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
            return routeBase + "criar";
        }

        if(controller.atualizar(getTag())) {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Tag atualizado com sucesso!", null));
        } else {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tag nao foi atualizado.", null));
            return routeBase + "editar";
        }

        setTag(new Tag());

        return listar();
    }

    public String deletar(Tag tag) {
        setTag(tag);
        return routeBase + "deletar";
    }

    public String deletar() {
        FacesContext context = FacesContext.getCurrentInstance();

        if(getTag().getId() == -1) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tag nao pode ser vazio!", null));
            return routeBase + "criar";
        }

        if(controller.remover(getTag().getId())) {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Tag deletado com sucesso!", null));
        } else {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tag nao foi deletado.", null));
            return routeBase + "deletar";
        }

        setTag(new Tag());

        return listar();
    }

    /**
     * @return the tag
     */
    public Tag getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(Tag tag) {
        this.tag = tag;
    }

    /**
     * @return the tagLista
     */
    public List<Tag> getTagLista() {
        return tagLista;
    }

    /**
     * @param tagLista the tagLista to set
     */
    public void setTagLista(List<Tag> tagLista) {
        this.tagLista = tagLista;
    }

}
