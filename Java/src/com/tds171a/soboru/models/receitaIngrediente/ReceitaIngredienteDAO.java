/**
 * 
 */
package com.tds171a.soboru.models.receitaIngrediente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tds171a.soboru.models.IDAO;
import com.tds171a.soboru.utils.Utils;
import com.tds171a.soboru.vos.ReceitaIngrediente;

/**
 * @author Diogo
 *
 */
public class ReceitaIngredienteDAO implements IDAO<ReceitaIngrediente> {

    /**
     * Par�metro com nome da tabela referente a esse DAO
     */
    private String tableName = "receitas_ingredientes";

	@Override
	public boolean incluir(ReceitaIngrediente vo) {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("insert into "+tableName+" values(receita_seq.NEXTVAL, ?, ?, ?, ?, ?)");
            sttm.setInt(1, vo.getId_receita());
            sttm.setInt(2, vo.getId_ingrediente());
            sttm.setInt(3, vo.getId_medida());
            sttm.setString(4, vo.getSub_sessao());
            sttm.setDouble(5, vo.getQty());

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

	@Override
	public List<ReceitaIngrediente> listar() {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("select * from "+tableName);

            ResultSet rs = sttm.executeQuery();

            List<ReceitaIngrediente> list = new ArrayList<ReceitaIngrediente>();
            ReceitaIngrediente receitaIngrediente;
            while(rs.next()) {
            	receitaIngrediente = new ReceitaIngrediente();
            	receitaIngrediente.setId(rs.getInt("id"));
            	receitaIngrediente.setId_receita(rs.getInt("id_receita"));
            	receitaIngrediente.setId_ingrediente(rs.getInt("id_ingrediente"));
            	receitaIngrediente.setId_medida(rs.getInt("id_medida"));
            	receitaIngrediente.setSub_sessao(rs.getString("sub_sessao"));
            	receitaIngrediente.setQty(rs.getDouble("qty"));

                list.add(receitaIngrediente);
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

	@Override
	public boolean atualizar(ReceitaIngrediente vo) {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("update "+tableName+" set id_receita = ?, id_ingrediente = ?, id_medida = ?, sub_sessao = ?, qty = ? where id = ?");
            sttm.setInt(1, vo.getId_receita());
            sttm.setInt(2, vo.getId_ingrediente());
            sttm.setInt(3, vo.getId_medida());
            sttm.setString(4, vo.getSub_sessao());
            sttm.setDouble(5, vo.getQty());
            sttm.setInt(6, vo.getId());

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

	@Override
	public ReceitaIngrediente selecionar(int voId) {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("select * from "+tableName+" where id = ?");
            sttm.setInt(1, voId);

            ResultSet rs = sttm.executeQuery();

            ReceitaIngrediente receitaIngrediente = null;
            while(rs.next()) {
            	receitaIngrediente = new ReceitaIngrediente();
            	receitaIngrediente.setId(rs.getInt("id"));
            	receitaIngrediente.setId_receita(rs.getInt("id_receita"));
            	receitaIngrediente.setId_ingrediente(rs.getInt("id_ingrediente"));
            	receitaIngrediente.setId_medida(rs.getInt("id_medida"));
            	receitaIngrediente.setSub_sessao(rs.getString("sub_sessao"));
            	receitaIngrediente.setQty(rs.getDouble("qty"));
            }

            if (sttm != null)
                sttm.close();

            sttm = null;

            return receitaIngrediente;
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

	public List<ReceitaIngrediente> selecionarPorReceita(int receitaId) {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("select * from "+tableName+" where id_receita = ?");
            sttm.setInt(1, receitaId);

            ResultSet rs = sttm.executeQuery();

            List<ReceitaIngrediente> list = new ArrayList<ReceitaIngrediente>();
            ReceitaIngrediente receitaIngrediente;
            while(rs.next()) {
            	receitaIngrediente = new ReceitaIngrediente();
            	receitaIngrediente.setId(rs.getInt("id"));
            	receitaIngrediente.setId_receita(rs.getInt("id_receita"));
            	receitaIngrediente.setId_ingrediente(rs.getInt("id_ingrediente"));
            	receitaIngrediente.setId_medida(rs.getInt("id_medida"));
            	receitaIngrediente.setSub_sessao(rs.getString("sub_sessao"));
            	receitaIngrediente.setQty(rs.getDouble("qty"));

                list.add(receitaIngrediente);
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
