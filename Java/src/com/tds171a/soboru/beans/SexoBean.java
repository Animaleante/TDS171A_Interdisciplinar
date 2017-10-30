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

import com.tds171a.soboru.controllers.SexoController;
import com.tds171a.soboru.vos.Sexo;

@Named("sexoBean")
@SessionScoped
/**
 * @author Sony
 *
 */
public class SexoBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8410408634179869866L;

    private String routeBase = "/sexo/";

    private SexoController controller;
    private Sexo sexo;
    private List<Sexo> sexoLista;

    /**
     *
     */
    public SexoBean() {
        controller = new SexoController();
        setSexo(new Sexo());
    }

    public String listar() {
        setSexoLista(controller.listar());

        System.out.println("Tamanho lista: " + getSexoLista().size());

        return routeBase + "index";
    }

    public String incluir() {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("passou incluir sexo.");
        if(getSexo().getNome().isEmpty()) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
            return routeBase + "criar";
        }

        if(controller.incluir(getSexo())) {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Sexo cadastrado com sucesso!", null));
        } else {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sexo nao foi cadastrado!", null));
            return routeBase + "criar";
        }

        setSexo(new Sexo());

        return listar();
    }

    public String editar(Sexo sexo) {
        setSexo(sexo);
        return routeBase + "editar";
    }

    public String editar() {
        FacesContext context = FacesContext.getCurrentInstance();

        if(getSexo().getNome().isEmpty()) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nome nao pode ser vazio!", null));
            return routeBase + "criar";
        }

        if(controller.atualizar(getSexo())) {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Sexo atualizado com sucesso!", null));
        } else {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sexo nao foi atualizado.", null));
            return routeBase + "editar";
        }

        setSexo(new Sexo());

        return listar();
    }

    public String deletar(Sexo sexo) {
        setSexo(sexo);
        return routeBase + "deletar";
    }

    public String deletar() {
        FacesContext context = FacesContext.getCurrentInstance();

        if(getSexo().getId() == -1) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sexo nao pode ser vazio!", null));
            return routeBase + "criar";
        }

        if(controller.remover(getSexo().getId())) {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_INFO, "Sexo deletado com sucesso!", null));
        } else {
            context.addMessage(null,  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sexo nao foi deletado.", null));
            return routeBase + "deletar";
        }

        setSexo(new Sexo());

        return listar();
    }

    /**
     * @return the sexo
     */
    public Sexo getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the sexoLista
     */
    public List<Sexo> getSexoLista() {
        return sexoLista;
    }

    /**
     * @param sexoLista the sexoLista to set
     */
    public void setSexoLista(List<Sexo> sexoLista) {
        this.sexoLista = sexoLista;
    }

}
