/**
 * 
 */
package com.tds171a.soboru.controllers;

import com.tds171a.soboru.models.comentario.ComentarioModel;
import com.tds171a.soboru.vos.Comentario;

/**
 * Classe de controller do Comentario
 * @author Diogo
 *
 */
public class ComentarioController extends ControllerBase<Comentario> {

	/**
     * Construtor da classe de controller do Comentario
     */
	public ComentarioController() {
		model = new ComentarioModel();
	}
}
