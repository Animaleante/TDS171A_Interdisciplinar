package com.tds171a.soboru.models.utensilio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tds171a.soboru.models.IDAO;
import com.tds171a.soboru.utils.Utils;
import com.tds171a.soboru.vos.Utensilio;

/**
 * Classe de DAO do Utensilio
 * @author Diogo
 *
 */
public class UtensilioDAO implements IDAO<Utensilio> {

	/**
	 * Parâmetro com nome da tabela referente a esse DAO
	 */
	private String tableName = "utensilios";

	/**
	 * Método para incluir um novo Utensilio
	 * @param ingrediente
	 * @return
	 */
	@Override
	public boolean incluir(Utensilio utensilio) {
		Connection connection = null;
		try {
			connection = Utils.createConnection();

			PreparedStatement sttm = connection.prepareStatement("insert into "+tableName+" values(utensilios_seq.NEXTVAL, ?)");
			sttm.setString(1, utensilio.getNome());

			int rowsAffected = sttm.executeUpdate();
			
			if (sttm != null)
				sttm.close();

			sttm = null;

			return rowsAffected > 0;
		} catch (SQLException e) {
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
	 * Método para trazer uma lista de todos os Utensilios
	 * @return
	 */
	@Override
	public List<Utensilio> listar() {
		Connection connection = null;
		try {
			connection = Utils.createConnection();

			PreparedStatement sttm = connection.prepareStatement("select * from "+tableName);

			ResultSet rs = sttm.executeQuery();

			List<Utensilio> list = new ArrayList<Utensilio>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				
				Utensilio u = new Utensilio(id, nome);
				
				list.add(u);
			}
			
			if (sttm != null)
				sttm.close();

			sttm = null;

			return list;
		} catch (SQLException Except) {
			Except.printStackTrace();
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
	 * Método para atualizar um Utensilio já registrado
	 * @param ingrediente
	 * @return
	 */
	@Override
	public boolean atualizar(Utensilio utensilio) {
		Connection connection = null;
		try {
			connection = Utils.createConnection();

			PreparedStatement sttm = connection.prepareStatement("update "+tableName+" set nome = ? where id = ?");
			sttm.setString(1, utensilio.getNome());
			sttm.setInt(2, utensilio.getId());

			int rowsAffected = sttm.executeUpdate();
			
			if (sttm != null)
				sttm.close();

			sttm = null;

			return rowsAffected > 0;
		} catch (SQLException e) {
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
	 * Método para remover um Utensilio
	 * @param ingredienteId
	 * @return
	 */
	@Override
	public boolean remover(int utensilioId) {
		Connection connection = null;
		try {
			connection = Utils.createConnection();

			PreparedStatement sttm = connection.prepareStatement("delete from "+tableName+" where id = ?");
			sttm.setInt(1, utensilioId);

			int rowsAffected = sttm.executeUpdate();
			
			if (sttm != null)
				sttm.close();

			sttm = null;

			return rowsAffected > 0;
		} catch (SQLException e) {
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
