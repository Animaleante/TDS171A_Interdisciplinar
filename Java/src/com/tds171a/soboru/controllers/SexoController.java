package com.tds171a.soboru.controllers;

import java.util.List;

import com.tds171a.soboru.models.sexo.SexoModel;
import com.tds171a.soboru.vos.Sexo;

/**
 * Classe de controller do Sexo
 * @author Diogo
 *
 */
public class SexoController {

    /**
     * Par�metro de model do Sexo
     */
    private SexoModel model;

    /**
     * Construtor da classe de controller do Sexo
     */
    public SexoController() {
        model = new SexoModel();
    }

    /**
     * M�todo para incluir um novo Sexo
     * @param sexo
     * @return
     */
    public boolean incluir(Sexo sexo) {
        return model.incluir(sexo);
    }

    /**
     * M�todo para trazer uma lista de todos os Sexos
     * @return
     */
    public List<Sexo> listar() {
        return model.listar();
    }

    /**
     * M�todo para atualizar um Sexo j� registrado
     * @param sexo
     * @return
     */
    public boolean atualizar(Sexo sexo) {
        return model.atualizar(sexo);
    }

    /**
     * M�todo para remover um Sexo
     * @param sexoId
     * @return
     */
    public boolean remover(int sexoId) {
        return model.remover(sexoId);
    }
}
