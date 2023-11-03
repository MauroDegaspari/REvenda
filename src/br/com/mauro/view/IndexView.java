package br.com.mauro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IndexView {

	private JFrame frmIndex;
	public static String logado;
	public static String cargo;
	
	
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
		
		JPanel pnSuperior = new JPanel();
		pnSuperior.setBackground(new Color(95, 158, 160));
		pnSuperior.setBounds(0, 0, 1167, 68);
		frmIndex.getContentPane().add(pnSuperior);
		pnSuperior.setLayout(null);
		
		JPanel pnIndex = new JPanel();
		pnIndex.setBackground(Color.WHITE);
		pnIndex.setBounds(220, 79, 937, 642);
		frmIndex.getContentPane().add(pnIndex);
		pnIndex.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(IndexView.class.getResource("/icons/REVENDA300.png")));
		lblNewLabel_2.setBounds(600, 0, 337, 332);
		pnIndex.add(lblNewLabel_2);
		
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
		pnSideBarInferior.setBounds(0, 0, 51, 721);
		pnSideBar.add(pnSideBarInferior);
		pnSideBarInferior.setLayout(null);
		
		JLabel lbFuncionario = new JLabel("Funcionario:");
		lbFuncionario.setBounds(967, 11, 75, 14);
		pnSuperior.add(lbFuncionario);
		
		JLabel lbLogado = new JLabel();
		lbLogado.setForeground(new Color(0, 0, 139));
		lbLogado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbLogado.setBounds(1041, 11, 116, 14);
		pnSuperior.add(lbLogado);
		lbLogado.setText(logado);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 25, 55, 46);
		pnSuperior.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(IndexView.class.getResource("/icons/options.png")));
		
		JLabel lbCargo = new JLabel("Função:");
		lbCargo.setBounds(993, 25, 49, 14);
		pnSuperior.add(lbCargo);
		
		JLabel lbLogadoCardo = new JLabel();
		lbLogadoCardo.setText(cargo);
		lbLogadoCardo.setForeground(new Color(0, 0, 139));
		lbLogadoCardo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbLogadoCardo.setBounds(1041, 25, 116, 14);
		pnSuperior.add(lbLogadoCardo);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			
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
									Thread.sleep(3);
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
		lbImgFuncionario_3.setBounds(0, 395, 49, 48);
		pnSideBarInferior.add(lbImgFuncionario_3);
		
		JLabel lbImgVendas = new JLabel("");
		lbImgVendas.setIcon(new ImageIcon(IndexView.class.getResource("/icons/vendas.png")));
		lbImgVendas.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgVendas.setBounds(9, 385, 41, 48);
		pnSideBarInferior.add(lbImgVendas);
		
		JLabel lbImgConfiguracao = new JLabel("");
		lbImgConfiguracao.setIcon(new ImageIcon(IndexView.class.getResource("/icons/configuracoes.png")));
		lbImgConfiguracao.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgConfiguracao.setBounds(0, 453, 49, 48);
		pnSideBarInferior.add(lbImgConfiguracao);
		
		JLabel lbImgFuncionario_2 = new JLabel("");
		lbImgFuncionario_2.setIcon(new ImageIcon(IndexView.class.getResource("/icons/sair.png")));
		lbImgFuncionario_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgFuncionario_2.setBounds(3, 673, 41, 48);
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
		
		JPanel pnVendas = new JPanel();
		pnVendas.setBounds(220, 79, 937, 642);
		frmIndex.getContentPane().add(pnVendas);
		pnVendas.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(605, 11, 322, 108);
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
		panel_2.setBounds(10, 11, 578, 54);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(95, 158, 160));
		pnVendas.add(panel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Dedscrição do Produto");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(123, 0, 203, 19);
		panel_2.add(lblNewLabel_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 139, 139));
		panel_3.setBounds(0, 0, 116, 54);
		panel_2.add(panel_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quantidade");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1.setBounds(10, 0, 72, 19);
		panel_3.add(lblNewLabel_1_1_1);
	}
}
