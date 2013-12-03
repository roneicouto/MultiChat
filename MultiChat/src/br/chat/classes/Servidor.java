package br.chat.classes;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.xml.bind.ParseConversionEvent;

import org.xml.sax.Parser;

public class Servidor extends Thread {
	
	//instancia de clientes
	private static Vector clientes;
	private Socket conexao; //cria o socket
	private String nomeCliente; //nome dado ao cliente
	
	//Construtor do SOCKET
	public Servidor (Socket s) {
		conexao = s;
	}
	
	public Servidor() {
	
	}

	//inicio da thread do servidor
	public void run() {
		
		try {
			
			//Controle de fluxo de comunicação

			BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
		
			PrintStream saida = new PrintStream(conexao.getOutputStream());
			
			//passagem do nome do cliente
			nomeCliente = entrada.readLine();
			if (nomeCliente == null) {return;}
			System.out.println("O cliente "+ nomeCliente + " está conectado");
			clientes.add(saida); //cliente adicionado ao vetor de clientes
			
			String linha = entrada.readLine();
			while (linha != null && !(linha.trim().equals(""))){
				sendToAll (saida, " disse: ", linha);
				linha = entrada.readLine();
				System.out.println("Nenhum cliente conectado!");
			}
			
			sendToAll(saida, " disse ", linha);
			linha = entrada.readLine();
			
			sendToAll(saida, " saiu ", "do chat");
			clientes.remove(saida);
			conexao.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void sendToAll(PrintStream saida, String acao, String linha) {
		// TODO Auto-generated method stub
		Enumeration e = clientes.elements();
		
		while (e.hasMoreElements()) {
			//detem o fluxo de clientes
			PrintStream chat = (PrintStream) e.nextElement();
			//enviar para todos menos para o próprio user
			if (chat != saida) {
				chat.println(nomeCliente + acao + linha);
			}
		}
	}
	
	
//	public static void main(String[] args) {
//		clientes = new Vector ();
//
//		try {
//			ServerSocket s = new ServerSocket(2222);
//
//			while (true) {
//				System.out.println("Aguardando alguma conexão...");
//				Socket conexao = s.accept();
//				System.out.println("O Cliente conectou...");
//				Thread t = new Servidor(conexao);
//				t.start();
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//	}
	
	public void inicia() {
		

		clientes = new Vector ();
		
		try {
			ServerSocket s = new ServerSocket(2222);
			
			while (true) {
				System.out.println("Aguardando alguma conexão...");
				Socket conexao = s.accept();
				System.out.println("O Cliente conectou...");
				Thread t = new Servidor(conexao);
				t.start();
			             }
		} catch (Exception e) {
			System.out.println(e);
		}
		
	
		
	}
}
