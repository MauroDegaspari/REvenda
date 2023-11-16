package br.com.mauro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.mauro.jdbc.ConnectionFactory;
import br.com.mauro.model.ClienteModel;
import br.com.mauro.model.FornecedoresModel;


public class FornecedoresDAO {
	
	private Connection conn;
	
	public FornecedoresDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}
	
	public void CadastrarFornecedor(FornecedoresModel fornecedor) {
		
		try {
			
			String sql = " INSERT INTO revenda.tb_fornecedores(cd_fornecedor,"
															+ " nm_fornecedor,"
															+ " cnpj_fornecedor,"
															+ " email_fornecedor,"
															+ " telefone_fornecedor,"
															+ " celular_fornecedor,"
															+ " cep_fornecedor,"
															+ " endereco_fornecedor,"
															+ " numero_fornecedor,"
															+ " complemento_fornecedor,"
															+ " bairro_fornecedor,"
															+ " cidade_fornecedor,"
															+ " estado_fornecedor)"
											+ "		VALUES(seq_fornecedores.nextval,?,?,?,?,?,?,?,?,?,?,?,?) ";
			
			PreparedStatement acesso = conn.prepareStatement(sql);
			acesso.setString(1,fornecedor.getNome());
			acesso.setString(2,fornecedor.getCnpj());
			acesso.setString(3,fornecedor.getEmail());
			acesso.setString(4,fornecedor.getTelefone());
			acesso.setString(5,fornecedor.getCelular());
			acesso.setString(6,fornecedor.getCep());
			acesso.setString(7,fornecedor.getRua());
			acesso.setInt(8,fornecedor.getNumero());
			acesso.setString(9,fornecedor.getComplemento());
			acesso.setString(10,fornecedor.getBairro());
			acesso.setString(11,fornecedor.getCidade());
			acesso.setString(12,fornecedor.getUf());
			
			acesso.execute();
			acesso.close();
			
			JOptionPane.showMessageDialog(null, "Cadastro de " +fornecedor.getNome() +" realizado com sucesso.", sql, 1);
			
		
			
		} catch (Exception erro) {
			
			JOptionPane.showMessageDialog(null," ERRO AO SALVAR FONECEDOR: "+ erro);
			
		}
	}
	
	public List<FornecedoresModel> ListarFornecedoredores(){
		
		try {
		
			List<FornecedoresModel> listaFornecedoredor = new ArrayList<>();
			
			String sql = "SELECT cd_fornecedor ,nm_fornecedor,cnpj_fornecedor, email_fornecedor, telefone_fornecedor, celular_fornecedor, "
					+    "       cep_fornecedor, endereco_fornecedor, numero_fornecedor, complemento_fornecedor, bairro_fornecedor, cidade_fornecedor, estado_fornecedor"
					+    "  FROM revenda.tb_fornecedores"
					+    " ORDER BY 1 ASC";
			
			PreparedStatement acesso = conn.prepareStatement(sql);
			
			ResultSet rs = acesso.executeQuery();
			
			while(rs.next()) {
				
				FornecedoresModel fornecedor = new FornecedoresModel();
				
				fornecedor.setCodigo(rs.getInt("cd_fornecedor"));
				fornecedor.setNome(rs.getString("nm_fornecedor"));
				fornecedor.setCnpj(rs.getString("cnpj_fornecedor"));
				fornecedor.setEmail(rs.getString("email_fornecedor"));
				fornecedor.setTelefone(rs.getString("telefone_fornecedor"));
				fornecedor.setCelular(rs.getString("celular_fornecedor"));
				fornecedor.setCep(rs.getString("cep_fornecedor"));
				fornecedor.setRua(rs.getString("endereco_fornecedor"));
				fornecedor.setNumero(rs.getInt("numero_fornecedor"));
				fornecedor.setComplemento(rs.getString("complemento_fornecedor"));
				fornecedor.setBairro(rs.getString("bairro_fornecedor"));
				fornecedor.setCidade(rs.getString("cidade_fornecedor"));
				fornecedor.setUf(rs.getString("estado_fornecedor"));
				
				listaFornecedoredor.add(fornecedor);
			}
			
			return listaFornecedoredor;

			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null," Erro em Banco de dados: \n " + erro);
			return null;
		}
	}
	
	public void ExcluirFornecedor(FornecedoresModel fornecedor) {
		
		try {
			String sql = "DELETE FROM revenda.tb_fornecedores WHERE cd_fornecedor = ?";
			
			PreparedStatement acesso = conn.prepareStatement(sql);
			acesso.setInt(1,fornecedor.getCodigo());
						
			acesso.execute();
			acesso.close();
			
		}catch(Exception erro) {
			
			JOptionPane.showMessageDialog(null," Erro em Banco de dados: \n " + erro);
			
		}
		
	}
}
