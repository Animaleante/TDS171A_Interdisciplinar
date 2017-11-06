/**
 * 
 */
package com.tds171a.soboru.controllers;

import com.tds171a.soboru.models.receita.ReceitaModel;
import com.tds171a.soboru.vos.Receita;

/**
 * @author Sony
 *
 */
public class ReceitaController extends ControllerBase<Receita>{

    /**
     * Construtor da classe de controller da Receita
     */
    public ReceitaController() {
        model = new ReceitaModel();
    }
}
