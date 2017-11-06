package com.tds171a.soboru.models.sexo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tds171a.soboru.models.IDAO;
import com.tds171a.soboru.utils.Utils;
import com.tds171a.soboru.vos.Sexo;

/**
 * Classe de DAO do Sexo
 * @author Diogo
 *
 */
public class SexoDAO implements IDAO<Sexo> {

    /**
     * Par�metro com nome da tabela referente a esse DAO
     */
    private String tableName = "sexos";

    /**
     * M�todo para incluir um novo Sexo
     * @param sexo
     * @return
     */
    @Override
    public boolean incluir(Sexo sexo) {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("insert into "+tableName+" (id, nome) values(sexo_seq.NEXTVAL, ?)");
            sttm.setString(1, sexo.getNome());

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
     * M�todo para trazer uma lista de todos os Sexos
     * @return
     */
    @Override
    public List<Sexo> listar() {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("select * from "+tableName);

            ResultSet rs = sttm.executeQuery();

            List<Sexo> list = new ArrayList<Sexo>();
            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");

                Sexo i = new Sexo(id, nome);

                list.add(i);
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
     * M�todo para atualizar um Sexo j� registrado
     * @param sexo
     * @return
     */
    @Override
    public boolean atualizar(Sexo sexo) {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("update "+tableName+" set nome = ? where id = ?");
            sttm.setString(1, sexo.getNome());
            sttm.setInt(2, sexo.getId());

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
     * M�todo para remover um Sexo
     * @param sexoId
     * @return
     */
    @Override
    public boolean remover(int sexoId) {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("delete from "+tableName+" where id = ?");
            sttm.setInt(1, sexoId);

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
