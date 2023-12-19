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
import javax.swing.ImageIcon;

public class LoginView {

	private JFrame frmRevendaLogin;
	private JTextField txtFuncionario;
	private JPasswordField pswSenha;
	

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
		frmRevendaLogin.setBounds(100, 100, 445, 519);
		frmRevendaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRevendaLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(97, 171, 164));
		panel.setBounds(0, 0, 429, 173);
		frmRevendaLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginView.class.getResource("/icons/REVENDA300.png")));
		lblNewLabel.setBounds(52, 11, 310, 151);
		panel.add(lblNewLabel);
		
		JPanel pnPrincipal = new JPanel();
		pnPrincipal.setBounds(0, 0, 429, 480);
		frmRevendaLogin.getContentPane().add(pnPrincipal);
		pnPrincipal.setLayout(null);
		
		txtFuncionario = new JTextField();
		txtFuncionario.setBounds(133, 273, 163, 20);
		pnPrincipal.add(txtFuncionario);
		txtFuncionario.setColumns(10);
		
		pswSenha = new JPasswordField();
		pswSenha.setBounds(133, 317, 163, 20);
		pnPrincipal.add(pswSenha);
		
		JLabel lbUser = new JLabel("Login de Funcionario");
		lbUser.setFont(new Font("Verdana", Font.PLAIN, 20));
		lbUser.setBounds(105, 210, 223, 37);
		pnPrincipal.add(lbUser);
		
		JLabel lbFuncionario = new JLabel("Funcionario");
		lbFuncionario.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbFuncionario.setBounds(133, 258, 85, 14);
		pnPrincipal.add(lbFuncionario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblSenha.setBounds(133, 304, 85, 14);
		pnPrincipal.add(lblSenha);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String email,senha;
					
					email = txtFuncionario.getText();
					senha = pswSenha.getText();
					
					FuncionarioDAO func = new FuncionarioDAO();
					func.LoginFuncionario(email,senha);
					frmRevendaLogin.dispose();
					
				
					
				}catch(Exception erro ){
					JOptionPane.showMessageDialog(null, "erro em acesso:  " + erro);
				}
				
			}
		});
		btnLogin.setBounds(165, 366, 89, 23);
		pnPrincipal.add(btnLogin);
	}
}
