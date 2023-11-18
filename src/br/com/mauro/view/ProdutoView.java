package br.com.mauro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import br.com.mauro.dao.FornecedoresDAO;
import br.com.mauro.dao.ProdutoDAO;
import br.com.mauro.model.FornecedoresModel;
import br.com.mauro.model.ProdutoModel;

public class ProdutoView {

	private JFrame frame;
	private JTextField txtProduto;
	private JTextField txtDescricao;
	private JTextField txtQtdProduto;
	private JTextField textField_2;
	private JTextField txtPreco;
	private JTextField txtCusto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoView window = new ProdutoView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProdutoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1074, 635);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1058, 67);
		panel.setBackground(new Color(0, 128, 128));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblRevenda = new JLabel("Sistema REVENDA");
		lblRevenda.setForeground(Color.WHITE);
		lblRevenda.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblRevenda.setBounds(76, 0, 161, 34);
		panel.add(lblRevenda);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbLogo.setBounds(10, 11, 69, 50);
		panel.add(lbLogo);
		

	
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(849, 35, 78, 23);
		panel.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(937, 35, 78, 23);
		panel.add(btnExcluir);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 89, 1038, 496);
		frame.getContentPane().add(tabbedPane);
		
		JPanel Produtos = new JPanel();
		tabbedPane.addTab("Produto", null, Produtos, null);
		Produtos.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(18, 203, 702, 2);
		Produtos.add(separator);
		
		txtProduto = new JTextField();
		txtProduto.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtProduto.setBounds(12, 72, 488, 34);
		Produtos.add(txtProduto);
		txtProduto.setColumns(10);
		
		JLabel lbProduto = new JLabel("Produto:");
		lbProduto.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbProduto.setBounds(17, 54, 66, 14);
		Produtos.add(lbProduto);
		
		txtDescricao = new JTextField();
		txtDescricao.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(14, 126, 487, 21);
		Produtos.add(txtDescricao);
		
		txtQtdProduto = new JTextField();
		txtQtdProduto.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtQtdProduto.setColumns(10);
		txtQtdProduto.setBounds(512, 70, 84, 34);
		Produtos.add(txtQtdProduto);
		
		JLabel lbQunatidade = new JLabel("Qtd. Estoque:");
		lbQunatidade.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbQunatidade.setBounds(512, 53, 84, 14);
		Produtos.add(lbQunatidade);
		
		JLabel lblDescrico = new JLabel("Descrição:");
		lblDescrico.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDescrico.setBounds(16, 110, 66, 14);
		Produtos.add(lblDescrico);
		
		JLabel lblUnidade = new JLabel("Unidade:");
		lblUnidade.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblUnidade.setBounds(512, 110, 68, 14);
		Produtos.add(lblUnidade);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		textField_2.setColumns(10);
		textField_2.setBounds(511, 126, 92, 21);
		Produtos.add(textField_2);
		
		txtPreco = new JTextField();
		txtPreco.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtPreco.setColumns(10);
		txtPreco.setBounds(606, 70, 100, 34);
		Produtos.add(txtPreco);
		
		JLabel lblPreovenda = new JLabel("Preço Venda");
		lblPreovenda.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblPreovenda.setBounds(606, 53, 100, 14);
		Produtos.add(lblPreovenda);
		
		txtCusto = new JTextField();
		txtCusto.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtCusto.setColumns(10);
		txtCusto.setBounds(613, 125, 92, 21);
		Produtos.add(txtCusto);
		
		JLabel lblCusto = new JLabel("Custo:");
		lblCusto.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCusto.setBounds(614, 109, 68, 14);
		Produtos.add(lblCusto);
		
		JLabel lblFornecedor = new JLabel("FOrnecedores");
		lblFornecedor.setBounds(14, 181, 137, 14);
		Produtos.add(lblFornecedor);
		
		JComboBox<FornecedoresModel> cbFornecedor = new JComboBox<FornecedoresModel>();
		cbFornecedor.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				FornecedoresDAO daoFornecedores = new FornecedoresDAO();
				List<FornecedoresModel> listaFornecedor = daoFornecedores.ListarFornecedoredores();
				
				cbFornecedor.removeAll(); // antes de add remover todos para evitar dublicação
				
				for (FornecedoresModel forncedores : listaFornecedor) {
					cbFornecedor.addItem(forncedores);
				}
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbFornecedor.setBounds(18, 216, 309, 22);
		Produtos.add(cbFornecedor);
		
		JPanel Pesquisar = new JPanel();
		tabbedPane.addTab("Pesquisar Prod.", null, Pesquisar, null);
		
		JPanel Estoque = new JPanel();
		tabbedPane.addTab("Estoque", null, Estoque, null);
		
		JLabel lbCadastroProdutos = new JLabel("Cadastro de Produtos");
		lbCadastroProdutos.setForeground(Color.WHITE);
		lbCadastroProdutos.setFont(new Font("Verdana", Font.BOLD, 17));
		lbCadastroProdutos.setBounds(76, 27, 277, 34);
		panel.add(lbCadastroProdutos);
		
		JButton btnLocalizarCliente = new JButton("Localizar Cliente");
		btnLocalizarCliente.setBounds(542, 36, 161, 23);
		panel.add(btnLocalizarCliente);
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					ProdutoModel produto = new ProdutoModel();
					
					produto.setNomeProduto(txtDescricao.getText());
					produto.setQtdProduto(Integer.parseInt(txtQtdProduto.getText()));
					produto.setPrecoProduto(Double.parseDouble(txtPreco.getText()));
					
					FornecedoresModel fornecedor = new FornecedoresModel();
					fornecedor = (FornecedoresModel)cbFornecedor.getSelectedItem();
					
					produto.setFornecedores(fornecedor);
					
					ProdutoDAO daoProduto = new ProdutoDAO();
					daoProduto.CadastrarProduto(produto);
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro no botão salvar " + e);
				}
			}
		});
		
		btnSalvar.setBounds(761, 35, 78, 23);
		panel.add(btnSalvar);
	}
}
