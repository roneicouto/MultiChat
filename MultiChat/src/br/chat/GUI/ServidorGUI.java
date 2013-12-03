package br.chat.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import br.chat.classes.Servidor;

import java.awt.Component;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServidorGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2552352692523803942L;
	private JPanel contentPane;
	private JTextField textPorta;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(ServidorGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")));
		setTitle("Servidor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea yConn = new JTextArea();
		yConn.setBounds(5, 5, 480, 235);
		contentPane.add(yConn);
		JButton btnIniciarServidor = new JButton("Iniciar Servidor");
		btnIniciarServidor.addActionListener(new ActionListener() {
			//ACAO DO BOTAO INICIAR SERVIDOR
			public void actionPerformed(ActionEvent arg0) {
				
				Servidor servidor = new Servidor();
				servidor.inicia();
				
			}
			//FIMACAO BOTAO INICIAR SERVIDOR
		});
		btnIniciarServidor.setBounds(15, 251, 147, 23);
		contentPane.add(btnIniciarServidor);
		
		JLabel lblPorta = new JLabel("Porta:");
		lblPorta.setBounds(326, 251, 46, 14);
		contentPane.add(lblPorta);
		
		textPorta = new JTextField();
		textPorta.setEditable(false);
		textPorta.setBounds(362, 251, 86, 20);
		contentPane.add(textPorta);
		textPorta.setColumns(10);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
	}
}
