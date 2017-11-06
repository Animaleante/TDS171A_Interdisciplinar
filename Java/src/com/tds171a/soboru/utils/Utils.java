package com.tds171a.soboru.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe Utils
 * @author Diogo
 *
 */
public class Utils {
	
	/**
	 * Metodo estatico que cria uma conexão com o banco
	 * @return a conexão com o banco
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static Connection createConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		return DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "soboru", "opet");
	}
	
	/**
	 * Metodo estatico que cria uma PreparedStatement depois de criar uma conexao
	 * @param query
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public static PreparedStatement prepareStatement(String query) throws SQLException, ClassNotFoundException {
		Connection c = createConnection();
		return (c != null ? c.prepareStatement(query) : null);
	}
	
	/**
	 * Metodo estatico para converter datas do objeto java.util.Date para String
	 * @param date
	 * @return
	 */
	public static String dateToOracleDate(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
}
