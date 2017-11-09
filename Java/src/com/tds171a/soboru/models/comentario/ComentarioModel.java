/**
 * 
 */
package com.tds171a.soboru.models.comentario;

import com.tds171a.soboru.models.ModelBase;
import com.tds171a.soboru.vos.Comentario;

/**
 * @author Diogo
 *
 */
public class ComentarioModel extends ModelBase<Comentario> {
	
	/**
	 * 
	 */
	public ComentarioModel() {
		dao = new ComentarioDAO();
	}
}
