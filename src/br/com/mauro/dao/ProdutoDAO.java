package br.com.mauro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.mauro.jdbc.ConnectionFactory;
import br.com.mauro.model.FornecedoresModel;
import br.com.mauro.model.ProdutoModel;

public class ProdutoDAO {
	
	private Connection conn;
	
	public ProdutoDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}
	
	public void CadastrarProduto(ProdutoModel produto) {
		try {
			
			String sql = "INSERT INTO revenda.tb_produtos(cd_produto,ds_produto,preco_produto,qtd_estoque_produto,cd_fornecedor)"
					   + "                         VALUES(seq_produtos.nextval,?,?,?,?)";
			
			PreparedStatement acesso = conn.prepareStatement(sql);
			acesso.setString(1,produto.getNomeProduto());
			acesso.setDouble(2,produto.getPrecoProduto());
			acesso.setInt(3,produto.getQtdProduto());
			
			acesso.setInt(4,produto.getFornecedores().getCodigo());
			
			acesso.execute();
			acesso.close();
				
			JOptionPane.showMessageDialog(null, "PRODUTO SALVO");
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro ao salvar produto ORA -:  " + e);
		}
	}
	
	public List<ProdutoModel> ListarProdutos(){
		try {
			List<ProdutoModel> listaProduto = new ArrayList<>();
			
			String sql = "SELECT p.cd_produto, "
					+ "       p.ds_produto, "
					+ "       p.preco_produto, "
					+ "       p.qtd_estoque_produto, "
					+ "       f.nm_fornecedor "
					+ "  FROM tb_produtos p, "
					+ "       tb_fornecedores f"
					+ " WHERE p.cd_fornecedor = f.cd_fornecedor";
			
			PreparedStatement acesso = conn.prepareStatement(sql);
			ResultSet rs = acesso.executeQuery();
			
			while(rs.next()) {
				ProdutoModel produto = new ProdutoModel();
				FornecedoresModel fornec  = new FornecedoresModel();
				
				produto.setCodigo(rs.getInt("cd_produto"));
				produto.setNomeProduto(rs.getString("ds_produto"));
				produto.setPrecoProduto(rs.getDouble("preco_produto"));
				produto.setQtdProduto(rs.getInt("qtd_estoque_produto"));
				
				fornec.setNome(rs.getString("nm_fornecedor"));
				
				produto.setFornecedores(fornec);
				
				listaProduto.add(produto);
			}				
			
			return listaProduto;
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null," Erro no Banco de dados: \n " + erro);
		}
		return null;
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
