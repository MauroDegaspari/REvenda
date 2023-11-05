package br.com.mauro.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import br.com.mauro.dao.ClientesDAO;
import br.com.mauro.dao.ProdutoDAO;
import br.com.mauro.model.ClienteModel;
import br.com.mauro.model.ProdutoModel;
import br.com.mauro.utils.FuncionalidadesUtils;

public class IndexView {

	private JFrame frmIndex;
	public static String logado;
	public static String cargo;
	public static String data;
	private JTable table;
	
	FuncionalidadesUtils util = new FuncionalidadesUtils();
	private JTextField txtClienteCpf;
	private JTextField txtCodigoProduto;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IndexView window = new IndexView();
					window.frmIndex.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IndexView() {
		initialize();
		util.DataHoraAtual();
	}

	private void initialize() {
		frmIndex = new JFrame();
	
		frmIndex.setIconImage(Toolkit.getDefaultToolkit().getImage(IndexView.class.getResource("/icons/r.png")));
		frmIndex.setTitle("Dashboard");
		frmIndex.setType(Type.POPUP);
		frmIndex.getContentPane().setBackground(SystemColor.controlHighlight);
		frmIndex.setBounds(100, 100, 1183, 771);
		frmIndex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIndex.getContentPane().setLayout(null);
		
		JPanel pnVendas = new JPanel();
		pnVendas.setBounds(220, 79, 937, 642);
		frmIndex.getContentPane().add(pnVendas);
		pnVendas.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(598, 87, 329, 108);
		panel.setLayout(null);
		panel.setBackground(new Color(95, 158, 160));
		pnVendas.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("R$");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(10, 46, 46, 51);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(0, 0, 210, 34);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 87, 578, 54);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(97, 171, 164));
		pnVendas.add(panel_2);
		
		JLabel lbDescricao = new JLabel("Descrição do Produto");
		lbDescricao.setForeground(Color.WHITE);
		lbDescricao.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbDescricao.setBounds(106, 0, 143, 19);
		panel_2.add(lbDescricao);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 139, 139));
		panel_3.setBounds(0, 0, 96, 54);
		panel_2.add(panel_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quantidade");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1.setBounds(10, 0, 72, 19);
		panel_3.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Preço Und:");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_2.setBounds(416, 2, 69, 19);
		panel_2.add(lblNewLabel_1_1_2);
		
		JLabel lbPreco = new JLabel("");
		lbPreco.setForeground(new Color(255, 255, 255));
		lbPreco.setFont(new Font("Verdana", Font.ITALIC, 15));
		lbPreco.setBounds(442, 23, 69, 14);
		panel_2.add(lbPreco);
		
		JLabel lbProdutoDescricao = new JLabel("");
		lbProdutoDescricao.setForeground(new Color(255, 255, 255));
		lbProdutoDescricao.setFont(new Font("Verdana", Font.BOLD, 25));
		lbProdutoDescricao.setBounds(114, 17, 302, 31);
		panel_2.add(lbProdutoDescricao);
		
		JLabel lblNewLabel_1_2 = new JLabel("R$");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(415, 11, 27, 40);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblAddCarrinho = new JLabel("");
		lblAddCarrinho.setIcon(new ImageIcon(IndexView.class.getResource("/icons/cart shopping.png")));
		lblAddCarrinho.setBounds(517, 0, 61, 53);
		panel_2.add(lblAddCarrinho);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 152, 577, 393);
		pnVendas.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Quantidade", "Item/Descri\u00E7\u00E3o", "Valor Unit\u00E1rio", "Desconto", "TOTAL"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(386);
		scrollPane.setViewportView(table);
		
		JPanel pnProdutoCliente = new JPanel();
		pnProdutoCliente.setBackground(new Color(51, 51, 51));
		pnProdutoCliente.setBounds(10, 11, 917, 70);
		pnVendas.add(pnProdutoCliente);
		pnProdutoCliente.setLayout(null);
		
		JPanel pnQtd = new JPanel();
		pnQtd.setLayout(null);
		pnQtd.setBackground(new Color(102, 102, 102));
		pnQtd.setBounds(0, 0, 142, 70);
		pnProdutoCliente.add(pnQtd);
		
		JLabel lbQunatidade = new JLabel("QUANTIDADE");
		lbQunatidade.setForeground(Color.WHITE);
		lbQunatidade.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbQunatidade.setBounds(21, 8, 98, 19);
		pnQtd.add(lbQunatidade);
		
		JPanel pnQtd_1 = new JPanel();
		pnQtd_1.setLayout(null);
		pnQtd_1.setBackground(new Color(102, 102, 102));
		pnQtd_1.setBounds(584, -1, 333, 70);
		pnProdutoCliente.add(pnQtd_1);
		
		JLabel lbCliente = new JLabel("Cliente CPF:");
		lbCliente.setForeground(Color.WHITE);
		lbCliente.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbCliente.setBounds(10, 11, 76, 19);
		pnQtd_1.add(lbCliente);

		JLabel lbClienteCpf = new JLabel("");
		lbClienteCpf.setFont(new Font("Verdana", Font.BOLD, 16));
		lbClienteCpf.setForeground(new Color(255, 255, 255));
		lbClienteCpf.setBounds(56, 28, 235, 42);
		pnQtd_1.add(lbClienteCpf);
		
		txtClienteCpf = new JTextField();
		txtClienteCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evento) {
			    if(evento.getKeyCode() == KeyEvent.VK_ENTER) {
			        ClienteModel cliente = new ClienteModel();
			        ClientesDAO dao = new ClientesDAO();
			        
			        ArrayList<ClienteModel> resultados = (ArrayList<ClienteModel>) dao.PesquisaClienteCpf(txtClienteCpf.getText());
			        
			        if (!resultados.isEmpty()) {
			            cliente = resultados.get(0); // Obtém o primeiro cliente da lista
			            lbClienteCpf.setText(cliente.getNome());
			        } else {
			            lbClienteCpf.setText("Cliente não encontrado");
			        }
			    }
			}
		});
		txtClienteCpf.setBounds(96, 11, 153, 20);
		pnQtd_1.add(txtClienteCpf);
		txtClienteCpf.setColumns(10);
		
		JLabel lb = new JLabel("-->");
		lb.setFont(new Font("Verdana", Font.BOLD, 14));
		lb.setForeground(new Color(255, 255, 255));
		lb.setBounds(20, 41, 46, 14);
		pnQtd_1.add(lb);
		
		JButton btnPesquisaCliente = new JButton("");
		btnPesquisaCliente.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnPesquisaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				
				        ClienteModel cliente = new ClienteModel();
				        ClientesDAO dao = new ClientesDAO();
				        
				        ArrayList<ClienteModel> resultados = (ArrayList<ClienteModel>) dao.PesquisaClienteCpf(txtClienteCpf.getText());
				        
				        if (!resultados.isEmpty()) {
				            cliente = resultados.get(0); // Obtém o primeiro cliente da lista
				            lbClienteCpf.setText(cliente.getNome());
				        } else {
				            lbClienteCpf.setText("Cliente não encontrado");
				        }
				    }
		});
		btnPesquisaCliente.setIcon(new ImageIcon(IndexView.class.getResource("/icons/buscar.png")));
		btnPesquisaCliente.setBounds(262, 11, 46, 25);
		pnQtd_1.add(btnPesquisaCliente);
		
		JButton btnPesquisaProduto = new JButton("Pesquisar Produto");
		btnPesquisaProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  ProdutoModel produto  = new ProdutoModel();
			      ProdutoDAO dao = new ProdutoDAO();
			        
			        ArrayList<ProdutoModel> resultados = (ArrayList<ProdutoModel>) dao.PesquisaProdutoCodigo(Integer.parseInt(txtCodigoProduto.getText()));
			        
			        if (!resultados.isEmpty()) {
			            produto = resultados.get(0); // Obtém o primeiro cliente da lista
			            lbProdutoDescricao.setText(produto.getNomeProduto());
			            lbPreco.setText(String.valueOf(produto.getPrecoProduto()));
			        } else {
			        	lbProdutoDescricao.setText("Produto não encontrado");
			        	lbPreco.setText(String.valueOf("0,00"));
			        }
			}
		});
		btnPesquisaProduto.setBounds(486, 22, 89, 23);
		pnProdutoCliente.add(btnPesquisaProduto);
		
		txtCodigoProduto = new JTextField();
		txtCodigoProduto.setText("Cibs");
		txtCodigoProduto.setName("\r\n");
		txtCodigoProduto.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtCodigoProduto.setToolTipText("");
		txtCodigoProduto.setFont(new Font("Verdana", Font.BOLD, 22));
		txtCodigoProduto.setBounds(159, 11, 297, 48);
		pnProdutoCliente.add(txtCodigoProduto);
		txtCodigoProduto.setColumns(10);
		
		
		JPanel pnIndex = new JPanel();
		pnIndex.setBackground(Color.WHITE);
		pnIndex.setBounds(220, 79, 937, 642);
		frmIndex.getContentPane().add(pnIndex);
		pnIndex.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(IndexView.class.getResource("/icons/REVENDA300.png")));
		lblNewLabel_2.setBounds(600, 0, 337, 332);
		pnIndex.add(lblNewLabel_2);
		
		JPanel pnSuperior = new JPanel();
		pnSuperior.setBackground(new Color(95, 158, 160));
		pnSuperior.setBounds(0, 0, 1167, 68);
		frmIndex.getContentPane().add(pnSuperior);
		pnSuperior.setLayout(null);
		
		JPanel pnSideBar = new JPanel();
		pnSideBar.setBackground(new Color(240, 248, 255));
		pnSideBar.setBounds(0, 0, 210, 721);
		frmIndex.getContentPane().add(pnSideBar);
		pnSideBar.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnIndex.setVisible(true);
			}
		});
		btnNewButton.setBounds(78, 113, 89, 23);
		pnSideBar.add(btnNewButton);
		
		JPanel pnSideBarInferior = new JPanel();
		pnSideBarInferior.setBackground(new Color(240, 248, 255));
		pnSideBarInferior.setBounds(0, 1, 55, 720);
		pnSideBar.add(pnSideBarInferior);
		pnSideBarInferior.setLayout(null);
		
		JLabel lbFuncionario = new JLabel("Funcionario:");
		lbFuncionario.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbFuncionario.setBounds(956, 7, 75, 14);
		pnSuperior.add(lbFuncionario);
		
		JLabel lbLogado = new JLabel();
		lbLogado.setForeground(new Color(0, 0, 139));
		lbLogado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbLogado.setBounds(1030, 7, 116, 14);
		pnSuperior.add(lbLogado);
		lbLogado.setText(logado);
		
		JLabel lbOcultaMenu = new JLabel("");
		lbOcultaMenu.setBounds(4, 12, 55, 46);
		pnSuperior.add(lbOcultaMenu);
		lbOcultaMenu.setIcon(new ImageIcon(IndexView.class.getResource("/icons/options.png")));
		lbOcultaMenu.addMouseListener(new MouseAdapter() {
			
			/**
			 * @author Mauro Degaspari
			 * @since 01/11/2023
			 * @apiNote Lógica para a barra lateral vertical, onde a barra lateral é encurtada até o limite da imagem.
			 * 
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				int  condicao;
				int x = pnSideBar.getWidth();
				condicao = x == 210 ? 1 : 2;
				switch (condicao) {
				case 1 :
					Thread th = new Thread(){
						@Override
						public void run(){
							try{
								for(int i = pnSideBar.getWidth(); i >= 50 ; i-- ){
									Thread.sleep(1);
									pnSideBar.setSize(i,pnSideBar.getHeight());
							}
						}
							catch(Exception e){
							JOptionPane.showMessageDialog(null,e);
							}
						}
					};
					th.start();
				
					break;
				case 2 :
					Thread th2 = new Thread(){
						@Override
						public void run(){
							try{
								for(int i = pnSideBar.getWidth(); i <= 210 ; i++ ){
									Thread.sleep(3);
									pnSideBar.setSize(i,pnSideBar.getHeight());
							}
						}
							catch(Exception e){
							JOptionPane.showMessageDialog(null,e);
							}
						}
					};
					th2.start();
					break;

				default:
					break;
				}
			}
		});
		
		
		JLabel lbCargo = new JLabel("Função:");
		lbCargo.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbCargo.setBounds(982, 21, 49, 14);
		pnSuperior.add(lbCargo);
		
		JLabel lbLogadoCardo = new JLabel();
		lbLogadoCardo.setText(cargo);
		lbLogadoCardo.setForeground(new Color(0, 0, 139));
		lbLogadoCardo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbLogadoCardo.setBounds(1030, 21, 116, 14);
		pnSuperior.add(lbLogadoCardo);
		
		JLabel lbDataHora = new JLabel("");
		lbDataHora.setFont(new Font("Verdana", Font.PLAIN, 13));
		lbDataHora.setBounds(982, 36, 175, 24);
		pnSuperior.add(lbDataHora);		
		
		JLabel lbImgCliente = new JLabel("");
		lbImgCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClienteView.main(null);
			}
		});
		lbImgCliente.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgCliente.setIcon(new ImageIcon(IndexView.class.getResource("/icons/clientes.png")));
		lbImgCliente.setBounds(5, 172, 41, 36);
		pnSideBarInferior.add(lbImgCliente);
		
		JLabel lbImgFuncionario = new JLabel("");
		lbImgFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FuncionarioView.main(null);
			}
		});
		lbImgFuncionario.setIcon(new ImageIcon(IndexView.class.getResource("/icons/funcionarios.png")));
		lbImgFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgFuncionario.setBounds(5, 222, 41, 48);
		pnSideBarInferior.add(lbImgFuncionario);
		
		JLabel lbImgFornecedor = new JLabel("");
		lbImgFornecedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FornecedorView.main(null);
			}
		});
		lbImgFornecedor.setIcon(new ImageIcon(IndexView.class.getResource("/icons/fornecedores.png")));
		lbImgFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgFornecedor.setBounds(3, 277, 46, 48);
		pnSideBarInferior.add(lbImgFornecedor);
		
		JLabel lbImgProduto = new JLabel("");
		lbImgProduto.setIcon(new ImageIcon(IndexView.class.getResource("/icons/produtos.png")));
		lbImgProduto.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgProduto.setBounds(0, 334, 50, 48);
		pnSideBarInferior.add(lbImgProduto);
		
		JLabel lbImgFuncionario_3 = new JLabel("");
		lbImgFuncionario_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnIndex.setVisible(false); 
			}
		});
		lbImgFuncionario_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgFuncionario_3.setBounds(3, 98, 49, 48);
		pnSideBarInferior.add(lbImgFuncionario_3);
		
		JLabel lbImgVendas = new JLabel("");
		lbImgVendas.setIcon(new ImageIcon(IndexView.class.getResource("/icons/vendas.png")));
		lbImgVendas.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgVendas.setBounds(4, 393, 50, 48);
		pnSideBarInferior.add(lbImgVendas);
		
		JLabel lbImgConfiguracao = new JLabel("");
		lbImgConfiguracao.setIcon(new ImageIcon(IndexView.class.getResource("/icons/configuracoes.png")));
		lbImgConfiguracao.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgConfiguracao.setBounds(0, 453, 49, 48);
		pnSideBarInferior.add(lbImgConfiguracao);
		
		JLabel lbImgFuncionario_2 = new JLabel("");
		lbImgFuncionario_2.setIcon(new ImageIcon(IndexView.class.getResource("/icons/sair.png")));
		lbImgFuncionario_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgFuncionario_2.setBounds(5, 667, 41, 48);
		pnSideBarInferior.add(lbImgFuncionario_2);
		
		JLabel lbClientes = new JLabel("Clientes");
		lbClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClienteView.main(null);
			}
		});
		lbClientes.setFont(new Font("Verdana", Font.PLAIN, 14));
		lbClientes.setBounds(61, 171, 99, 29);
		pnSideBar.add(lbClientes);
		
		JLabel lb_Fucionarios = new JLabel("Fucionarios");
		lb_Fucionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FuncionarioView.main(null);
			}
		});
		lb_Fucionarios.setFont(new Font("Verdana", Font.PLAIN, 14));
		lb_Fucionarios.setBounds(61, 232, 99, 29);
		pnSideBar.add(lb_Fucionarios);
		
		JLabel lbFornecedores = new JLabel("Fornecedores");
		lbFornecedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FornecedorView.main(null);
			}
		});
		lbFornecedores.setFont(new Font("Verdana", Font.PLAIN, 14));
		lbFornecedores.setBounds(61, 286, 99, 29);
		pnSideBar.add(lbFornecedores);
		
		JLabel lbProdutos = new JLabel("Produtos");
		lbProdutos.setFont(new Font("Verdana", Font.PLAIN, 14));
		lbProdutos.setBounds(61, 346, 99, 29);
		pnSideBar.add(lbProdutos);
		
		JLabel lbVendas = new JLabel("Vendas");
		lbVendas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnIndex.setVisible(false);
			}
		});
		lbVendas.setFont(new Font("Verdana", Font.PLAIN, 14));
		lbVendas.setBounds(61, 403, 99, 29);
		pnSideBar.add(lbVendas);
		
		JLabel lblConfiguraes = new JLabel("Configurações");
		lblConfiguraes.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblConfiguraes.setBounds(61, 462, 116, 29);
		pnSideBar.add(lblConfiguraes);
		
		JLabel lblSair = new JLabel("Sair");
		lblSair.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblSair.setBounds(61, 678, 99, 29);
		pnSideBar.add(lblSair);
		frmIndex.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				lbDataHora.setText(data);
			}
		});
		
	
	}
}
