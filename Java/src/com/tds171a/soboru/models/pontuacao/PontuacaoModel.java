/**
 * 
 */
package com.tds171a.soboru.models.pontuacao;

import com.tds171a.soboru.models.ModelBase;
import com.tds171a.soboru.vos.Pontuacao;

/**
 * @author Diogo
 *
 */
public class PontuacaoModel extends ModelBase<Pontuacao> {
	
	/**
	 * 
	 */
	public PontuacaoModel() {
		dao = new PontuacaoDAO();
	}

}
