package br.com.mauro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
			String sql = "INSERT INTO revenda.tb_clientes(cd_cliente ,nm_cliente, rg_cliente, cpf_cliente, email_cliente, telefone_cliente, celular_cliente, cep_cliente," +
														" rua_cliente, numero_cliente, complemento_cliente, bairro_cliente, cidade_cliente, estado_cliente)  " +
			                                     " VALUES(seq_cliente.nextval,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
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
			
			JOptionPane.showInputDialog("Cadastro de " +cliente.getNome() +" realizado com sucesso.");
			
		}catch(Exception erro) {
			
			JOptionPane.showMessageDialog(null," Erro em Banco de dados: \n " + erro);
			
		}
		
	}
	
	public List<ClienteModel> ListaDeCliente() {
		try {
			
			List<ClienteModel> listaCliente = new ArrayList<>();
			
			String sql = "SELECT cd_cliente ,nm_cliente, rg_cliente, cpf_cliente, email_cliente, telefone_cliente, celular_cliente FROM revenda.tb_clientes";
			
			PreparedStatement acesso = conn.prepareStatement(sql);
			
			ResultSet rs = acesso.executeQuery();
			
			while(rs.next()) {
				ClienteModel cliente = new ClienteModel();
				
				cliente.setCodigo(rs.getInt("cd_cliente"));
				cliente.setNome(rs.getString("nm_cliente"));
				cliente.setRg(rs.getString("rg_cliente"));
				cliente.setCpf(rs.getString("cpf_cliente"));
				cliente.setEmail(rs.getString("email_cliente"));
				cliente.setTelefone(rs.getString("telefone_cliente"));
				cliente.setCelular(rs.getString("celular_cliente"));
				
				listaCliente.add(cliente);
								
			}
			
			return listaCliente;
		
			
		} catch (Exception erro) {

			JOptionPane.showMessageDialog(null," Erro em Banco de dados: \n " + erro);
			return null;
		}
	}
}
