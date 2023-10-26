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
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ClienteView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
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
		
		textField = new JTextField();
		textField.setBounds(64, 12, 154, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome:");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(18, 40, 41, 21);
		panel_3.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(64, 41, 388, 20);
		panel_3.add(textField_1);
		
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
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(280, 12, 111, 20);
		panel_3_1.add(textField_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Endereço:");
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1.setBounds(6, 39, 55, 21);
		panel_3_1.add(lblNewLabel_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(66, 39, 325, 20);
		panel_3_1.add(textField_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Cidade:");
		lblNewLabel_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1.setBounds(230, 12, 44, 21);
		panel_3_1.add(lblNewLabel_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(66, 12, 154, 20);
		panel_3_1.add(textField_4);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Bairro:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1_1.setBounds(412, 12, 44, 21);
		panel_3_1.add(lblNewLabel_1_1_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(451, 11, 122, 20);
		panel_3_1.add(textField_5);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Numero:");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1_2.setBounds(401, 39, 55, 21);
		panel_3_1.add(lblNewLabel_1_1_1_1_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(451, 39, 41, 20);
		panel_3_1.add(textField_6);
		
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
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setToolTipText("");
		formattedTextField.setHorizontalAlignment(SwingConstants.LEFT);
		formattedTextField.setBounds(66, 66, 122, 20);
		panel_3_1.add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(66, 97, 122, 20);
		panel_3_1.add(formattedTextField_1);
		
		JFormattedTextField formattedTextField_1_1 = new JFormattedTextField();
		formattedTextField_1_1.setBounds(66, 129, 122, 20);
		panel_3_1.add(formattedTextField_1_1);
		
		JLabel lblNewLabel_1_1_1_1_4_1_1 = new JLabel("RG:");
		lblNewLabel_1_1_1_1_4_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_1_4_1_1.setBounds(198, 129, 27, 21);
		panel_3_1.add(lblNewLabel_1_1_1_1_4_1_1);
		
		JFormattedTextField formattedTextField_1_1_1 = new JFormattedTextField();
		formattedTextField_1_1_1.setBounds(229, 129, 122, 20);
		panel_3_1.add(formattedTextField_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Complemento:");
		lblNewLabel_1_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_1_1_1_2.setBounds(361, 129, 95, 21);
		panel_3_1.add(lblNewLabel_1_1_1_2);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(453, 129, 120, 20);
		panel_3_1.add(textField_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(529, 38, 44, 22);
		panel_3_1.add(comboBox);
		
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
