package br.com.mauro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import br.com.mauro.dao.FornecedoresDAO;
import br.com.mauro.model.FornecedoresModel;

public class FornecedorView {

	private JFrame frmFornecedor;
	private JTextField txtEmpresa;
	private JTextField txtCNPJ;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtEmail;
	private JTextField txtSite;
	private JTextField txtCelular;
	private JTextField txtTelefone;
	private JTextField textField_6;
	private JTextField txtCep;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtRua;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTable tbFornecedores;
	private JTextField txtPesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FornecedorView window = new FornecedorView();
					window.frmFornecedor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FornecedorView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFornecedor = new JFrame();
		frmFornecedor.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frmFornecedor.setIconImage(Toolkit.getDefaultToolkit().getImage(FornecedorView.class.getResource("/icons/fornecedores.png")));
		frmFornecedor.setTitle("Fornecedor");
		frmFornecedor.setBounds(100, 100, 791, 736);
		frmFornecedor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFornecedor.getContentPane().setLayout(null);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBounds(0, 0, 775, 72);
		panelSuperior.setLayout(null);
		panelSuperior.setBackground(new Color(0, 128, 128));
		frmFornecedor.getContentPane().add(panelSuperior);
		
		JLabel lbFornecedor = new JLabel("Fornecedores");
		lbFornecedor.setForeground(Color.WHITE);
		lbFornecedor.setFont(new Font("Verdana", Font.BOLD, 22));
		lbFornecedor.setBounds(58, 7, 191, 34);
		panelSuperior.add(lbFornecedor);
		
		JLabel lblRevenda = new JLabel("Sistema REVENDA");
		lblRevenda.setForeground(Color.WHITE);
		lblRevenda.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblRevenda.setBounds(265, 1, 161, 34);
		panelSuperior.add(lblRevenda);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(681, 35, 78, 23);
		panelSuperior.add(btnExcluir);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(593, 35, 78, 23);
		panelSuperior.add(btnEditar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					FornecedoresModel fornec = new FornecedoresModel();
					
					fornec.setNome(txtEmpresa.getText());
					fornec.setCnpj(txtCNPJ.getText());
					fornec.setEmail(txtEmail.getText());
					fornec.setTelefone(txtTelefone.getText());
					fornec.setCelular(txtCelular.getText());
					fornec.setCep(txtCep.getText());
					fornec.setRua(txtRua.getText());
					fornec.setNumero(Integer.parseInt(txtNumero.getText()));
					fornec.setComplemento(txtComplemento.getText());
					fornec.setBairro(txtBairro.getText());
					fornec.setCidade(txtCidade.getText());
					fornec.setUf("PE");
					
					FornecedoresDAO dao = new FornecedoresDAO();
					
					dao.CadastrarFornecedor(fornec);
					
				} catch (Exception erro) {
					
					JOptionPane.showMessageDialog(null," ERRO AO SALVAR FONECEDOR: "+ erro);
				}
				
			}
		});
		btnSalvar.setBounds(505, 35, 78, 23);
		panelSuperior.add(btnSalvar);
		
		JButton btnLocalizarFornecedor = new JButton("Localizar Fornecedor");
		btnLocalizarFornecedor.setBounds(260, 35, 161, 23);
		panelSuperior.add(btnLocalizarFornecedor);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon(FornecedorView.class.getResource("/icons/r.png")));
		lbLogo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbLogo.setBounds(7, 6, 48, 38);
		panelSuperior.add(lbLogo);
		
		JTabbedPane tabbedPanePrincipal = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanePrincipal.setBounds(10, 83, 755, 603);
		frmFornecedor.getContentPane().add(tabbedPanePrincipal);
		
		JPanel pnGeral = new JPanel();
		tabbedPanePrincipal.addTab("Geral", null, pnGeral, null);
		pnGeral.setLayout(null);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setBounds(97, 54, 228, 20);
		pnGeral.add(txtEmpresa);
		txtEmpresa.setColumns(10);
		
		txtCNPJ = new JTextField();
		txtCNPJ.setColumns(10);
		txtCNPJ.setBounds(97, 85, 228, 20);
		pnGeral.add(txtCNPJ);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 116, 141, 20);
		pnGeral.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(97, 147, 228, 20);
		pnGeral.add(textField_3);
		
		JLabel lbEmpresa = new JLabel("Empresa:");
		lbEmpresa.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbEmpresa.setBounds(20, 60, 67, 14);
		pnGeral.add(lbEmpresa);
		
		JLabel lbCNPJ = new JLabel("CNPJ:");
		lbCNPJ.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbCNPJ.setBounds(20, 88, 67, 14);
		pnGeral.add(lbCNPJ);
		
		JLabel lbEstadual = new JLabel("Isc. Estadual:");
		lbEstadual.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbEstadual.setBounds(10, 119, 95, 14);
		pnGeral.add(lbEstadual);
		
		JLabel lbFantasia = new JLabel("Nome Fantasia:");
		lbFantasia.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbFantasia.setBounds(10, 150, 95, 14);
		pnGeral.add(lbFantasia);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 11, 315, 37);
		pnGeral.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("CNPJ");
		rdbtnNewRadioButton.setBounds(122, 7, 65, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("CPF");
		rdbtnNewRadioButton_1.setBounds(189, 7, 51, 23);
		panel.add(rdbtnNewRadioButton_1);
		
		JLabel lblTipoDePessoa = new JLabel("Tipo de Pessoa:");
		lblTipoDePessoa.setBounds(10, 11, 139, 14);
		panel.add(lblTipoDePessoa);
		
		JLabel lblPrincipaisContato = new JLabel("Contato Principal");
		lblPrincipaisContato.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrincipaisContato.setBounds(20, 203, 132, 14);
		pnGeral.add(lblPrincipaisContato);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbNome.setBounds(20, 228, 46, 14);
		pnGeral.add(lbNome);
		
		textField = new JTextField();
		textField.setBounds(98, 228, 190, 20);
		pnGeral.add(textField);
		textField.setColumns(10);
		
		JLabel lbCargo = new JLabel("Cargo:");
		lbCargo.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbCargo.setBounds(19, 253, 46, 14);
		pnGeral.add(lbCargo);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 253, 191, 20);
		pnGeral.add(textField_1);
		
		JLabel lblAnotacao = new JLabel("Anotações");
		lblAnotacao.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblAnotacao.setBounds(334, 228, 101, 14);
		pnGeral.add(lblAnotacao);
		
		JEditorPane editorPaneAnotacao = new JEditorPane();
		editorPaneAnotacao.setBounds(334, 247, 387, 169);
		pnGeral.add(editorPaneAnotacao);
		
		JLabel lbEmail = new JLabel("Email:");
		lbEmail.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbEmail.setBounds(453, 54, 46, 14);
		pnGeral.add(lbEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(531, 54, 190, 20);
		pnGeral.add(txtEmail);
		
		JLabel lbSite = new JLabel("Site:");
		lbSite.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbSite.setBounds(452, 79, 46, 14);
		pnGeral.add(lbSite);
		
		txtSite = new JTextField();
		txtSite.setColumns(10);
		txtSite.setBounds(530, 79, 191, 20);
		pnGeral.add(txtSite);
		
		JLabel lblNewLabel = new JLabel("Contatos");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 320, 75, 14);
		pnGeral.add(lblNewLabel);
		
		JLabel lbCelular = new JLabel("Celular:");
		lbCelular.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbCelular.setBounds(21, 345, 46, 14);
		pnGeral.add(lbCelular);
		
		JLabel lbTelefone = new JLabel("Telefone:");
		lbTelefone.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbTelefone.setBounds(20, 370, 47, 14);
		pnGeral.add(lbTelefone);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(99, 345, 190, 20);
		pnGeral.add(txtCelular);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(98, 370, 191, 20);
		pnGeral.add(txtTelefone);
		
		JLabel lbTelefone2 = new JLabel("lbTelefone2:");
		lbTelefone2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbTelefone2.setBounds(22, 396, 66, 14);
		pnGeral.add(lbTelefone2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(100, 396, 190, 20);
		pnGeral.add(textField_6);
		
		JLabel lbCEP = new JLabel("CEP:");
		lbCEP.setForeground(new Color(51, 51, 255));
		lbCEP.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lbCEP.setBounds(10, 469, 36, 21);
		pnGeral.add(lbCEP);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(51, 470, 154, 20);
		pnGeral.add(txtCep);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(231, 527, 111, 20);
		pnGeral.add(txtCidade);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(49, 528, 122, 20);
		pnGeral.add(txtBairro);
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(51, 497, 325, 20);
		pnGeral.add(txtRua);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(436, 497, 41, 20);
		pnGeral.add(txtNumero);
		
		JComboBox cbUF = new JComboBox();
		cbUF.setBounds(514, 496, 44, 22);
		pnGeral.add(cbUF);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(315, 469, 243, 20);
		pnGeral.add(txtComplemento);
		
		JLabel lbComplemento = new JLabel("Complemento:");
		lbComplemento.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbComplemento.setBounds(223, 469, 95, 21);
		pnGeral.add(lbComplemento);
		
		JLabel lbNUmero = new JLabel("Numero:");
		lbNUmero.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbNUmero.setBounds(386, 497, 55, 21);
		pnGeral.add(lbNUmero);
		
		JLabel lbBairro = new JLabel("Bairro:");
		lbBairro.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbBairro.setBounds(10, 529, 44, 21);
		pnGeral.add(lbBairro);
		
		JLabel lbCidade = new JLabel("Cidade:");
		lbCidade.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbCidade.setBounds(181, 527, 44, 21);
		pnGeral.add(lbCidade);
		
		JLabel lbRua = new JLabel("Rua:");
		lbRua.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbRua.setBounds(20, 497, 27, 21);
		pnGeral.add(lbRua);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndereo.setBounds(20, 444, 75, 14);
		pnGeral.add(lblEndereo);
		
		JLabel lbUf = new JLabel("UF:");
		lbUf.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbUf.setBounds(487, 500, 27, 21);
		pnGeral.add(lbUf);
		
		JPanel pnFornecedores = new JPanel();
		tabbedPanePrincipal.addTab("Fornecedores", null, pnFornecedores, null);
		pnFornecedores.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 730, 356);
		pnFornecedores.add(scrollPane);
		
		tbFornecedores = new JTable();
		tbFornecedores.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Fornecedor"
			}
		));
		scrollPane.setViewportView(tbFornecedores);
		
		JLabel lbFornecedorPesquisa = new JLabel("Fornecedor:");
		lbFornecedorPesquisa.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbFornecedorPesquisa.setBounds(160, 84, 66, 21);
		pnFornecedores.add(lbFornecedorPesquisa);
		
		txtPesquisa = new JTextField();
		txtPesquisa.setColumns(10);
		txtPesquisa.setBounds(236, 84, 388, 20);
		pnFornecedores.add(txtPesquisa);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(639, 82, 89, 23);
		pnFornecedores.add(btnPesquisar);
		
	}
}
