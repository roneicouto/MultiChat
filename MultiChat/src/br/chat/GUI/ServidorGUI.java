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
import java.net.ServerSocket;

public class ServidorGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2552352692523803942L;
	private JPanel contentPane;
	private JTextField textPorta;
	
	Servidor servidor = new Servidor();
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
		
		//INICIO FRAME MENSAGENS SERVIDOR
		JTextArea yConn = new JTextArea();
		yConn.setBounds(5, 5, 480, 235);
		contentPane.add(yConn);
		String  nomeCliente = servidor.getNomeCliente();
		servidor.setNomeCliente(nomeCliente);
		System.out.println("teste "+nomeCliente);
		if (servidor.getNomeCliente() != null ) {
		yConn.setText(servidor.getNomeCliente());
		}
		//FIM FRAME MENSAGENS SERVIDOR
		
		//BTNINICIAR SERVIDOR
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
		
		//MOSTRA A PORTA EM QUE ESTA FEITA A CONEXAO
		textPorta = new JTextField();
		textPorta.setEditable(false);
		textPorta.setBounds(362, 251, 86, 20);
		contentPane.add(textPorta);
		textPorta.setColumns(10);
		
		Servidor servidor = new Servidor();
		textPorta.setText(Integer.toString(servidor.porta));
		//FIM DA AREA DA PORTA
		
		//INICIO AREA BOTAO ENCERRAR O SERVIDOR
		JButton btnEncerrarServidor = new JButton("Encerrar Servidor");
		btnEncerrarServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Servidor servidor = new Servidor();
				//servidor.stop();
				servidor.currentThread().interrupted();
				
			}
		});
		btnEncerrarServidor.setBounds(172, 251, 117, 23);
		contentPane.add(btnEncerrarServidor);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
	} //FIM ENCERRAR SERVIDOR

}
