package com.tds171a.soboru.models.tag;

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
}
