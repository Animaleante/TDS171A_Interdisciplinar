package com.tds171a.soboru.models.sexo;

import java.util.List;

import com.tds171a.soboru.models.IDAO;
import com.tds171a.soboru.vos.Sexo;

/**
 * Classe de Model do Sexo
 * @author Diogo
 *
 */
public class SexoModel implements IDAO<Sexo> {

    /**
     * Par�metro do DAO do INgrediente
     */
    private SexoDAO dao;

    /**
     * Construtor da classe SexoModel
     */
    public SexoModel() {
        dao = new SexoDAO();
    }

    /**
     * M�todo para incluir um novo Sexo
     * @param sexo
     * @return
     */
    @Override
    public boolean incluir(Sexo sexo) {
        return dao.incluir(sexo);
    }

    /**
     * M�todo para trazer uma lista de todos os Sexos
     * @return
     */
    @Override
    public List<Sexo> listar() {
        return dao.listar();
    }

    /**
     * M�todo para atualizar um Sexo j� registrado
     * @param sexo
     * @return
     */
    @Override
    public boolean atualizar(Sexo sexo) {
        return dao.atualizar(sexo);
    }

    /**
     * M�todo para remover um Sexo
     * @param sexoId
     * @return
     */
    @Override
    public boolean remover(int sexoId) {
        return dao.remover(sexoId);
    }
}
