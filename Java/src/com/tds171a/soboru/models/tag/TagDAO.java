package com.tds171a.soboru.models.tag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tds171a.soboru.models.IDAO;
import com.tds171a.soboru.utils.Utils;
import com.tds171a.soboru.vos.Tag;

/**
 * Classe de DAO do Tag
 * @author Diogo
 *
 */
public class TagDAO implements IDAO<Tag> {

    /**
     * Par�metro com nome da tabela referente a esse DAO
     */
    private String tableName = "tags";

    /**
     * M�todo para incluir um novo Tag
     * @param tag
     * @return
     */
    @Override
    public boolean incluir(Tag tag) {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("insert into "+tableName+" (id, nome) values(tag_seq.NEXTVAL, ?)");
            sttm.setString(1, tag.getNome());

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
     * M�todo para trazer uma lista de todos os Tags
     * @return
     */
    @Override
    public List<Tag> listar() {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("select * from "+tableName);

            ResultSet rs = sttm.executeQuery();

            List<Tag> list = new ArrayList<Tag>();
            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");

                Tag i = new Tag(id, nome);

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
     * M�todo para atualizar um Tag j� registrado
     * @param tag
     * @return
     */
    @Override
    public boolean atualizar(Tag tag) {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("update "+tableName+" set nome = ? where id = ?");
            sttm.setString(1, tag.getNome());
            sttm.setInt(2, tag.getId());

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
     * M�todo para remover um Tag
     * @param tagId
     * @return
     */
    @Override
    public boolean remover(int tagId) {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("delete from "+tableName+" where id = ?");
            sttm.setInt(1, tagId);

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
     * 
     */
	@Override
	public Tag selecionar(int voId) {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("select * from "+tableName+" where id = ?");
            sttm.setInt(1, voId);

            ResultSet rs = sttm.executeQuery();

            Tag tag = null;
            while(rs.next()) {
                tag = new Tag();
                tag.setId(rs.getInt("id"));
                tag.setNome(rs.getString("nome"));
            }

            if (sttm != null)
                sttm.close();

            sttm = null;

            return tag;
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
	 * 
	 * @param receitaId
	 * @return
	 */
	public List<Tag> selecionarPorReceita(int receitaId) {
        Connection connection = null;
        try {
            connection = Utils.createConnection();

            PreparedStatement sttm = connection.prepareStatement("select t.id, t.nome from "+tableName+" t inner join receitas_tags rt on rt.id_receita = ?");
            sttm.setInt(1, receitaId);

            ResultSet rs = sttm.executeQuery();

            List<Tag> list = new ArrayList<Tag>();
            Tag tag;
            while(rs.next()) {
            	tag = new Tag();
            	tag.setId(rs.getInt("id"));
            	tag.setNome(rs.getString("nome"));

                list.add(tag);
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
