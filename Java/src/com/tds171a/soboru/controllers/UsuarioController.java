package com.tds171a.soboru.controllers;

import com.tds171a.soboru.models.usuario.UsuarioModel;
import com.tds171a.soboru.vos.Usuario;

/**
 * 
 * @author Diogo
 *
 */
public class UsuarioController extends ControllerBase<Usuario> {
	
	public UsuarioController() {
		model = new UsuarioModel();
	}
}
