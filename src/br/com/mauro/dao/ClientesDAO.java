package br.com.mauro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.mauro.jdbc.ConnectionFactory;
import br.com.mauro.model.ClienteModel;

/**
 * @author Mauro Degaspari
 * @Note Classe para execução
 * 		de CRUD com banco de dados ORACLE 
 */
public class ClientesDAO {

	private Connection conn;
	
	public ClientesDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}
	
	public void CadastrarCliente(ClienteModel cliente) {
		
		try {
			String sql = "INSERT INTO revenda.tb_clientes(nome, rg, cpf, email, telefone, celular, cep, rua, numero, complemento, bairro, cidade, UF)"+
												 " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement acesso = conn.prepareStatement(sql);
			acesso.setString(1,cliente.getNome());
			acesso.setString(2,cliente.getRg());
			acesso.setString(3,cliente.getCpf());
			acesso.setString(4,cliente.getEmail());
			acesso.setString(5,cliente.getTelefone());
			acesso.setString(6,cliente.getCelular());
			acesso.setString(7,cliente.getCep());
			acesso.setString(8,cliente.getRua());
			acesso.setInt(9,cliente.getNumero());
			acesso.setString(10,cliente.getComplemento());
			acesso.setString(11,cliente.getBairro());
			acesso.setString(12,cliente.getCidade());
			acesso.setString(13,cliente.getUf());
			
			acesso.execute();
			acesso.close();
			
		}catch(Exception erro) {
			
		}
		finally {
			
		}
		
		
	}
}
