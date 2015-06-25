package br.com.miniware.alpha;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class AlphaApp extends JFrame{
	
	private JFrame frmAlpha;
	private final Action actionSair = new SwingAction();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlphaApp window = new AlphaApp();
					window.frmAlpha.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AlphaApp() {
		initialize();
	}

	
	private void initialize() {
		frmAlpha = new JFrame();
		frmAlpha.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\631320019\\Desktop\\alpha.jpg"));
		frmAlpha.setTitle("Alpha");
		frmAlpha.setBounds(100, 100, 500, 350);
		frmAlpha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlpha.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Passo a Passo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaMostraResolucao.main(null);
			}
		});
		btnNewButton.setBounds(170, 91, 138, 23);
		frmAlpha.getContentPane().add(btnNewButton);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frmAlpha.setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmPassoAPasso = new JMenuItem("Passo a Passo");
		mntmPassoAPasso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaMostraResolucao.main(null);
			}
		});
		
		
		
		
		JEditorPane dtrpnSoma = new JEditorPane();
		dtrpnSoma.setForeground(Color.BLACK);
		
		dtrpnSoma.setFont(new Font("Tahoma", Font.BOLD, 11));
		dtrpnSoma.setEnabled(true);
		dtrpnSoma.setText("Polin\u00F4mios (com adi\u00E7\u00E3o):\r\nPasso 1: Encontra um n\u00FAmero comum entre as partes para simplificar a equa\u00E7\u00E3o;\r\nPasso 2: Realiza a opera\u00E7\u00E3o pendente no lado esquerdo da igualdade;\r\nPasso 3: Realiza a opera\u00E7\u00E3o pendente no lado direito da igualdade;\r\nPasso 4: Se for pass\u00EDvel de simplifica\u00E7\u00E3o encontra um n\u00FAmero comum novamente para simplificar o resultado;\r\n");
		dtrpnSoma.setBounds(30, 150, 414, 104);
		frmAlpha.add(dtrpnSoma);
		
		mnArquivo.add(mntmPassoAPasso);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setAction(actionSair);
		mnArquivo.add(mntmSair);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
	}
	public class SwingAction extends AbstractAction {
		
		private static final long serialVersionUID = -5234497447388627760L;
		public SwingAction() {
			putValue(NAME, "Sair");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			frmAlpha.setVisible(false);
		}
	}
}	

