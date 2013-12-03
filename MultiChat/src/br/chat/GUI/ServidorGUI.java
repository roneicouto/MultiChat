package br.chat.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ServidorGUI extends JFrame {

	private JPanel contentPane;
	private JTextField campoEntrada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServidorGUI frame = new ServidorGUI();
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
	public ServidorGUI() {
		setTitle("Servidor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea yConn = new JTextArea();
		yConn.setBounds(5, 5, 480, 22);
		yConn.setDropMode(DropMode.ON);
		contentPane.add(yConn);
		
		JTextPane conversa = new JTextPane();
		conversa.setBounds(5, 38, 480, 177);
		contentPane.add(conversa);
		
		campoEntrada = new JTextField();
		campoEntrada.setBounds(5, 226, 379, 48);
		contentPane.add(campoEntrada);
		campoEntrada.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(396, 226, 89, 48);
		contentPane.add(btnEnviar);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
	}
}
