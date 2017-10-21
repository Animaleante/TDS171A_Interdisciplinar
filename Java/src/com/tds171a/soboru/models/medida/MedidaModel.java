package com.tds171a.soboru.models.medida;

import java.util.List;

import com.tds171a.soboru.models.IDAO;
import com.tds171a.soboru.vos.Medida;

/**
 * Classe de Model da Medida
 * @author Diogo
 *
 */
public class MedidaModel implements IDAO<Medida> {
	
	/**
	 * Parâmetro de DAO do medida
	 */
	private MedidaDAO dao;
	
	/**
	 * Construtor da classe MedidaModel
	 */
	public MedidaModel() {
		dao = new MedidaDAO();
	}

	/**
	 * Método para incluir uma nova Medida
	 * @param ingrediente
	 * @return
	 */
	@Override
	public boolean incluir(Medida medida) {
		return dao.incluir(medida);
	}

	/**
	 * Método para trazer uma lista de todas as Medidas
	 * @return
	 */
	@Override
	public List<Medida> listar() {
		return dao.listar();
	}
	
	/**
	 * Método para atualizar uma Medida já registrada
	 * @param ingrediente
	 * @return
	 */
	@Override
	public boolean atualizar(Medida medida) {
		return dao.atualizar(medida);
	}

	/**
	 * Método para remover uma Medida
	 * @param ingredienteId
	 * @return
	 */
	@Override
	public boolean remover(int medidaId) {
		return dao.remover(medidaId);
	}
}
