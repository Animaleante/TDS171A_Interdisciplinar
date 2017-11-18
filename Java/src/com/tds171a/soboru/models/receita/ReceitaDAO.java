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
import com.tds171a.soboru.vos.Tag;
import com.tds171a.soboru.vos.Utensilio;

/**
 * @author Sony
 *
 */
public class ReceitaDAO implements IDAO<Receita> {

	/**
	 * Parï¿½metro com nome da tabela referente a esse DAO
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
				"insert into "+tableName+"(ID, NOME, ID_CATEGORIA, ID_USUARIO, PORCAO, TEMPO_PREPARO, MODO_PREPARO, IMG_PATH, PONTUACAO_MEDIA, VIEWS, FAVS, SLUG, APROVADO) values(receita_seq.NEXTVAL, ?,?,?,?,?,?,?,?,?,?,?,?)");
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
			Receita receita = null;
			while(rs.next()) {
				receita = new Receita();

				receita.setId(rs.getInt("id"));
				receita.setNome(rs.getString("nome"));
				receita.setCategoriaId(rs.getInt("id_categoria"));
				receita.setUsuarioId(rs.getInt("id_usuario"));
				receita.setPorcao(rs.getInt("porcao"));
				receita.setTempoPreparo(rs.getDouble("tempo_preparo"));
				receita.setModoPreparo(rs.getString("modo_preparo"));
				receita.setImgPath(rs.getString("img_path"));
				receita.setPontuacaoMedia(rs.getDouble("pontuacao_media"));
				receita.setViews(rs.getInt("views"));
				receita.setFavs(rs.getInt("favs"));
				receita.setSlug(rs.getString("slug"));
				receita.setAprovado(rs.getBoolean("aprovado"));
				
				list.add(receita);
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
	 * Metodo para trazer uma Receita
	 * @return
	 */
	public Receita selecionar(int receitaId) {
		Connection connection = null;
		try {
			connection = Utils.createConnection();
			
			PreparedStatement sttm = connection.prepareStatement("select * from "+tableName+" where id = ?");
			sttm.setInt(1, receitaId);
			
			ResultSet rs = sttm.executeQuery();

			Receita receita = null;
			while(rs.next()) {
				receita = new Receita();

				receita.setId(rs.getInt("id"));
				receita.setNome(rs.getString("nome"));
				receita.setCategoriaId(rs.getInt("id_categoria"));
				receita.setUsuarioId(rs.getInt("id_usuario"));
				receita.setPorcao(rs.getInt("porcao"));
				receita.setTempoPreparo(rs.getDouble("tempo_preparo"));
				receita.setModoPreparo(rs.getString("modo_preparo"));
				receita.setImgPath(rs.getString("img_path"));
				receita.setPontuacaoMedia(rs.getDouble("pontuacao_media"));
				receita.setViews(rs.getInt("views"));
				receita.setFavs(rs.getInt("favs"));
				receita.setSlug(rs.getString("slug"));
				receita.setAprovado(rs.getBoolean("aprovado"));
			}

			if (sttm != null)
				sttm.close();

			sttm = null;

			return receita;
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

			PreparedStatement sttm = connection.prepareStatement("update "+tableName+" set NOME = ?, id_categoria = ?, id_usuario = ?, PORCAO = ?, TEMPO_PREPARO = ?, MODO_PREPARO = ?, IMG_PATH = ?, PONTUACAO_MEDIA = ?, VIEWS = ?, FAVS = ?, SLUG = ?, APROVADO = ? where id = ?");
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

	public boolean incluirTag(Receita receita, Tag tag) {
		Connection connection = null;
		try {
			connection = Utils.createConnection();

			PreparedStatement sttm = connection.prepareStatement(
				"insert into receitas_tags values(?,?)");
			sttm.setInt(1, receita.getId());
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

	public List<Utensilio> listarUtensilios(Receita receita) {
		Connection connection = null;
		try {
			connection = Utils.createConnection();

			PreparedStatement sttm = connection.prepareStatement("select u.id, u.nome from utensilios u inner join receitas_utensilios ru on ru.id_receita = ? and ru.id_utensilio = u.id");
			sttm.setInt(1, receita.getId());

			ResultSet rs = sttm.executeQuery();

			List<Utensilio> list = new ArrayList<Utensilio>();
			Utensilio utensilio = null;
			while(rs.next()) {
				utensilio = new Utensilio();

				utensilio.setId(rs.getInt("id"));
				utensilio.setNome(rs.getString("nome"));
				
				list.add(utensilio);
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

	public List<Receita> selecionarPorNome(String termoBusca) {
		Connection connection = null;
		try {
			connection = Utils.createConnection();
			
			PreparedStatement sttm = connection.prepareStatement(
					"select id, nome, img_path, pontuacao_media, favs, (select count(id) from comentarios group by id_receita having id_receita = a.id) comentarios from "+tableName+" a where lower(nome) like lower(?) and aprovado = 1");
			sttm.setString(1, "%"+termoBusca+"%");
			
			ResultSet rs = sttm.executeQuery();

			List<Receita> list = new ArrayList<Receita>();
			Receita receita;
			while(rs.next()) {
				receita = new Receita();

				receita.setId(rs.getInt("id"));
				receita.setNome(rs.getString("nome"));
//				receita.setCategoriaId(rs.getInt("id_categoria"));
//				receita.setUsuarioId(rs.getInt("id_usuario"));
//				receita.setPorcao(rs.getInt("porcao"));
//				receita.setTempoPreparo(rs.getDouble("tempo_preparo"));
//				receita.setModoPreparo(rs.getString("modo_preparo"));
				receita.setImgPath(rs.getString("img_path"));
				receita.setPontuacaoMedia(rs.getDouble("pontuacao_media"));
//				receita.setViews(rs.getInt("views"));
				receita.setFavs(rs.getInt("favs"));
//				receita.setSlug(rs.getString("slug"));
//				receita.setAprovado(rs.getBoolean("aprovado"));
				receita.setNumComentarios(rs.getInt("comentarios"));
				
				list.add(receita);
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

	public List<Receita> selecionarPorIngredientes(List<Integer> ingredientes) {
		Connection connection = null;
		try {
			connection = Utils.createConnection();
			
			String idsArray = "";
			for(int i = 0; i < ingredientes.size(); i++) {
				idsArray += "?,";
			}
			idsArray = idsArray.substring(0, idsArray.length()-1);
			
			PreparedStatement sttm = connection.prepareStatement(
					"select distinct r.id, r.nome, r.img_path, r.pontuacao_media, r.favs "
					+ "from "+tableName+" r inner join receitas_ingredientes ri on r.id = ri.id_receita where ri.id_ingrediente in ("+idsArray+") and r.aprovado = 1 ");
			
			int conta = 1;
			for(Integer i : ingredientes) {
				sttm.setInt(conta, i);
				conta++;
			}

			ResultSet rs = sttm.executeQuery();

			List<Receita> list = new ArrayList<Receita>();
			Receita receita;
			while(rs.next()) {
				receita = new Receita();

				receita.setId(rs.getInt("id"));
				receita.setNome(rs.getString("nome"));
//				receita.setCategoriaId(rs.getInt("id_categoria"));
//				receita.setUsuarioId(rs.getInt("id_usuario"));
//				receita.setPorcao(rs.getInt("porcao"));
//				receita.setTempoPreparo(rs.getDouble("tempo_preparo"));
//				receita.setModoPreparo(rs.getString("modo_preparo"));
				receita.setImgPath(rs.getString("img_path"));
				receita.setPontuacaoMedia(rs.getDouble("pontuacao_media"));
//				receita.setViews(rs.getInt("views"));
				receita.setFavs(rs.getInt("favs"));
//				receita.setSlug(rs.getString("slug"));
//				receita.setAprovado(rs.getBoolean("aprovado"));
				
				list.add(receita);
			}
			
			System.out.println("Size: " + list.size());

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

	public List<Receita> selecionarPorNomeEIngredientes(String termoBusca, List<Integer> ingredientes) {
		Connection connection = null;
		try {
			connection = Utils.createConnection();
			

			String idsArray = "";
			for(int i = 0; i < ingredientes.size(); i++) {
				idsArray += "?,";
			}
			idsArray = idsArray.substring(0, idsArray.length()-1);
			
			/*PreparedStatement sttm = connection.prepareStatement(
					"select distinct r.id, r.nome, r.id_categoria, r.id_usuario, r.porcao, r.tempo_preparo, r.modo_preparo, r.img_path, r.pontuacao_media, r.views, r.favs, r.slug, r.aprovado "
					+ "from "+tableName+" r inner join receitas_ingredientes ri on r.id = ri.id_receita where ri.id_ingrediente in (?) and lower(r.nome) like lower(?)");*/
			PreparedStatement sttm = connection.prepareStatement(
					"select distinct r.id, r.nome, r.img_path, r.pontuacao_media, r.favs "
					+ "from "+tableName+" r inner join receitas_ingredientes ri on r.id = ri.id_receita where ri.id_ingrediente in ("+idsArray+") and lower(r.nome) like lower(?) and r.aprovado = 1");

			int conta = 1;
			for(Integer i : ingredientes) {
				sttm.setInt(conta, i);
				conta++;
			}
			sttm.setString(conta, "%"+termoBusca+"%");

			ResultSet rs = sttm.executeQuery();

			List<Receita> list = new ArrayList<Receita>();
			Receita receita;
			while(rs.next()) {
				receita = new Receita();

				receita.setId(rs.getInt("id"));
				receita.setNome(rs.getString("nome"));
//				receita.setCategoriaId(rs.getInt("id_categoria"));
//				receita.setUsuarioId(rs.getInt("id_usuario"));
//				receita.setPorcao(rs.getInt("porcao"));
//				receita.setTempoPreparo(rs.getDouble("tempo_preparo"));
//				receita.setModoPreparo(rs.getString("modo_preparo"));
				receita.setImgPath(rs.getString("img_path"));
				receita.setPontuacaoMedia(rs.getDouble("pontuacao_media"));
//				receita.setViews(rs.getInt("views"));
				receita.setFavs(rs.getInt("favs"));
//				receita.setSlug(rs.getString("slug"));
//				receita.setAprovado(rs.getBoolean("aprovado"));
				
				list.add(receita);
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

	public void registrarUtensilios(int receitaId, List<Utensilio> lista) {
		Connection connection = null;
		try {
			connection = Utils.createConnection();
			
			PreparedStatement sttm = connection.prepareStatement("delete from receitas_utensilios where id_receita = ?");
			sttm.setInt(1, receitaId);

			sttm.executeUpdate();

			if (sttm != null)
				sttm.close();
			
			
			String query = "insert all ";

			for(Utensilio u : lista) {
				query += "into receitas_utensilios values (?, ?) ";
			}
			
			query += "select 1 from dual";
			
			sttm = connection.prepareStatement(query);
			int index = 1;
			for(Utensilio u : lista) {
				sttm.setInt(index++, receitaId);
				sttm.setInt(index++, u.getId());
			}

			int rowsAffected = sttm.executeUpdate();
			System.out.println("Linhas afetadas: " + rowsAffected);

			if (sttm != null)
				sttm.close();
			
			if(rowsAffected == 0) {
				throw new Exception("Não foi possivel cadastras todos os utensilios com essa receita.");
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
