package br.com.mauro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.mauro.jdbc.ConnectionFactory;
import br.com.mauro.model.FuncionarioModel;
import br.com.mauro.view.IndexView;
import br.com.mauro.view.LoginView;

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
	
	public List<FuncionarioModel> ListarFuncionarios() {
		try {
			
			List<FuncionarioModel> listaFuncionario = new ArrayList<>();
			
			String sql = "SELECT cd_funcionario ,nm_funcionario, rg_funcionario, cpf_funcionario, email_funcionario, sh_funcionario, cargo_funcionario, "
					+ "       nvl_funcionario,telefone_funcionario, celular_funcionario, cep_funcionario, endereco_funcionario, numero_funcionario, complemento_funcionario, "
					+ "       bairro_funcionario, cidade_funcionario, estado_funcionario "
					+ "  FROM revenda.tb_funcionarios "
					+ " ORDER BY 1 ASC ";
			
			PreparedStatement acesso = conn.prepareStatement(sql);
			
			ResultSet rs = acesso.executeQuery();
			
			while(rs.next()) {
				FuncionarioModel func = new FuncionarioModel();
				
				func.setCodigo(rs.getInt("cd_funcionario"));
				func.setNome(rs.getString("nm_funcionario"));
				func.setRg(rs.getString("rg_funcionario"));
				func.setCpf(rs.getString("cpf_funcionario"));
				func.setEmail(rs.getString("email_funcionario"));
				func.setSenha(rs.getString("sh_funcionario"));
				func.setCargo(rs.getString("cargo_funcionario"));
				func.setNivel(rs.getString("nvl_funcionario"));
				func.setTelefone(rs.getString("telefone_funcionario"));
				func.setCelular(rs.getString("celular_funcionario"));
				func.setCep(rs.getString("cep_funcionario"));
				func.setRua(rs.getString("endereco_funcionario"));
				func.setNumero(rs.getInt("numero_funcionario"));
				func.setComplemento(rs.getString("complemento_funcionario"));
				func.setBairro(rs.getString("bairro_funcionario"));
				func.setCidade(rs.getString("cidade_funcionario"));
				func.setUf(rs.getString("estado_funcionario"));
				
				listaFuncionario.add(func);
								
			}
			
			return listaFuncionario;
		
			
		} catch (Exception erro) {

			JOptionPane.showMessageDialog(null," Erro em Banco de dados: \n " + erro);
			return null;
		}
	}
	
	public List<FuncionarioModel> PesquisaFuncionarioNome(String nome){
		
		try {
			
			List<FuncionarioModel> listaFuncionario = new ArrayList();
			
			String sql = " SELECT * FROM revenda.tb_funcionarios WHERE nm_funcionario LIKE ?";
			
			PreparedStatement acesso = conn.prepareStatement(sql);
			acesso.setString(1, nome);
			
			ResultSet rs = acesso.executeQuery();
			
			while(rs.next()) {
				FuncionarioModel func = new FuncionarioModel();
				
				func.setCodigo(rs.getInt("cd_funcionario"));
				func.setNome(rs.getString("nm_funcionario"));
				func.setRg(rs.getString("rg_funcionario"));
				func.setCpf(rs.getString("cpf_funcionario"));
				func.setEmail(rs.getString("email_funcionario"));
				func.setSenha(rs.getString("sn_funcionario"));
				func.setCargo(rs.getString("cargo_funcionario"));
				func.setNivel(rs.getString("nvl_funcionario"));
				func.setTelefone(rs.getString("telefone_funcionario"));
				func.setCelular(rs.getString("celular_funcionario"));
				func.setCep(rs.getString("cep_funcionario"));
				func.setRua(rs.getString("endereco_funcionario"));
				func.setNumero(rs.getInt("numero_funcionario"));
				func.setComplemento(rs.getString("complemento_funcionario"));
				func.setBairro(rs.getString("bairro_funcionario"));
				func.setCidade(rs.getString("cidade_funcionario"));
				func.setUf(rs.getString("estado_funcionario"));
				
				listaFuncionario.add(func);
			}
			
			return listaFuncionario;
			
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null," Erro em Banco de dados: \n " + erro);
			return null;
		}
		
	}
	
	public void LoginFuncionario(String email, String senha ) {
		try {
			
			String sql = "SELECT nm_funcionario, cargo_funcionario                     "
					+    "  FROM revenda.tb_funcionarios   "
					+    " WHERE email_funcionario = ?     "
					+    "   AND sh_funcionario = ?        ";
			
			PreparedStatement acesso = conn.prepareStatement(sql);
			acesso.setString(1, email );
			acesso.setString(2, senha );
			
			ResultSet rs = acesso.executeQuery(); 			
				
		 if	(rs.next()) {  //TODO Criar validação de senha e email.
								
				IndexView.logado = rs.getString("nm_funcionario");
				IndexView.cargo = rs.getNString("cargo_funcionario"); 
				JOptionPane.showMessageDialog(null, "Bem Vindo: " + IndexView.logado);
				IndexView.main(null);
				
			}else {
				JOptionPane.showMessageDialog(null, "SEnha ou Email errado", "erro no acesso: ",0, null);
				LoginView.main(null);
			}
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro no banco de dados" + erro);
			erro.printStackTrace(); 
		}
	}
}
