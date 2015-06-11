package br.com.miniware.alpha;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.Color;


public class TelaRegras extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRegras frame = new TelaRegras();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * Create the frame.
	 */
	public TelaRegras() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegrasDeResoluo = new JLabel("Regras de Resolu\u00E7\u00E3o");
		lblRegrasDeResoluo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRegrasDeResoluo.setBounds(140, 11, 134, 22);
		contentPane.add(lblRegrasDeResoluo);
		
		JEditorPane dtrpnSoma = new JEditorPane();
		dtrpnSoma.setForeground(Color.WHITE);
		dtrpnSoma.setBackground(Color.WHITE);
		dtrpnSoma.setFont(new Font("Tahoma", Font.BOLD, 11));
		dtrpnSoma.setEnabled(false);
		dtrpnSoma.setText("Polin\u00F4mios (com adi\u00E7\u00E3o):\r\nPasso 1: Encontra um n\u00FAmero comum entre as partes para simplificar a equa\u00E7\u00E3o;\r\nPasso 2: Realiza a opera\u00E7\u00E3o pendente no lado esquerdo da igualdade;\r\nPasso 3: Realiza a opera\u00E7\u00E3o pendente no lado direito da igualdade;\r\nPasso 4: Se for pass\u00EDvel de simplifica\u00E7\u00E3o encontra um n\u00FAmero comum novamente para simplificar o resultado;\r\n");
		dtrpnSoma.setBounds(10, 47, 414, 204);
		contentPane.add(dtrpnSoma);
	}
}
