package br.com.miniware.alpha;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import br.com.miniware.alpha.AlphaApp.SwingAction;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;

public class TelaSobre extends JFrame {

	private JPanel A;

	/**
	 * Launch the application.
	 */
	private JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSobre frame = new TelaSobre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}

	/**
	 * Create the frame.
	 */
	public TelaSobre() {
		setTitle("Sobre Alpha\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		A = new JPanel();
		A.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(A);
		A.setLayout(null);
		
		JLabel lblAlpha = new JLabel("Alpha");
		lblAlpha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAlpha.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlpha.setBounds(200, 11, 46, 14);
		A.add(lblAlpha);
		
		JLabel lblAutoresRafaelFerreira = new JLabel("Autores: Rafael Ferreira, Suelen Gon\u00E7alves, Diego Kremer, Dantieres\r\n");
		lblAutoresRafaelFerreira.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutoresRafaelFerreira.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblAutoresRafaelFerreira.setBounds(56, 44, 339, 14);
		A.add(lblAutoresRafaelFerreira);
		
		JLabel lblCopyrightMiniware = new JLabel("Copyright MiniWare 2015 Todos os direitos reservados.");
		lblCopyrightMiniware.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyrightMiniware.setForeground(Color.BLACK);
		lblCopyrightMiniware.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCopyrightMiniware.setBounds(67, 102, 339, 14);
		A.add(lblCopyrightMiniware);
		
	
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
					setDefaultCloseOperation(EXIT_ON_CLOSE);
					System.exit(0);
					
				
			
			}
		});
		btnOk.setToolTipText("");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnOk.setBackground(Color.WHITE);
		btnOk.setBounds(157, 213, 89, 23);
		A.add(btnOk);
		
		
	
		
	}
}
