package br.com.mauro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.mauro.jdbc.ConnectionFactory;
import br.com.mauro.model.ProdutoModel;

public class ProdutoDAO {
	
	private Connection conn;
	
	public ProdutoDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}
	
	
	public void CadastrarProduto() {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<ProdutoModel> PesquisaProdutoCodigo(int cd_produto) {
		try {
			List<ProdutoModel> listaProduto = new ArrayList<>();
			
			String sql = " SELECT * FROM revenda.tb_produtos WHERE cd_produto LIKE ? ";
			
			PreparedStatement acesso = conn.prepareStatement(sql);
			acesso.setInt(1, cd_produto );
			
			ResultSet rs = acesso.executeQuery();
			
			while(rs.next()) {
				ProdutoModel produto = new ProdutoModel();
				
				produto.setCodigo(rs.getInt("cd_produto"));
				produto.setNomeProduto(rs.getString("ds_produto"));
				produto.setPrecoProduto(rs.getDouble("preco_produto"));
				produto.setQtdProduto(rs.getInt("qtd_estoque_produto"));
				
			
				
				listaProduto.add(produto);
			}				
			
			return listaProduto;
			
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null," Erro em Banco de dados: \n " + erro);
			return null;
		}
	}
	
	
}
