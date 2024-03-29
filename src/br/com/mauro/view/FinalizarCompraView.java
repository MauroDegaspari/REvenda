package br.com.mauro.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class FinalizarCompraView {

	private JFrame frame;
	public JTextField txtFCTotal;
	public JTextField txtFCTroco;
	

	/**
	 * Launch the application.
	 */
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
					FinalizarCompraView window = new FinalizarCompraView();
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
	public FinalizarCompraView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 817, 429);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(23, 325, 181, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(386, 325, 181, 35);
		frame.getContentPane().add(btnImprimir);
		
		JButton btnFinalizarCompra = new JButton("Finalizar Compra");
		btnFinalizarCompra.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		btnFinalizarCompra.setForeground(SystemColor.activeCaption);
		btnFinalizarCompra.setIcon(new ImageIcon(FinalizarCompraView.class.getResource("/icons/cart shopping.png")));
		btnFinalizarCompra.setBackground(new Color(51, 153, 102));
		btnFinalizarCompra.setBounds(577, 303, 214, 57);
		frame.getContentPane().add(btnFinalizarCompra);
		
		JLabel lbTotal = new JLabel("Total");
		lbTotal.setBounds(487, 227, 38, 14);
		frame.getContentPane().add(lbTotal);
		
		txtFCTotal = new JTextField();
		txtFCTotal.setForeground(new Color(0, 0, 0));
		txtFCTotal.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtFCTotal.setBounds(561, 224, 86, 20);
		frame.getContentPane().add(txtFCTotal);
		txtFCTotal.setColumns(10);
		txtFCTotal.setText(String.valueOf(IndexView.totalFinal));
		
		
		JLabel lblTroco = new JLabel("Troco");
		lblTroco.setBounds(487, 255, 38, 14);
		frame.getContentPane().add(lblTroco);
		
		txtFCTroco = new JTextField();
		txtFCTroco.setColumns(10);
		txtFCTroco.setBounds(561, 252, 86, 20);
		frame.getContentPane().add(txtFCTroco);
		
		IndexView.troco = Double.parseDouble(IndexView.txtValorDinheiro.getText()) - IndexView.totalFinal;
		String trocoFormatado = String.format("%.2f", IndexView.troco); // Arredonda o resultado para duas casas decimais
		txtFCTroco.setText(trocoFormatado );
		
		JLabel lbTotal_1 = new JLabel("Total");
		lbTotal_1.setBounds(668, 227, 38, 14);
		frame.getContentPane().add(lbTotal_1);
	}
}
