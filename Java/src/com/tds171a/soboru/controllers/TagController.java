package com.tds171a.soboru.controllers;

import java.util.List;

import com.tds171a.soboru.models.tag.TagModel;
import com.tds171a.soboru.vos.Tag;

/**
 * Classe de controller do Tag
 * @author Diogo
 *
 */
public class TagController extends ControllerBase<Tag> {

    /**
     * Construtor da classe de controller do Tag
     */
    public TagController() {
        model = new TagModel();
    }

	public List<Tag> selecionarPorReceita(int receitaId) {
		return ((TagModel) model).selecionarPorReceita(receitaId);
	}
}
