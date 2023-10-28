package br.com.mauro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.mauro.dao.ClientesDAO;
import br.com.mauro.model.ClienteModel;
import javax.swing.DefaultComboBoxModel;

public class ClienteView {

	private JFrame frame;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtCidade;
	private JTextField txtRua;
	private JTextField txtCep;
	private JTextField txtBairro;
	private JTextField txtNumero;
	private JTextField tfComplemento;
	private JTextField textField_8;
	private JTextField txtCelular;
	private JTextField txtTelefone;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtEmail;
	private JTable table;

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteView window = new ClienteView();
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
	public ClienteView() {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 796, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 153));
		panel.setBounds(0, 0, 780, 72);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(89, 27, 161, 34);
		panel.add(lblNewLabel);
		
		JLabel lblRevenda = new JLabel("Sistema REVENDA");
		lblRevenda.setForeground(Color.WHITE);
		lblRevenda.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblRevenda.setBounds(89, 0, 161, 34);
		panel.add(lblRevenda);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(681, 35, 78, 23);
		panel.add(btnExcluir);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(593, 35, 78, 23);
		panel.add(btnLimpar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClienteModel cliente = new ClienteModel();
				
					cliente.setNome(txtNome.getText());
					cliente.setRg(txtRg.getText());
					cliente.setCpf(txtCpf.getText());
					cliente.setEmail(txtEmail.getText());
					cliente.setTelefone(txtTelefone.getText());
					cliente.setCelular(txtCelular.getText());
					cliente.setCep(txtCep.getText());
					cliente.setRua(txtRua.getText());
					cliente.setNumero(Integer.parseInt(txtNumero.getText()));
					cliente.setBairro(txtBairro.getText());
					cliente.setCidade(txtCidade.getText());
					cliente.setUf("PE");
					
					ClientesDAO salvarCliente = new ClientesDAO();
					
					salvarCliente.CadastrarCliente(cliente);
					
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(btnSalvar,"Erro: Botão SAlvar \n" + erro );
				}
			}
		});
		btnSalvar.setBounds(505, 35, 78, 23);
		panel.add(btnSalvar);
		
		JButton btnLocalizarCliente = new JButton("Localizar Cliente");
		btnLocalizarCliente.setBounds(334, 35, 161, 23);
		panel.add(btnLocalizarCliente);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 83, 760, 396);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		tabbedPane.addTab("Dados pessoais", null, panel_1, null);
		tabbedPane.setForegroundAt(0, new Color(51, 153, 153));
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 11, 735, 72);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Código:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(10, 11, 49, 21);
		panel_3.add(lblNewLabel_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(64, 12, 154, 20);
		panel_3.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome:");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(18, 40, 41, 21);
		panel_3.add(lblNewLabel_1_1);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(64, 41, 388, 20);
		panel_3.add(txtNome);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(255, 255, 255));
		panel_3_1.setBounds(10, 94, 735, 193);
		panel_1.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("CEP:");
		lblNewLabel_1_2.setForeground(new Color(51, 51, 255));
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_2.setBounds(25, 11, 36, 21);
		panel_3_1.add(lblNewLabel_1_2);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(280, 12, 111, 20);
		panel_3_1.add(txtCidade);
		
		JLabel lbRua = new JLabel("Rua:");
		lbRua.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbRua.setBounds(35, 39, 27, 21);
		panel_3_1.add(lbRua);
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(66, 39, 325, 20);
		panel_3_1.add(txtRua);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Cidade:");
		lblNewLabel_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1.setBounds(230, 12, 44, 21);
		panel_3_1.add(lblNewLabel_1_1_1_1);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(66, 12, 154, 20);
		panel_3_1.add(txtCep);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Bairro:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1_1.setBounds(412, 12, 44, 21);
		panel_3_1.add(lblNewLabel_1_1_1_1_1);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(451, 11, 122, 20);
		panel_3_1.add(txtBairro);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Numero:");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1_2.setBounds(401, 39, 55, 21);
		panel_3_1.add(lblNewLabel_1_1_1_1_2);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(451, 39, 41, 20);
		panel_3_1.add(txtNumero);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("UF:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1_1_1.setBounds(502, 39, 27, 21);
		panel_3_1.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("Celular:");
		lblNewLabel_1_1_1_1_3.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1_3.setBounds(17, 66, 44, 21);
		panel_3_1.add(lblNewLabel_1_1_1_1_3);
		
		JLabel lblNewLabel_1_1_1_1_4 = new JLabel("Telefone:");
		lblNewLabel_1_1_1_1_4.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1_4.setBounds(6, 97, 55, 21);
		panel_3_1.add(lblNewLabel_1_1_1_1_4);
		
		JLabel lblNewLabel_1_1_1_1_4_1 = new JLabel("CPF:");
		lblNewLabel_1_1_1_1_4_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1_4_1.setBounds(35, 129, 27, 21);
		panel_3_1.add(lblNewLabel_1_1_1_1_4_1);
		
		JLabel lblNewLabel_1_1_1_1_4_1_1 = new JLabel("RG:");
		lblNewLabel_1_1_1_1_4_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1_4_1_1.setBounds(198, 129, 27, 21);
		panel_3_1.add(lblNewLabel_1_1_1_1_4_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Complemento:");
		lblNewLabel_1_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_2.setBounds(361, 129, 95, 21);
		panel_3_1.add(lblNewLabel_1_1_1_2);
		
		tfComplemento = new JTextField();
		tfComplemento.setColumns(10);
		tfComplemento.setBounds(453, 129, 120, 20);
		panel_3_1.add(tfComplemento);
		
		JComboBox cbUF = new JComboBox();
		cbUF.setModel(new DefaultComboBoxModel(new String[] {"PE", "SP", "TO"}));
		cbUF.setBounds(529, 38, 44, 22);
		panel_3_1.add(cbUF);
		
		JLabel lbEmail = new JLabel("Email:");
		lbEmail.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbEmail.setBounds(25, 161, 36, 21);
		panel_3_1.add(lbEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(66, 160, 285, 20);
		panel_3_1.add(txtEmail);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(66, 66, 122, 20);
		panel_3_1.add(txtCelular);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(66, 97, 122, 20);
		panel_3_1.add(txtTelefone);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(66, 129, 122, 20);
		panel_3_1.add(txtCpf);
		
		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(218, 129, 133, 20);
		panel_3_1.add(txtRg);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Consulta Clientes", null, panel_2, null);
		tabbedPane.setBackgroundAt(1, new Color(255, 255, 255));
		tabbedPane.setForegroundAt(1, new Color(0, 153, 153));
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Nome:");
		lblNewLabel_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_2.setBounds(10, 11, 41, 21);
		panel_2.add(lblNewLabel_1_1_2);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(56, 12, 388, 20);
		panel_2.add(textField_8);
		
		JButton btnNewButton = new JButton("Pesquisa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(459, 10, 89, 23);
		panel_2.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(10, 70, 735, 226);
		panel_2.add(table);
	}
}
