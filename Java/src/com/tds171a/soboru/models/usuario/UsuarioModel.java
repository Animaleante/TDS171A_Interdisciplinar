/**
 * 
 */
package com.tds171a.soboru.models.usuario;

import com.tds171a.soboru.models.ModelBase;
import com.tds171a.soboru.vos.Usuario;

/**
 * @author Diogo
 *
 */
public class UsuarioModel extends ModelBase<Usuario> {

    /**
     * Construtor da classe UsuarioModel
     */
    public UsuarioModel() {
        dao = new UsuarioDAO();
    }
}
