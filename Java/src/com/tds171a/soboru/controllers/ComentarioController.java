/**
 * 
 */
package com.tds171a.soboru.controllers;

import com.tds171a.soboru.models.comentario.ComentarioModel;
import com.tds171a.soboru.vos.Comentario;

/**
 * @author Diogo
 *
 */
public class ComentarioController extends ControllerBase<Comentario> {

	/**
	 * 
	 */
	public ComentarioController() {
		model = new ComentarioModel();
	}
}
