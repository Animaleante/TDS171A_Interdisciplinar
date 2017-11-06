/**
 * 
 */
package com.tds171a.soboru.controllers;

import com.tds171a.soboru.models.roles.RoleModel;
import com.tds171a.soboru.vos.Role;

/**
 * @author Diogo
 *
 */
public class RoleController extends ControllerBase<Role> {
	public RoleController() {
		model = new RoleModel();
	}
}
