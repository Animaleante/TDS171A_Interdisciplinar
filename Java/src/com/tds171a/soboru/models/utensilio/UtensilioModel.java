package com.tds171a.soboru.models.utensilio;

import com.tds171a.soboru.models.ModelBase;
import com.tds171a.soboru.vos.Utensilio;

/**
 * Classe de MOdel do Utensilio
 * @author Diogo
 *
 */
public class UtensilioModel extends ModelBase<Utensilio> {

	/**
	 * Construtor da classe de controller do Utensilio
	 */
	public UtensilioModel() {
		dao = new UtensilioDAO();
	}
}
