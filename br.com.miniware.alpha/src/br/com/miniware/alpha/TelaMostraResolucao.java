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
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class TelaMostraResolucao {

	private JFrame frmEquaoPassoA;
	private JTextField textFieldEquacao;
	private JTextPane txtpnResolucao;

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
		frmEquaoPassoA.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaMostraResolucao.class.getResource("/br/com/miniware/alpha/alpha.jpg")));
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
				sobre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		mnAjuda.add(mntmSobre);
		frmEquaoPassoA.getContentPane().setLayout(null);
		
		textFieldEquacao = new JTextField();
		textFieldEquacao.setBounds(107, 35, 180, 20);
		frmEquaoPassoA.getContentPane().add(textFieldEquacao);
		textFieldEquacao.setColumns(10);
		
		JButton btnNewButton = new JButton("Mostrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtpnResolucao.setText("");
				Alpha alpha = new Alpha ();
				
				String resultado = Resolver.resolver(textFieldEquacao.getText());
				String[] resultadoOrg = resultado.split(";");
				for (int i = 0; i < resultadoOrg.length; i++) 
				{
					txtpnResolucao.setText(txtpnResolucao.getText() + resultadoOrg[i] + "\n");
				}
				
				
				
				
				
				
			}
		});
		
		
		btnNewButton.setBounds(296, 34, 97, 23);
		frmEquaoPassoA.getContentPane().add(btnNewButton);
		
		JLabel lblE = new JLabel("Equa\u00E7\u00E3o:");
		lblE.setBounds(34, 38, 62, 14);
		frmEquaoPassoA.getContentPane().add(lblE);
		
		
		
		JLabel lblPassoAPasso = new JLabel("Passo a Passo da Equa\u00E7\u00E3o");
		lblPassoAPasso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassoAPasso.setBounds(107, 0, 180, 23);
		frmEquaoPassoA.getContentPane().add(lblPassoAPasso);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 66, 338, 151);
		frmEquaoPassoA.getContentPane().add(scrollPane);
		
		txtpnResolucao = new JTextPane();
		txtpnResolucao.setEditable(false);
		scrollPane.setViewportView(txtpnResolucao);
	}
}
