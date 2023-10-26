package br.com.mauro.jdbc;

import javax.swing.JOptionPane;

public class TestandoConexao {

	public static void main(String[] args) {
		try {
			
			new ConnectionFactory().getConnection();
			JOptionPane.showMessageDialog(null, "Conectado com SUCESSO");
			
		} catch (Exception erro) {
			
			JOptionPane.showMessageDialog(null, "ERRO: --------> Falha na conexão: \n"+erro);
			

		}

	}

}
