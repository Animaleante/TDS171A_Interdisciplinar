/**
 * 
 */
package com.tds171a.soboru.controllers;

import com.tds171a.soboru.models.roles.RoleModel;
import com.tds171a.soboru.vos.Role;

/**
 * Classe de controller dos perfis
 * de usuário
 * @author Palte
 *
 */
public class RoleController extends ControllerBase<Role> {
	
	/**
	 * Construtor que inicia a model.
	 */
	public RoleController() {
		model = new RoleModel();
	}
}
