/**
 * 
 */
package com.tds171a.soboru.models.roles;

import com.tds171a.soboru.models.ModelBase;
import com.tds171a.soboru.vos.Role;

/**
 * Model que ir� trabalhar com os
 * perfis de usu�rios 
 * @author luiz.palte
 *
 */
public class RoleModel extends ModelBase<Role> {

    /**
     * Construtor da classe iniciando
     * a DAO.
     */
    public RoleModel() {
        dao = new RoleDAO();
    }
}