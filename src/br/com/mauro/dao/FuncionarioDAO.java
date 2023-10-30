package br.com.mauro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.mauro.jdbc.ConnectionFactory;
import br.com.mauro.model.FuncionarioModel;
import br.com.mauro.view.IndexView;

/**
 * @author Mauro Degaspari
 * @Note Classe para execução
 * 		de CRUD da TABLE tb_funcionarios com banco de dados ORACLE 
 */
public class FuncionarioDAO {
	
	private Connection conn;
	
	public FuncionarioDAO(){
		this.conn = new ConnectionFactory().getConnection();
	}
	
	public void cadastroFuncionario(FuncionarioModel Funcionario) {

		
		try {
			String sql = "INSERT INTO revenda.tb_Funcionarios(cd_Funcionario ,nm_Funcionario, rg_Funcionario, cpf_Funcionario, email_Funcionario, sh_funcionario, cargo_funcionario,"
					+    "                                    nvl_funcionario, telefone_Funcionario, celular_Funcionario, cep_Funcionario," 
					+	 "                                    endereco_funcionario, numero_Funcionario, complemento_Funcionario, bairro_Funcionario, cidade_Funcionario, estado_Funcionario)  " 
			        +    "                             VALUES(seq_Funcionarios.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement acesso = conn.prepareStatement(sql);
			acesso.setString(1,Funcionario.getNome());
			acesso.setString(2,Funcionario.getRg());
			acesso.setString(3,Funcionario.getCpf());
			acesso.setString(4,Funcionario.getEmail()); 
			acesso.setString(5,Funcionario.getSenha());
			acesso.setString(6,Funcionario.getCargo());
			acesso.setString(7,Funcionario.getNivel());
			acesso.setString(8,Funcionario.getTelefone());
			acesso.setString(9,Funcionario.getCelular());
			acesso.setString(10,Funcionario.getCep());
			acesso.setString(11,Funcionario.getRua());
			acesso.setInt(12,Funcionario.getNumero());
			acesso.setString(13,Funcionario.getComplemento());
			acesso.setString(14,Funcionario.getBairro());
			acesso.setString(15,Funcionario.getCidade());
			acesso.setString(16,Funcionario.getUf());
			
			acesso.execute();
			acesso.close();
			
			JOptionPane.showInputDialog("Cadastro de " +Funcionario.getNome() +" realizado com sucesso.");
			
		}catch(Exception erro) {
			
			JOptionPane.showMessageDialog(null," Erro em Banco de dados: \n " + erro);
			
		}
		
	
	}
	
	public void LoginFuncionario(String senha, String email) {
		try {
			
			String sql = "SELECT *                         "
					+    "  FROM revenda.tb_funcionarios  "
					+    " WHERE nm_funcionario = ?        "
					+    "   AND sh_funcionario = ?        ";
			
			PreparedStatement acesso = conn.prepareStatement(sql);
			acesso.setString(1, email );
			acesso.setString(2, senha );
			
			ResultSet rs = acesso.executeQuery(); 
			
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "Bem Vindo: ");
				IndexView index = new IndexView();
				index.main(null);
				
			}else {
				JOptionPane.showMessageDialog(null, "Senha ou Email errado", sql, 0);
			}
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro no banco de dados" + erro);
		}
	}
}
