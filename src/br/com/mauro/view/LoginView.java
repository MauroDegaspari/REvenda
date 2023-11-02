package br.com.mauro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.mauro.dao.FuncionarioDAO;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class LoginView {

	private JFrame frmRevendaLogin;
	private JTextField txtFuncionario;
	private JPasswordField pswSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frmRevendaLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginView() {
		initialize();
	}

	private void initialize() {
		frmRevendaLogin = new JFrame();
		frmRevendaLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/icons/r.png")));
		frmRevendaLogin.setResizable(false);
		frmRevendaLogin.setTitle("REvenda Login");
		frmRevendaLogin.getContentPane().setBackground(new Color(204, 204, 204));
		frmRevendaLogin.setBounds(100, 100, 423, 469);
		frmRevendaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRevendaLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 255, 153));
		panel.setBounds(0, 0, 407, 142);
		frmRevendaLogin.getContentPane().add(panel);
		
		JPanel pnPrincipal = new JPanel();
		pnPrincipal.setBounds(0, 0, 424, 438);
		frmRevendaLogin.getContentPane().add(pnPrincipal);
		pnPrincipal.setLayout(null);
		
		txtFuncionario = new JTextField();
		txtFuncionario.setBounds(126, 239, 163, 20);
		pnPrincipal.add(txtFuncionario);
		txtFuncionario.setColumns(10);
		
		pswSenha = new JPasswordField();
		pswSenha.setBounds(126, 283, 163, 20);
		pnPrincipal.add(pswSenha);
		
		JLabel lbUser = new JLabel("Login de Funcionario");
		lbUser.setFont(new Font("Verdana", Font.PLAIN, 18));
		lbUser.setBounds(115, 169, 213, 37);
		pnPrincipal.add(lbUser);
		
		JLabel lbFuncionario = new JLabel("Funcionario");
		lbFuncionario.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbFuncionario.setBounds(126, 224, 85, 14);
		pnPrincipal.add(lbFuncionario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblSenha.setBounds(126, 270, 85, 14);
		pnPrincipal.add(lblSenha);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String email,senha;
					
					email = txtFuncionario.getText();
					senha = pswSenha.getText();
					
					FuncionarioDAO func = new FuncionarioDAO();
					frmRevendaLogin.dispose();
					func.LoginFuncionario(senha, email);
					
				
					
				}catch(Exception erro ){
					JOptionPane.showMessageDialog(null, "erro em acesso:  " + erro);
				}
				
			}
		});
		btnLogin.setBounds(158, 332, 89, 23);
		pnPrincipal.add(btnLogin);
	}
}
