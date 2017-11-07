/**
 * 
 */
package com.tds171a.soboru.models.receita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tds171a.soboru.models.IDAO;
import com.tds171a.soboru.utils.Utils;
import com.tds171a.soboru.vos.Receita;

/**
 * @author Sony
 *
 */
public class ReceitaDAO implements IDAO<Receita> {

	/**
	 * Par�metro com nome da tabela referente a esse DAO
	 */
	private String tableName = "receitas";

	/**
	 * Metodo para incluir uma nova Receita
	 * @param vo
	 * @return
	 */
	@Override
	public boolean incluir(Receita vo) {
		Connection connection = null;
		try {
			connection = Utils.createConnection();

			PreparedStatement sttm = connection.prepareStatement(
				"insert into "+tableName+"(ID, NOME, CATEGORIA_ID, USER_ID, PORCAO, TEMPO_PREPARO, MODO_PREPARO, IMG_PATH, PONTUACAO_MEDIA, VIEWS, FAVS, SLUG, APROVADO) values(receita_seq.NEXTVAL, ?,?,?,?,?,?,?,?,?,?,?,?)");
			sttm.setString(1, vo.getNome());
			sttm.setInt(2, vo.getCategoriaId());
			sttm.setInt(3, vo.getUsuarioId());
			sttm.setInt(4, vo.getPorcao());
			sttm.setDouble(5, vo.getTempoPreparo());
			sttm.setString(6, vo.getModoPreparo());
			sttm.setString(7, vo.getImgPath());
			sttm.setDouble(8, vo.getPontuacaoMedia());
			sttm.setInt(9, vo.getViews());
			sttm.setInt(10, vo.getFavs());
			sttm.setString(11, vo.getSlug());
			sttm.setBoolean(12, false);

			int rowsAffected = sttm.executeUpdate();

			if (sttm != null)
				sttm.close();

			sttm = null;

			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return false;
	}

	/**
	 * Metodo para trazer uma lista de todos as Receitas
	 * @return
	 */
	@Override
	public List<Receita> listar() {
		Connection connection = null;
		try {
			connection = Utils.createConnection();

			PreparedStatement sttm = connection.prepareStatement("select * from "+tableName);

			ResultSet rs = sttm.executeQuery();

			List<Receita> list = new ArrayList<Receita>();
			while(rs.next()) {
				list.add(new Receita(
						rs.getInt("id"), 
						rs.getString("nome"), 
						rs.getInt("categoria_id"),
						rs.getInt("user_id"),
						rs.getInt("porcao"),
						rs.getDouble("tempo_preparo"),
						rs.getString("modo_preparo"),
						rs.getString("img_path"),
						rs.getDouble("pontuacao_media"),
						rs.getInt("views"),
						rs.getInt("favs"),
						rs.getString("slug"),
						rs.getBoolean("aprovado")));
			}

			if (sttm != null)
				sttm.close();

			sttm = null;

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return null;
	}

	/**
	 * Metodo para atualizar uma Receita ja registrado
	 * @param ingrediente
	 * @return
	 */
	@Override
	public boolean atualizar(Receita vo) {
		Connection connection = null;
		try {
			connection = Utils.createConnection();

			PreparedStatement sttm = connection.prepareStatement("update "+tableName+" set NOME = ?, CATEGORIA_ID = ?, USER_ID = ?, PORCAO = ?, TEMPO_PREPARO = ?, MODO_PREPARO = ?, IMG_PATH = ?, PONTUACAO_MEDIA = ?, VIEWS = ?, FAVS = ?, SLUG = ?, APROVADO = ? where id = ?");
			sttm.setString(1, vo.getNome());
			sttm.setInt(2, vo.getCategoriaId());
			sttm.setInt(3, vo.getUsuarioId());
			sttm.setInt(4, vo.getPorcao());
			sttm.setDouble(5, vo.getTempoPreparo());
			sttm.setString(6, vo.getModoPreparo());
			sttm.setString(7, vo.getImgPath());
			sttm.setDouble(8, vo.getPontuacaoMedia());
			sttm.setInt(9, vo.getViews());
			sttm.setInt(10, vo.getFavs());
			sttm.setString(11, vo.getSlug());
			sttm.setBoolean(12, vo.getAprovado());
			sttm.setInt(13, vo.getId());

			int rowsAffected = sttm.executeUpdate();

			if (sttm != null)
				sttm.close();

			sttm = null;

			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return false;
	}

	/**
	 * Metodo para remover uma Receita
	 * @param voId
	 * @return
	 */
	@Override
	public boolean remover(int voId) {
		Connection connection = null;
		try {
			connection = Utils.createConnection();

			PreparedStatement sttm = connection.prepareStatement("delete from "+tableName+" where id = ?");
			sttm.setInt(1, voId);

			int rowsAffected = sttm.executeUpdate();

			if (sttm != null)
				sttm.close();

			sttm = null;

			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return false;
	}
}