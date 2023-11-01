package br.com.mauro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.mauro.dao.ClientesDAO;
import br.com.mauro.dao.FuncionarioDAO;
import br.com.mauro.model.ClienteModel;
import br.com.mauro.model.FuncionarioModel;

public class FuncionarioView {

	private JFrame frame;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtCep;
	private JTextField txtRua;
	private JTextField txtCelular;
	private JTextField txtTelefone;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtRg;
	private JTextField txtComplemento;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtNumero;
	private JTextField txtPesquisarNome;
	private JTable tbFuncionarios_1;
	private JPasswordField pswSenha;
	private JTextField txtCargo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionarioView window = new FuncionarioView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * @author Mauro Degaspari
	 * @return O Valor relacionado a linha do JTable tbClientes, caso não 
	 * 		   tenha valor retorne uma String " ". 
	 */
	private String trantandoValor(JTable table, int row, int column) {
		Object linha = table.getValueAt(row, column);
		return linha != null ? linha.toString() : "";
	}
	
	public void listarFuncionarios() {
		FuncionarioDAO dao = new FuncionarioDAO(); 
		
		List<FuncionarioModel> listaFunc = dao.ListarFuncionarios();
		
		DefaultTableModel tbDados = (DefaultTableModel) tbFuncionarios_1.getModel();
		tbDados.setNumRows(0); //limpar os dados e garantir que não tenha nada.
		
		for(FuncionarioModel func: listaFunc) {
			tbDados.addRow(new Object[]{
				func.getCodigo(),
				func.getNome(),
				func.getRg(),
				func.getCpf(),
				func.getEmail(),
				func.getSenha(),
				func.getCargo(),
				func.getNivel(),
				func.getTelefone(),
				func.getCelular(),
				func.getCep(),
				func.getRua(),
				func.getNumero(),
				func.getComplemento(),
				func.getBairro(),
				func.getCidade(),
				func.getUf()
			
			
			});
		}
	}

	/**
	 * Create the application.
	 */
	public FuncionarioView() {
		initialize();
		listarFuncionarios();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
	
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 922, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 153));
		panel.setBounds(0, 0, 906, 72);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblFuncionario = new JLabel("Cadastro de Funcionarios");
		lblFuncionario.setFont(new Font("Verdana", Font.BOLD, 13));
		lblFuncionario.setForeground(new Color(255, 255, 255));
		lblFuncionario.setBounds(89, 27, 195, 34);
		panel.add(lblFuncionario);
		
		JLabel lblRevenda = new JLabel("Sistema REVENDA");
		lblRevenda.setForeground(Color.WHITE);
		lblRevenda.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblRevenda.setBounds(89, 0, 161, 34);
		panel.add(lblRevenda);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClienteModel cliente = new ClienteModel();
				
					cliente.setCodigo(Integer.parseInt(txtCodigo.getText()));
					
					ClientesDAO excluirCliente = new ClientesDAO();
					excluirCliente.ExcluirCliente(cliente);				
					
					JOptionPane.showMessageDialog(btnExcluir, "Cliente "+cliente.getNome()+" Excluido",null, 0);
					
				} catch (Exception e2) {
					// TODO: Criar exception
				
				}
			}
		});
		btnExcluir.setBounds(681, 35, 78, 23);
		panel.add(btnExcluir);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
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
					cliente.setUf("PE"); //TODO: valor chumbado, Pesquisar como usar ComboBox
					
					cliente.setCodigo(Integer.parseInt(txtCodigo.getText()));
					
					ClientesDAO editarCliente = new ClientesDAO();
					
					editarCliente.AlterarCliente(cliente);
					
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(btnEditar,"Erro: Botão SAlvar \n" + erro );
				}
			
			}
		});
		btnEditar.setBounds(593, 35, 78, 23);
		panel.add(btnEditar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FuncionarioModel Funcionario = new FuncionarioModel();
				
					Funcionario.setNome(txtNome.getText());
					Funcionario.setRg(txtRg.getText());
					Funcionario.setCpf(txtCpf.getText());
					Funcionario.setEmail(txtEmail.getText());
					Funcionario.setSenha(pswSenha.getText());
					Funcionario.setCargo(txtCargo.getText());
					Funcionario.setNivel("N");//TODO NIVEL DE FUNCIONARIO, fazer tratativa
					Funcionario.setTelefone(txtTelefone.getText());
					Funcionario.setCelular(txtCelular.getText());
					Funcionario.setCep(txtCep.getText());
					Funcionario.setRua(txtRua.getText());
					Funcionario.setNumero(Integer.parseInt(txtNumero.getText()));
					Funcionario.setBairro(txtBairro.getText());
					Funcionario.setCidade(txtCidade.getText());
					Funcionario.setUf("PE"); //TODO: valor chumbado, Pesquisar como usar ComboBox
					
					FuncionarioDAO CadastraFuncionario = new FuncionarioDAO();
					
					CadastraFuncionario.cadastroFuncionario(Funcionario);
					
					JOptionPane.showMessageDialog(btnSalvar, "Funcionario: "+ Funcionario.getNome() +" Cadastrado Com Sucesso!");
					
					listarFuncionarios();
					
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
		
		JTabbedPane PainelPrincipal = new JTabbedPane(JTabbedPane.TOP);
		PainelPrincipal.setBounds(10, 83, 886, 396);
		frame.getContentPane().add(PainelPrincipal);
		
		JPanel pnDadosPessoais = new JPanel();
		pnDadosPessoais.setBackground(new Color(204, 204, 204));
		PainelPrincipal.addTab("Dados pessoais", null, pnDadosPessoais, null);
		PainelPrincipal.setForegroundAt(0, new Color(51, 153, 153));
		PainelPrincipal.setBackgroundAt(0, new Color(255, 255, 255));
		pnDadosPessoais.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 11, 861, 72);
		pnDadosPessoais.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Código:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(10, 11, 49, 21);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome:");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(18, 40, 41, 21);
		panel_3.add(lblNewLabel_1_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(56, 11, 140, 20);
		panel_3.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(56, 43, 247, 20);
		panel_3.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lbSenha = new JLabel("Senha:");
		lbSenha.setBounds(645, 11, 41, 14);
		panel_3.add(lbSenha);
		
		pswSenha = new JPasswordField();
		pswSenha.setBounds(690, 11, 120, 20);
		panel_3.add(pswSenha);
		
		JLabel lbCargo = new JLabel("Cargo:");
		lbCargo.setBounds(471, 14, 34, 14);
		panel_3.add(lbCargo);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(515, 11, 120, 20);
		panel_3.add(txtCargo);
		txtCargo.setColumns(10);
		
		JLabel lbNivelAcesso = new JLabel("Nivel De Acesso:");
		lbNivelAcesso.setBounds(416, 43, 101, 14);
		panel_3.add(lbNivelAcesso);
		
		JComboBox cbNivel = new JComboBox();
		cbNivel.setModel(new DefaultComboBoxModel(new String[] {"Funcionario", "Administrador"}));
		cbNivel.setBounds(515, 39, 295, 22);
		panel_3.add(cbNivel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(10, 94, 861, 193);
		pnDadosPessoais.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lbCep = new JLabel("CEP:");
		lbCep.setForeground(new Color(51, 51, 255));
		lbCep.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lbCep.setBounds(25, 11, 36, 21);
		panel_4.add(lbCep);
		
		JLabel lbRua = new JLabel("Rua:");
		lbRua.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbRua.setBounds(25, 39, 27, 21);
		panel_4.add(lbRua);
		
		JLabel lbCidade = new JLabel("Cidade:");
		lbCidade.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbCidade.setBounds(198, 12, 44, 21);
		panel_4.add(lbCidade);
		
		JLabel lbBairro = new JLabel("Bairro:");
		lbBairro.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbBairro.setBounds(372, 12, 44, 21);
		panel_4.add(lbBairro);
		
		JLabel lbNumero = new JLabel("Numero:");
		lbNumero.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbNumero.setBounds(361, 39, 55, 21);
		panel_4.add(lbNumero);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("UF:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1_1_1.setBounds(479, 40, 27, 21);
		panel_4.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lbCelular = new JLabel("Celular:");
		lbCelular.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbCelular.setBounds(17, 66, 44, 21);
		panel_4.add(lbCelular);
		
		JLabel lbTelefone = new JLabel("Telefone:");
		lbTelefone.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbTelefone.setBounds(6, 97, 55, 21);
		panel_4.add(lbTelefone);
		
		JLabel lbCpf = new JLabel("CPF:");
		lbCpf.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbCpf.setBounds(35, 129, 27, 21);
		panel_4.add(lbCpf);
		
		JLabel lbRg = new JLabel("RG:");
		lbRg.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbRg.setBounds(198, 129, 27, 21);
		panel_4.add(lbRg);
		
		JLabel lbComplemento = new JLabel("Complemento:");
		lbComplemento.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbComplemento.setBounds(361, 129, 84, 21);
		panel_4.add(lbComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(453, 129, 97, 20);
		panel_4.add(txtComplemento);
		
		JComboBox cbUF = new JComboBox();
		cbUF.setModel(new DefaultComboBoxModel(new String[] {"PE", "SP", "TO"}));
		cbUF.setBounds(506, 39, 44, 22);
		panel_4.add(cbUF);
		
		JLabel lbEmail = new JLabel("Email:");
		lbEmail.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbEmail.setBounds(25, 161, 36, 21);
		panel_4.add(lbEmail);
		
		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(227, 129, 128, 20);
		panel_4.add(txtRg);
		
		txtCep = new JTextField();
		txtCep.setBounds(61, 12, 128, 20);
		panel_4.add(txtCep);
		txtCep.setColumns(10);
		
		txtRua = new JTextField();
		txtRua.setBounds(61, 39, 293, 20);
		panel_4.add(txtRua);
		txtRua.setColumns(10);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(61, 66, 163, 20);
		panel_4.add(txtCelular);
		txtCelular.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(61, 97, 164, 20);
		panel_4.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(61, 129, 127, 20);
		panel_4.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(61, 161, 235, 20);
		panel_4.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtRg = new JTextField();
		txtRg.setBounds(227, 129, 124, 20);
		panel_4.add(txtRg);
		txtRg.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(246, 12, 109, 20);
		panel_4.add(txtCidade);
		txtCidade.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(420, 12, 130, 20);
		panel_4.add(txtBairro);
		txtBairro.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(420, 39, 49, 20);
		panel_4.add(txtNumero);
		txtNumero.setColumns(10);
		
		JPanel pnConsultaClientes = new JPanel();
		PainelPrincipal.addTab("Consulta Funcionarios", null, pnConsultaClientes, null);
		PainelPrincipal.setBackgroundAt(1, new Color(255, 255, 255));
		PainelPrincipal.setForegroundAt(1, new Color(0, 153, 153));
		pnConsultaClientes.setLayout(null);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbNome.setBounds(333, 12, 41, 21);
		pnConsultaClientes.add(lbNome);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = "%"+txtPesquisarNome.getText()+"%";
				
				ClientesDAO dao = new ClientesDAO();
				List<ClienteModel> Lista =dao.PesquisaClienteNome(nome);
				
				DefaultTableModel tbDados = (DefaultTableModel) tbFuncionarios_1.getModel();
				tbDados.setNumRows(0); //limpar os dados e garantir que não tenha nada.
				
				for(ClienteModel cliente: Lista) {
					tbDados.addRow(new Object[]{
						cliente.getCodigo(),
						cliente.getNome(),
						cliente.getRg(),
						cliente.getCpf(),
						cliente.getEmail(),
						cliente.getTelefone(),
						cliente.getCelular(),
						cliente.getCep(),
						cliente.getRua(),
						cliente.getNumero(),
						cliente.getComplemento(),
						cliente.getBairro(),
						cliente.getCidade(),
						cliente.getUf()				
					});
				}
				
			}
		});
		btnPesquisar.setBounds(782, 11, 89, 23);
		pnConsultaClientes.add(btnPesquisar);
		
		txtPesquisarNome = new JTextField();
		txtPesquisarNome.setBounds(375, 12, 160, 20);
		pnConsultaClientes.add(txtPesquisarNome);
		txtPesquisarNome.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 861, 241);
		pnConsultaClientes.add(scrollPane);
		
		tbFuncionarios_1 = new JTable();
		tbFuncionarios_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PainelPrincipal.setSelectedIndex(0);
				
				//	txtCodigo.setText(tbFuncionarios_1.getValueAt(tbFuncionarios_1.getSelectedRow(), 0).toString());
					
					txtCodigo.setText(trantandoValor(tbFuncionarios_1, tbFuncionarios_1.getSelectedRow(), 0));
					txtNome.setText(trantandoValor(tbFuncionarios_1, tbFuncionarios_1.getSelectedRow(), 1));
					txtRg.setText(trantandoValor(tbFuncionarios_1, tbFuncionarios_1.getSelectedRow(), 2));
					txtCpf.setText(trantandoValor(tbFuncionarios_1, tbFuncionarios_1.getSelectedRow(), 3));
					txtEmail.setText(trantandoValor(tbFuncionarios_1, tbFuncionarios_1.getSelectedRow(), 4));
					txtTelefone.setText(trantandoValor(tbFuncionarios_1, tbFuncionarios_1.getSelectedRow(), 5));
					txtCelular.setText(trantandoValor(tbFuncionarios_1, tbFuncionarios_1.getSelectedRow(), 6));
					txtCep.setText(trantandoValor(tbFuncionarios_1, tbFuncionarios_1.getSelectedRow(), 7));
					txtRua.setText(trantandoValor(tbFuncionarios_1, tbFuncionarios_1.getSelectedRow(), 8));
					txtNumero.setText(trantandoValor(tbFuncionarios_1, tbFuncionarios_1.getSelectedRow(), 9));
					txtComplemento.setText(trantandoValor(tbFuncionarios_1, tbFuncionarios_1.getSelectedRow(), 10));
					txtBairro.setText(trantandoValor(tbFuncionarios_1, tbFuncionarios_1.getSelectedRow(), 11));
					txtCidade.setText(trantandoValor(tbFuncionarios_1, tbFuncionarios_1.getSelectedRow(), 12));
					cbUF.setToolTipText(trantandoValor(tbFuncionarios_1, tbFuncionarios_1.getSelectedRow(), 13));
			}
		});
		tbFuncionarios_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome", "RG", "CPF", "Email", "Telefone", "Celular", "Cep", "Rua", "Numero", "Complemento", "Bairro", "Cidade", "TEste", "UF"
			}
		));
		tbFuncionarios_1.getColumnModel().getColumn(10).setPreferredWidth(81);
		tbFuncionarios_1.getColumnModel().getColumn(11).setPreferredWidth(50);
		tbFuncionarios_1.getColumnModel().getColumn(12).setPreferredWidth(87);
		tbFuncionarios_1.getColumnModel().getColumn(14).setPreferredWidth(37);
		scrollPane.setViewportView(tbFuncionarios_1);
		tbFuncionarios_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"C\u00F3digo", "Nome", "RG", "CPF", "Email", "Telefone", "Celular", "Cep", "Rua", "Numero", "Complemento", "Bairro", "Cidade", "UF"
			}
		) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, false, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}
}
