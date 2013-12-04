package br.chat.GUI;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClienteGUI extends JFrame {
	private JTextField textField;
	private JTextField textArquivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteGUI frame = new ClienteGUI();
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
	public ClienteGUI() {
		setTitle("Chat Message");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 479);
		getContentPane().setLayout(null);
		
		JPanel Conectar = new JPanel();
		Conectar.setForeground(Color.LIGHT_GRAY);
		Conectar.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		Conectar.setBounds(10, 11, 357, 78);
		getContentPane().add(Conectar);
		Conectar.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(63, 11, 142, 22);
		Conectar.add(textField);
		textField.setColumns(10);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConectar.setBounds(261, 11, 89, 23);
		Conectar.add(btnConectar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair.setBounds(261, 44, 89, 23);
		Conectar.add(btnSair);
		
		JLabel lblNome = new JLabel("Cliente:");
		lblNome.setBounds(10, 15, 46, 14);
		Conectar.add(lblNome);
		
		JPanel listOnlines = new JPanel();
		listOnlines.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		listOnlines.setBounds(380, 11, 115, 419);
		getContentPane().add(listOnlines);
		listOnlines.setLayout(null);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtualizar.setBounds(10, 363, 89, 23);
		listOnlines.add(btnAtualizar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		panel.setBounds(10, 100, 357, 330);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 337, 146);
		panel.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 165, 337, 79);
		panel.add(textArea_1);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnviar.setBounds(10, 255, 89, 23);
		panel.add(btnEnviar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpar.setBounds(109, 255, 89, 23);
		panel.add(btnLimpar);
		
		JButton btnArquivo = new JButton("Escolher Arquivo");
		btnArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnArquivo.setBounds(10, 289, 135, 23);
		panel.add(btnArquivo);
		
		textArquivo = new JTextField();
		textArquivo.setBounds(162, 289, 185, 20);
		panel.add(textArquivo);
		textArquivo.setColumns(10);
	}
}
