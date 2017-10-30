package com.tds171a.soboru.controllers;

import java.util.List;

import com.tds171a.soboru.models.tag.TagModel;
import com.tds171a.soboru.vos.Tag;

/**
 * Classe de controller do Tag
 * @author Diogo
 *
 */
public class TagController {

    /**
     * Par�metro de model do Tag
     */
    private TagModel model;

    /**
     * Construtor da classe de controller do Tag
     */
    public TagController() {
        model = new TagModel();
    }

    /**
     * M�todo para incluir um novo Tag
     * @param tag
     * @return
     */
    public boolean incluir(Tag tag) {
        return model.incluir(tag);
    }

    /**
     * M�todo para trazer uma lista de todos os Tags
     * @return
     */
    public List<Tag> listar() {
        return model.listar();
    }

    /**
     * M�todo para atualizar um Tag j� registrado
     * @param tag
     * @return
     */
    public boolean atualizar(Tag tag) {
        return model.atualizar(tag);
    }

    /**
     * M�todo para remover um Tag
     * @param tagId
     * @return
     */
    public boolean remover(int tagId) {
        return model.remover(tagId);
    }
}
