package br.com.mauro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import br.com.mauro.jdbc.ConnectionFactory;
import br.com.mauro.model.FornecedoresModel;

public class FornecedoresDAO {
	
	private Connection conn;
	
	public FornecedoresDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}
	
	public void CadastrarFornecedor(FornecedoresModel fornec) {
		
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
			acesso.setString(1,fornec.getNome());
			acesso.setString(2,fornec.getCnpj());
			acesso.setString(3,fornec.getEmail());
			acesso.setString(4,fornec.getTelefone());
			acesso.setString(5,fornec.getCelular());
			acesso.setString(6,fornec.getCep());
			acesso.setString(7,fornec.getRua());
			acesso.setInt(8,fornec.getNumero());
			acesso.setString(9,fornec.getComplemento());
			acesso.setString(10,fornec.getBairro());
			acesso.setString(11,fornec.getCidade());
			acesso.setString(12,fornec.getUf());
			
			acesso.execute();
			acesso.close();
			
			JOptionPane.showMessageDialog(null, "Cadastro de " +fornec.getNome() +" realizado com sucesso.", sql, 1);
			
		
			
		} catch (Exception erro) {
			
			JOptionPane.showMessageDialog(null," ERRO AO SALVAR FONECEDOR: "+ erro);
			
		}
	}

}
