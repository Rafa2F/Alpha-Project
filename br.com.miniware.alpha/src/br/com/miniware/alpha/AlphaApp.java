package br.com.miniware.alpha;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Toolkit;

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
		frmAlpha.setBounds(100, 100, 450, 300);
		frmAlpha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlpha.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frmAlpha.setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
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

