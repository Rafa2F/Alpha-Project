package br.com.miniware.alpha;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;

public class TelaMostraResolucao {

	private JFrame frmEquaoPassoA;
	private JTextField textFieldEquacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMostraResolucao window = new TelaMostraResolucao();
					window.frmEquaoPassoA.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaMostraResolucao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEquaoPassoA = new JFrame();
		frmEquaoPassoA.setTitle("Alpha - Equa\u00E7\u00E3o Passo a Passo");
		frmEquaoPassoA.setBounds(100, 100, 450, 300);
		frmEquaoPassoA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmEquaoPassoA.setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmEquaoPassoA.setVisible(false);
				frmEquaoPassoA.dispose();
			}
		});
		mnArquivo.add(mntmSair);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaSobre sobre = new TelaSobre ();
				sobre.setVisible(true);
			}
		});
		mnAjuda.add(mntmSobre);
		frmEquaoPassoA.getContentPane().setLayout(null);
		
		textFieldEquacao = new JTextField();
		textFieldEquacao.setBounds(107, 35, 180, 20);
		frmEquaoPassoA.getContentPane().add(textFieldEquacao);
		textFieldEquacao.setColumns(10);
		
		final JTextPane txtpnResolucao = new JTextPane();
		txtpnResolucao.setBounds(63, 63, 322, 167);
		frmEquaoPassoA.getContentPane().add(txtpnResolucao);
		
		JButton btnNewButton = new JButton("Mostrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Alpha alpha = new Alpha ();
				
				String resultado = alpha.resolver(textFieldEquacao.getText());
				String[] resultadoOrg = resultado.split(";");
				int i = 0;
				if (resultadoOrg[i].isEmpty()) {
					
				} else {
					while (resultadoOrg[i] != null) {
						System.out.println(resultadoOrg[i]);
						i++;
				}
				
					
					}
					
				
				
					
					
				
				
				
			}
		});
		
		
		btnNewButton.setBounds(296, 34, 89, 23);
		frmEquaoPassoA.getContentPane().add(btnNewButton);
		
		JLabel lblE = new JLabel("Equa\u00E7\u00E3o");
		lblE.setBounds(63, 38, 46, 14);
		frmEquaoPassoA.getContentPane().add(lblE);
		
		
		
		JLabel lblPassoAPasso = new JLabel("Passo a Passo da Equa\u00E7\u00E3o");
		lblPassoAPasso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassoAPasso.setBounds(107, 0, 180, 23);
		frmEquaoPassoA.getContentPane().add(lblPassoAPasso);
	}
}
