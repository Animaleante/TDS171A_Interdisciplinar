/**
 * 
 */
package com.tds171a.soboru.models.comentario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tds171a.soboru.models.IDAO;
import com.tds171a.soboru.utils.Utils;
import com.tds171a.soboru.vos.Comentario;
import com.tds171a.soboru.vos.Usuario;

/**
 * @author Diogo
 *
 */
public class ComentarioDAO implements IDAO<Comentario> {
	
	private String tableName = "comentarios";

	@Override
	public boolean incluir(Comentario vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Comentario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean atualizar(Comentario vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remover(int voId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Comentario selecionar(int voId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Comentario> selecionarPorReceita(int receitaId) {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("select c.id, c.id_receita, c.id_usuario, c.body, u.nome from "+tableName+" c inner join usuarios u on c.id_usuario = u.id where c.id_receita = ?");
//            PreparedStatement sttm = connection.prepareStatement("select c.id, c.id_receita, c.id_usuario, c.body, c.created_at, u.nome, u.avatar_path from "+tableName+" c inner join usuarios u on c.id_usuario = u.id where c.id_receita = ?");
            sttm.setInt(1, receitaId);
            
            ResultSet rs = sttm.executeQuery();

            List<Comentario> list = new ArrayList<Comentario>();
            Comentario comentario;
            while(rs.next()) {
            	comentario = new Comentario();
            	comentario.setId(rs.getInt("id"));
            	comentario.setReceitaId(rs.getInt("id_receita"));
            	comentario.setUsuarioId(rs.getInt("id_usuario"));
            	comentario.setBody(rs.getString("body"));
            	
            	comentario.setUsuario(new Usuario());
            	comentario.getUsuario().setId(rs.getInt("id_usuario"));
            	comentario.getUsuario().setNome(rs.getString("nome"));

                list.add(comentario);
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

}
