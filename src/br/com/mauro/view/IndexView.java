package br.com.mauro.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class IndexView {

	private JFrame frmIndex;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public IndexView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIndex = new JFrame();
		frmIndex.setBounds(100, 100, 450, 300);
		frmIndex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
