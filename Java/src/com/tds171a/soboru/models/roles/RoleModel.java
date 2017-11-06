/**
 * 
 */
package com.tds171a.soboru.models.roles;

import com.tds171a.soboru.models.ModelBase;
import com.tds171a.soboru.vos.Role;

/**
 * @author Diogo
 *
 */
public class RoleModel extends ModelBase<Role> {

    /**
     * Construtor da classe RoleModel
     */
    public RoleModel() {
        dao = new RoleDAO();
    }
}