package br.com.mauro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.mauro.dao.ClientesDAO;
import br.com.mauro.model.ClienteModel;
import br.com.mauro.utils.FuncionalidadesUtils;

public class ClienteView {

	private JFrame frmClientes;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtCidade;
	private JTextField txtRua;
	private JTextField txtCep;
	private JTextField txtBairro;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtPesquisarNome;
	private JTextField txtCelular;
	private JTextField txtTelefone;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtEmail;
	private JComboBox<?> cbUf;
	private JTable tbClientes;
	
	FuncionalidadesUtils func = new FuncionalidadesUtils();

	public static void main(String[] args) {
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.err.println(ex);
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteView window = new ClienteView();
					window.frmClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	public void listarClientes() {
		
		ClientesDAO dao = new ClientesDAO();
		List<ClienteModel> ClienteLista =dao.ListaDeCliente();
		
		DefaultTableModel tbDados = (DefaultTableModel) tbClientes.getModel();
		tbDados.setNumRows(0); //limpar os dados e garantir que não tenha nada.
		
		for(ClienteModel cliente: ClienteLista) {
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

	/**
	 * @author Mauro Degaspari
	 * @return Inicialização da tela Cadastro clientes
	 */
	public ClienteView() {
		initialize();
		listarClientes(); 
	
	}


	private void initialize() {
		
		frmClientes = new JFrame();
		frmClientes.setIconImage(Toolkit.getDefaultToolkit().getImage(ClienteView.class.getResource("/icons/clientes.png")));
		frmClientes.setTitle("Clientes");
		frmClientes.setType(Type.POPUP);
	
		frmClientes.getContentPane().setBackground(new Color(255, 255, 255));
		frmClientes.setBounds(100, 100, 796, 529);
		frmClientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmClientes.getContentPane().setLayout(null);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(new Color(0, 128, 128));
		panelSuperior.setBounds(0, 0, 780, 72);
		frmClientes.getContentPane().add(panelSuperior);
		panelSuperior.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(89, 27, 161, 34);
		panelSuperior.add(lblNewLabel);
		
		JLabel lblRevenda = new JLabel("Sistema REVENDA");
		lblRevenda.setForeground(Color.WHITE);
		lblRevenda.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblRevenda.setBounds(89, 0, 161, 34);
		panelSuperior.add(lblRevenda);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClienteModel cliente = new ClienteModel();
				
					cliente.setCodigo(Integer.parseInt(txtCodigo.getText()));
					
					String nomeExluir = txtNome.getText();
					
					ClientesDAO excluirCliente = new ClientesDAO();
					excluirCliente.ExcluirCliente(cliente);
					
					listarClientes();
					
					JOptionPane.showMessageDialog(btnExcluir, "Cliente "+ nomeExluir+" Excluido",null, 1);
				
					
				} catch (Exception e2) {
					// TODO: Criar exception
				
				}
			}
		});
		btnExcluir.setBounds(681, 35, 78, 23);
		panelSuperior.add(btnExcluir);
		
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
					cliente.setComplemento(txtComplemento.getText());
					cliente.setBairro(txtBairro.getText());
					cliente.setCidade(txtCidade.getText());
					cliente.setUf("PE"); //TODO: valor chumbado, Pesquisar como usar ComboBox
					
					cliente.setCodigo(Integer.parseInt(txtCodigo.getText()));
					
					ClientesDAO editarCliente = new ClientesDAO();
					
					editarCliente.AlterarCliente(cliente);
					listarClientes();
					
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(btnEditar,"Erro: Botão SAlvar \n" + erro );
				}
			
			}
		});
		btnEditar.setBounds(593, 35, 78, 23);
		panelSuperior.add(btnEditar);
		
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
					cliente.setUf("PE"); //TODO: valor chumbado, Pesquisar como usar ComboBox
					
					ClientesDAO salvarCliente = new ClientesDAO();
					
					salvarCliente.CadastrarCliente(cliente);
					listarClientes();
					
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(btnSalvar,"Erro: Botão SAlvar \n" + erro );
				}
			}
		});
		btnSalvar.setBounds(505, 35, 78, 23);
		panelSuperior.add(btnSalvar);
		
		JButton btnLocalizarCliente = new JButton("Localizar Cliente");
		btnLocalizarCliente.setBounds(260, 35, 161, 23);
		panelSuperior.add(btnLocalizarCliente);
		
		JLabel lbLogo = new JLabel("");
		lbLogo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbLogo.setIcon(new ImageIcon(ClienteView.class.getResource("/icons/r.png")));
		lbLogo.setBounds(23, 11, 69, 50);
		panelSuperior.add(lbLogo);
		
		JTabbedPane tabbedPanePrincipal = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanePrincipal.setBounds(10, 83, 760, 396);
		frmClientes.getContentPane().add(tabbedPanePrincipal);
		
		JPanel pnDadosPessoais = new JPanel();
		pnDadosPessoais.setBackground(new Color(204, 204, 204));
		tabbedPanePrincipal.addTab("Dados pessoais", null, pnDadosPessoais, null);
		tabbedPanePrincipal.setForegroundAt(0, new Color(51, 153, 153));
		tabbedPanePrincipal.setBackgroundAt(0, new Color(255, 255, 255));
		pnDadosPessoais.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 11, 735, 72);
		pnDadosPessoais.add(panel_3);
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
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(10, 94, 735, 193);
		pnDadosPessoais.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("CEP:");
		lblNewLabel_1_2.setForeground(new Color(51, 51, 255));
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1_2.setBounds(25, 11, 36, 21);
		panel_4.add(lblNewLabel_1_2);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(280, 12, 111, 20);
		panel_4.add(txtCidade);
		
		JLabel lbRua = new JLabel("Rua:");
		lbRua.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbRua.setBounds(35, 39, 27, 21);
		panel_4.add(lbRua);
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(66, 39, 325, 20);
		panel_4.add(txtRua);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Cidade:");
		lblNewLabel_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1.setBounds(230, 12, 44, 21);
		panel_4.add(lblNewLabel_1_1_1_1);
		
		txtCep = new JTextField();
		txtCep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) { 
			         ClienteModel obj =  new ClienteModel();
			         ClientesDAO dao = new ClientesDAO();
			         obj = dao.buscaCep(txtCep.getText());
			         
			         txtRua.setText(obj.getRua());
			         txtBairro.setText(obj.getBairro());
			         txtCidade.setText(obj.getCidade());
			         cbUf.setSelectedItem(obj.getUf());               
			         System.out.println(obj.getUf());
			         
			     }
			}
		});
		txtCep.setColumns(10);
		txtCep.setBounds(66, 12, 154, 20);
		panel_4.add(txtCep);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Bairro:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1_1.setBounds(412, 12, 44, 21);
		panel_4.add(lblNewLabel_1_1_1_1_1);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(451, 11, 122, 20);
		panel_4.add(txtBairro);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Numero:");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1_2.setBounds(401, 39, 55, 21);
		panel_4.add(lblNewLabel_1_1_1_1_2);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(451, 39, 41, 20);
		panel_4.add(txtNumero);
		
		JLabel lbUf = new JLabel("UF:");
		lbUf.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbUf.setBounds(502, 39, 27, 21);
		panel_4.add(lbUf);
		
		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("Celular:");
		lblNewLabel_1_1_1_1_3.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1_3.setBounds(17, 66, 44, 21);
		panel_4.add(lblNewLabel_1_1_1_1_3);
		
		JLabel lblNewLabel_1_1_1_1_4 = new JLabel("Telefone:");
		lblNewLabel_1_1_1_1_4.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1_4.setBounds(6, 97, 55, 21);
		panel_4.add(lblNewLabel_1_1_1_1_4);
		
		JLabel lblNewLabel_1_1_1_1_4_1 = new JLabel("CPF:");
		lblNewLabel_1_1_1_1_4_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1_4_1.setBounds(35, 129, 27, 21);
		panel_4.add(lblNewLabel_1_1_1_1_4_1);
		
		JLabel lblNewLabel_1_1_1_1_4_1_1 = new JLabel("RG:");
		lblNewLabel_1_1_1_1_4_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1_4_1_1.setBounds(198, 129, 27, 21);
		panel_4.add(lblNewLabel_1_1_1_1_4_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Complemento:");
		lblNewLabel_1_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_2.setBounds(361, 129, 95, 21);
		panel_4.add(lblNewLabel_1_1_1_2);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(453, 129, 120, 20);
		panel_4.add(txtComplemento);
		
		JComboBox cbUF = new JComboBox();
		cbUF.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cbUF.setBounds(529, 38, 44, 22);
		panel_4.add(cbUF);
		
		JLabel lbEmail = new JLabel("Email:");
		lbEmail.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbEmail.setBounds(25, 161, 36, 21);
		panel_4.add(lbEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(66, 160, 285, 20);
		panel_4.add(txtEmail);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(66, 66, 122, 20);
		panel_4.add(txtCelular);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(66, 97, 122, 20);
		panel_4.add(txtTelefone);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(66, 129, 122, 20);
		panel_4.add(txtCpf);
		
		txtRg = new JTextField();
		txtRg.setColumns(10);
		txtRg.setBounds(218, 129, 133, 20);
		panel_4.add(txtRg);
		
		JPanel pnConsultaClientes = new JPanel();
		tabbedPanePrincipal.addTab("Consulta Clientes", null, pnConsultaClientes, null);
		tabbedPanePrincipal.setBackgroundAt(1, new Color(255, 255, 255));
		tabbedPanePrincipal.setForegroundAt(1, new Color(0, 153, 153));
		pnConsultaClientes.setLayout(null);
		
		JLabel lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbNome.setBounds(10, 11, 41, 21);
		pnConsultaClientes.add(lbNome);
		
		txtPesquisarNome = new JTextField();
		txtPesquisarNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
	String nome = "%"+txtPesquisarNome.getText()+"%";
				
				ClientesDAO dao = new ClientesDAO();
				List<ClienteModel> Lista =dao.PesquisaClienteNome(nome);
				
				DefaultTableModel tbDados = (DefaultTableModel) tbClientes.getModel();
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
		txtPesquisarNome.setColumns(10);
		txtPesquisarNome.setBounds(56, 12, 388, 20);
		pnConsultaClientes.add(txtPesquisarNome);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = "%"+txtPesquisarNome.getText()+"%";
				
				ClientesDAO dao = new ClientesDAO();
				List<ClienteModel> Lista =dao.PesquisaClienteNome(nome);
				
				DefaultTableModel tbDados = (DefaultTableModel) tbClientes.getModel();
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
		btnPesquisar.setBounds(459, 10, 89, 23);
		pnConsultaClientes.add(btnPesquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 735, 253);
		pnConsultaClientes.add(scrollPane);
			
		tbClientes = new JTable();
		tbClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			
				tabbedPanePrincipal.setSelectedIndex(0);
			
			//	txtCodigo.setText(tbClientes.getValueAt(tbClientes.getSelectedRow(), 0).toString());
				
				txtCodigo.setText(func.trantandoValor(tbClientes, tbClientes.getSelectedRow(), 0));
				txtNome.setText(func.trantandoValor(tbClientes, tbClientes.getSelectedRow(), 1));
				txtRg.setText(func.trantandoValor(tbClientes, tbClientes.getSelectedRow(), 2));
				txtCpf.setText(func.trantandoValor(tbClientes, tbClientes.getSelectedRow(), 3));
				txtEmail.setText(func.trantandoValor(tbClientes, tbClientes.getSelectedRow(), 4));
				txtTelefone.setText(func.trantandoValor(tbClientes, tbClientes.getSelectedRow(), 5));
				txtCelular.setText(func.trantandoValor(tbClientes, tbClientes.getSelectedRow(), 6));
				txtCep.setText(func.trantandoValor(tbClientes, tbClientes.getSelectedRow(), 7));
				txtRua.setText(func.trantandoValor(tbClientes, tbClientes.getSelectedRow(), 8));
				txtNumero.setText(func.trantandoValor(tbClientes, tbClientes.getSelectedRow(), 9));
				txtComplemento.setText(func.trantandoValor(tbClientes, tbClientes.getSelectedRow(), 10));
				txtBairro.setText(func.trantandoValor(tbClientes, tbClientes.getSelectedRow(), 11));
				txtCidade.setText(func.trantandoValor(tbClientes, tbClientes.getSelectedRow(), 12));
				cbUF.setToolTipText(func.trantandoValor(tbClientes, tbClientes.getSelectedRow(), 13));
			}
		});
		scrollPane.setViewportView(tbClientes);
		tbClientes.setModel(new DefaultTableModel(
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
		tbClientes.getColumnModel().getColumn(6).setPreferredWidth(81);
		tbClientes.getColumnModel().getColumn(7).setPreferredWidth(50);
		tbClientes.getColumnModel().getColumn(8).setPreferredWidth(87);
		tbClientes.getColumnModel().getColumn(9).setPreferredWidth(37);
		tbClientes.getColumnModel().getColumn(10).setPreferredWidth(110);
	}
}
