package com.tds171a.soboru.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe Utils
 * @author Diogo
 *
 */
public class Utils {
	
	/**
	 * Método estático que cria uma conexão com o banco
	 * @return a conexão com o banco
	 */
	public static Connection createConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
			return null;
		}
		
		return DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "soboru", "opet");
	}
}
