package com.tds171a.soboru.models.tag;

import java.util.List;

import com.tds171a.soboru.models.IDAO;
import com.tds171a.soboru.vos.Tag;

/**
 * Classe de Model do Tag
 * @author Diogo
 *
 */
public class TagModel implements IDAO<Tag> {

    /**
     * Par�metro do DAO do INgrediente
     */
    private TagDAO dao;

    /**
     * Construtor da classe TagModel
     */
    public TagModel() {
        dao = new TagDAO();
    }

    /**
     * M�todo para incluir um novo Tag
     * @param tag
     * @return
     */
    @Override
    public boolean incluir(Tag tag) {
        return dao.incluir(tag);
    }

    /**
     * M�todo para trazer uma lista de todos os Tags
     * @return
     */
    @Override
    public List<Tag> listar() {
        return dao.listar();
    }

    /**
     * M�todo para atualizar um Tag j� registrado
     * @param tag
     * @return
     */
    @Override
    public boolean atualizar(Tag tag) {
        return dao.atualizar(tag);
    }

    /**
     * M�todo para remover um Tag
     * @param tagId
     * @return
     */
    @Override
    public boolean remover(int tagId) {
        return dao.remover(tagId);
    }
}
