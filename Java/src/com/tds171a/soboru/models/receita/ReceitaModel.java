package com.tds171a.soboru.models.receita;

import java.util.List;

import com.tds171a.soboru.models.IDAO;
import com.tds171a.soboru.vos.Receita;

public class ReceitaModel implements IDAO<Receita> {
	
	/**
	 * Par�metro de DAO do medida
	 */
	private ReceitaDAO dao;
	
	/**
	 * Construtor da classe MedidaModel
	 */
	public ReceitaModel() {
		dao = new ReceitaDAO();
	}

	/**
	 * M�todo para incluir uma nova Medida
	 * @param ingrediente
	 * @return
	 */
	@Override
	public boolean incluir(Receita vo) {
		return dao.incluir(vo);
	}

	/**
	 * M�todo para trazer uma lista de todas as Medidas
	 * @return
	 */
	@Override
	public List<Receita> listar() {
		return dao.listar();
	}
	
	/**
	 * M�todo para atualizar uma Medida j� registrada
	 * @param ingrediente
	 * @return
	 */
	@Override
	public boolean atualizar(Receita vo) {
		return dao.atualizar(vo);
	}

	/**
	 * M�todo para remover uma Medida
	 * @param ingredienteId
	 * @return
	 */
	@Override
	public boolean remover(int voId) {
		return dao.remover(voId);
	}
}
