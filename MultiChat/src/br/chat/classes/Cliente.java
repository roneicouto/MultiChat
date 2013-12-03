package br.chat.classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Cliente extends Thread{

	private static boolean ok = false;
	
	private Socket conexao;
	
	public Cliente (Socket s) {
		conexao = s;
	}
	
	public void run(){
		
		try {
			
			BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			
			String linha;
			
			while(true) {
				linha = entrada.readLine();
				
				if (linha == null) {
					System.out.println("Conexão Encerrada!");
					break;
				}
				//caso a linha não seja nula irá imprimir
				System.out.println();
				System.out.println(linha);
				System.out.println( "...> ");
			}} catch (Exception e) {
			System.out.println(e);
		}
		ok = true;
	}
	
	public static void main(String[] args) {
		try {
			
			Socket conexao = new Socket("127.0.0.1",2222);
			PrintStream saida = new PrintStream(conexao.getOutputStream());
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Digite o nome do Cliente: ");
			String nomeCliente = teclado.readLine();
			saida.println(nomeCliente);
			
			Thread t = new Cliente(conexao);
			t.start();
			
			String linha;
			
			while(true) {
				System.out.println("> ");
				linha = teclado.readLine();
				
				if (ok){break;}
				
				saida.println(linha);
				
				
			}
			
		}catch (Exception e) {
			
		}
	}
}
