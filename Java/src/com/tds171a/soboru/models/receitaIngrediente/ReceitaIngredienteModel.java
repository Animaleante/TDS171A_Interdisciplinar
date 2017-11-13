/**
 * 
 */
package com.tds171a.soboru.models.receitaIngrediente;

import java.util.List;

import com.tds171a.soboru.models.ModelBase;
import com.tds171a.soboru.vos.ReceitaIngrediente;

/**
 * @author Diogo
 *
 */
public class ReceitaIngredienteModel extends ModelBase<ReceitaIngrediente> {
	public ReceitaIngredienteModel() {
		dao = new ReceitaIngredienteDAO();
	}

	public List<ReceitaIngrediente> selecionarPorReceita(int receitaId) {
		return ((ReceitaIngredienteDAO) dao).selecionarPorReceita(receitaId);
	}
}
