package com.tds171a.soboru.models.tag;

import java.util.List;

import com.tds171a.soboru.models.ModelBase;
import com.tds171a.soboru.vos.Tag;

/**
 * Classe de Model do Tag
 * @author Diogo
 *
 */
public class TagModel extends ModelBase<Tag> {

    /**
     * Construtor da classe TagModel
     */
    public TagModel() {
        dao = new TagDAO();
    }

	public List<Tag> selecionarPorReceita(int receitaId) {
		return ((TagDAO) dao).selecionarPorReceita(receitaId);
	}
}
