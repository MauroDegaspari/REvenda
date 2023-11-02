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

public class IndexView {

	private JFrame frmIndex;
	public String logado;
	
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
		frmIndex.setBounds(100, 100, 1092, 648);
		frmIndex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIndex.getContentPane().setLayout(null);
		
		JPanel pnSuperior = new JPanel();
		pnSuperior.setBackground(new Color(95, 158, 160));
		pnSuperior.setBounds(0, 0, 1076, 93);
		frmIndex.getContentPane().add(pnSuperior);
		pnSuperior.setLayout(null);
		
		JPanel pnSideBar = new JPanel();
		pnSideBar.setBackground(new Color(240, 248, 255));
		pnSideBar.setBounds(0, 0, 210, 609);
		frmIndex.getContentPane().add(pnSideBar);
		pnSideBar.setLayout(null);
		
		JPanel pnSideBarInferior = new JPanel();
		pnSideBarInferior.setBackground(new Color(240, 248, 255));
		pnSideBarInferior.setBounds(0, 0, 51, 609);
		pnSideBar.add(pnSideBarInferior);
		pnSideBarInferior.setLayout(null);
		
		JLabel lbFuncionario = new JLabel("Funcionario Logado:");
		lbFuncionario.setBounds(787, 68, 116, 14);
		pnSuperior.add(lbFuncionario);
		
		JLabel lbLogado = new JLabel();
		lbLogado.setForeground(new Color(0, 0, 139));
		lbLogado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbLogado.setBounds(888, 68, 116, 14);
		pnSuperior.add(lbLogado);
		lbLogado.setText(logado);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 25, 55, 46);
		pnSuperior.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(IndexView.class.getResource("/icons/options.png")));
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
									pnSideBar.setSize(i,609);
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
									pnSideBar.setSize(i,609);
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
		lbImgCliente.setBounds(3, 110, 41, 36);
		pnSideBarInferior.add(lbImgCliente);
		
		JLabel lbImgFuncionario = new JLabel("");
		lbImgFuncionario.setIcon(new ImageIcon(IndexView.class.getResource("/icons/funcionarios.png")));
		lbImgFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgFuncionario.setBounds(2, 159, 41, 48);
		pnSideBarInferior.add(lbImgFuncionario);
		
		JLabel lbImgFornecedor = new JLabel("");
		lbImgFornecedor.setIcon(new ImageIcon(IndexView.class.getResource("/icons/fornecedores.png")));
		lbImgFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgFornecedor.setBounds(0, 218, 46, 48);
		pnSideBarInferior.add(lbImgFornecedor);
		
		JLabel lbImgProduto = new JLabel("");
		lbImgProduto.setIcon(new ImageIcon(IndexView.class.getResource("/icons/produtos.png")));
		lbImgProduto.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgProduto.setBounds(1, 277, 50, 48);
		pnSideBarInferior.add(lbImgProduto);
		
		JLabel lbImgFuncionario_3 = new JLabel("");
		lbImgFuncionario_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgFuncionario_3.setBounds(2, 336, 49, 48);
		pnSideBarInferior.add(lbImgFuncionario_3);
		
		JLabel lbImgVendas = new JLabel("");
		lbImgVendas.setIcon(new ImageIcon(IndexView.class.getResource("/icons/vendas.png")));
		lbImgVendas.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgVendas.setBounds(5, 336, 41, 48);
		pnSideBarInferior.add(lbImgVendas);
		
		JLabel lbImgConfiguracao = new JLabel("");
		lbImgConfiguracao.setIcon(new ImageIcon(IndexView.class.getResource("/icons/configuracoes.png")));
		lbImgConfiguracao.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgConfiguracao.setBounds(2, 395, 49, 48);
		pnSideBarInferior.add(lbImgConfiguracao);
		
		JLabel lbImgFuncionario_2 = new JLabel("");
		lbImgFuncionario_2.setIcon(new ImageIcon(IndexView.class.getResource("/icons/sair.png")));
		lbImgFuncionario_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lbImgFuncionario_2.setBounds(5, 550, 41, 48);
		pnSideBarInferior.add(lbImgFuncionario_2);
		
		JLabel lbClientes = new JLabel("Clientes");
		lbClientes.setFont(new Font("Verdana", Font.PLAIN, 14));
		lbClientes.setBounds(61, 112, 99, 29);
		pnSideBar.add(lbClientes);
		
		JLabel lb_Fucionarios = new JLabel("Fucionarios");
		lb_Fucionarios.setFont(new Font("Verdana", Font.PLAIN, 14));
		lb_Fucionarios.setBounds(61, 173, 99, 29);
		pnSideBar.add(lb_Fucionarios);
		
		JLabel lbFornecedores = new JLabel("Fornecedores");
		lbFornecedores.setFont(new Font("Verdana", Font.PLAIN, 14));
		lbFornecedores.setBounds(61, 227, 99, 29);
		pnSideBar.add(lbFornecedores);
		
		JLabel lbProdutos = new JLabel("Produtos");
		lbProdutos.setFont(new Font("Verdana", Font.PLAIN, 14));
		lbProdutos.setBounds(61, 287, 99, 29);
		pnSideBar.add(lbProdutos);
		
		JLabel lbVendas = new JLabel("Vendas");
		lbVendas.setFont(new Font("Verdana", Font.PLAIN, 14));
		lbVendas.setBounds(61, 344, 99, 29);
		pnSideBar.add(lbVendas);
		
		JLabel lblConfiguraes = new JLabel("Configurações");
		lblConfiguraes.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblConfiguraes.setBounds(61, 403, 116, 29);
		pnSideBar.add(lblConfiguraes);
		
		JLabel lblSair = new JLabel("Sair");
		lblSair.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblSair.setBounds(61, 554, 99, 29);
		pnSideBar.add(lblSair);
	}
}
