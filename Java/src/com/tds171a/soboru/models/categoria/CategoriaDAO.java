package com.tds171a.soboru.models.categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tds171a.soboru.models.IDAO;
import com.tds171a.soboru.utils.Utils;
import com.tds171a.soboru.vos.Categoria;

/**
 * Classe de DAO do Categoria
 * @author Diogo
 *
 */
public class CategoriaDAO implements IDAO<Categoria> {

    /**
     * Par�metro com nome da tabela referente a esse DAO
     */
    private String tableName = "categorias";

    /**
     * Metodo para incluir um novo Categoria
     * @param categoria
     * @return
     */
    @Override
    public boolean incluir(Categoria categoria) {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("insert into "+tableName+" (id, nome) values(categoria_seq.NEXTVAL, ?)");
            sttm.setString(1, categoria.getNome());

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
     * Metodo para trazer uma lista de todos os Categorias
     * @return
     */
    @Override
    public List<Categoria> listar() {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("select * from "+tableName);

            ResultSet rs = sttm.executeQuery();

            List<Categoria> list = new ArrayList<Categoria>();
            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");

                Categoria i = new Categoria(id, nome);

                list.add(i);
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
     * Metodo para atualizar um Categoria j� registrado
     * @param categoria
     * @return
     */
    @Override
    public boolean atualizar(Categoria categoria) {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("update "+tableName+" set nome = ? where id = ?");
            sttm.setString(1, categoria.getNome());
            sttm.setInt(2, categoria.getId());

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
     * Metodo para remover um Categoria
     * @param categoriaId
     * @return
     */
    @Override
    public boolean remover(int categoriaId) {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("delete from "+tableName+" where id = ?");
            sttm.setInt(1, categoriaId);

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
