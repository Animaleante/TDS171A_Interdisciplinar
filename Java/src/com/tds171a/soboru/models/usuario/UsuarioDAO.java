/**
 * 
 */
package com.tds171a.soboru.models.usuario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tds171a.soboru.models.IDAO;
import com.tds171a.soboru.utils.Utils;
import com.tds171a.soboru.vos.Usuario;

/**
 * @author Diogo
 *
 */
public class UsuarioDAO implements IDAO<Usuario> {
	/**
	 * Parametro com nome da tabela referente a esse DAO
	 */
	private String tableName = "usuarios";

	/**
	 * Metodo para incluir um novo Ingrediente
	 * @param usuario
	 * @return
	 */
	@Override
	public boolean incluir(Usuario usuario) {
		Connection connection = null;
		try {
			connection = Utils.createConnection();

			PreparedStatement sttm = connection.prepareStatement(
					"insert into "+tableName+" (id, nome, email, senha, nasc, sexo, id_role, notificacao_email) values(usuario_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)");
			sttm.setString(1, usuario.getNome());
			sttm.setString(2, usuario.getEmail());
			sttm.setString(3, usuario.getSenha());
			sttm.setDate(4, Date.valueOf(Utils.dateToOracleDate(usuario.getNasc())));
			sttm.setInt(5, usuario.getSexo());
			sttm.setInt(6, usuario.getRoleId());
			sttm.setBoolean(7, usuario.isNotificacaoEmail());

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
	 * Metodo para trazer uma lista de todos os Usuarios
	 * @return
	 */
	@Override
	public List<Usuario> listar() {
		Connection connection = null;
		try {
			connection = Utils.createConnection();

//			PreparedStatement sttm = connection.prepareStatement("select * from "+tableName);
			PreparedStatement sttm = connection.prepareStatement(
					"select u.id, u.nome, u.email, u.senha, u.nasc, u.sexo, u.id_role, u.notificacao_email, r.nome tipo from "+tableName+" u inner join roles r on u.id_role = r.id");

			ResultSet rs = sttm.executeQuery();

			List<Usuario> list = new ArrayList<Usuario>();
			Usuario usuario = null;
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNasc(rs.getDate("nasc"));
				usuario.setSexo(rs.getInt("sexo"));
				usuario.setRoleId(rs.getInt("id_role"));
				usuario.setNotificacaoEmail(rs.getBoolean("notificacao_email"));
				usuario.setTipo(rs.getString("tipo"));

				list.add(usuario);
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
	 * Metodo para atualizar um Usuario ja registrado
	 * @param usuario
	 * @return
	 */
	@Override
	public boolean atualizar(Usuario usuario) {
		Connection connection = null;
		try {
			connection = Utils.createConnection();

			PreparedStatement sttm = connection.prepareStatement(
					"update "+tableName+" set nome = ?, set email = ?, set senha = ?, set nasc = ?, set sexo = ?, set id_role = ?, set notificacao_email = ? where id = ?");
			sttm.setString(1, usuario.getNome());
			sttm.setString(2, usuario.getEmail());
			sttm.setString(3, usuario.getSenha());
			sttm.setDate(4, Date.valueOf(Utils.dateToOracleDate(usuario.getNasc())));
			sttm.setInt(5, usuario.getSexo());
			sttm.setInt(6, usuario.getRoleId());
			sttm.setBoolean(7, usuario.isNotificacaoEmail());
			sttm.setInt(8, usuario.getId());

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
	 * Metodo para remover um Usuario
	 * @param usuarioId
	 * @return
	 */
	@Override
	public boolean remover(int usuarioId) {
		Connection connection = null;
		try {
			connection = Utils.createConnection();

			PreparedStatement sttm = connection.prepareStatement("delete from "+tableName+" where id = ?");
			sttm.setInt(1, usuarioId);

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

	public Usuario loginUsuario(String email, String senha) {
		Connection connection = null;
		try {
			connection = Utils.createConnection();

//			PreparedStatement sttm = connection.prepareStatement("select * from "+tableName);
			PreparedStatement sttm = connection.prepareStatement(
					"select u.id, u.nome, u.email, u.senha, u.nasc, u.sexo, u.id_role, u.notificacao_email, r.nome tipo from "+tableName+" u inner join roles r on u.id_role = r.id where u.email = ? and u.senha = ?");
			sttm.setString(1, email);
			sttm.setString(2, senha);

			ResultSet rs = sttm.executeQuery();
			Usuario usuario = null;
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setNasc(rs.getDate("nasc"));
				usuario.setSexo(rs.getInt("sexo"));
				usuario.setRoleId(rs.getInt("id_role"));
				usuario.setNotificacaoEmail(rs.getBoolean("notificacao_email"));
				usuario.setTipo(rs.getString("tipo"));
			}

			if (sttm != null)
				sttm.close();

			sttm = null;

			return usuario;
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
}
