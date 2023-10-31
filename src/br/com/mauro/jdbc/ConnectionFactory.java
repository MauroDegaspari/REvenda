package br.com.mauro.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import br.com.mauro.model.ClienteModel;

/**
 * @author Mauro Degaspari
 * @since 24/10/2023
 * @implNote Conexão com o bando de dados Oracle no owner REVENDA
 * @see  https://www.oracle.com/br/database/technologies/appdev/jdbc.html		
 *
 */
public class ConnectionFactory {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","revenda","123");
			
		}catch(Exception erro){
			throw new RuntimeException(erro); 
		}finally {
			
		}
	}
}
