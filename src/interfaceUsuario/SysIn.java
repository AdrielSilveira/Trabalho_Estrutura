package interfaceUsuario;

import java.util.Scanner;

public class SysIn {
	private static Scanner scan = new Scanner(System.in);

	public static String inString(String texto) {
		String resp = "";
		System.out.println(texto);
		resp = scan.nextLine();
		return resp;
	}

	public static long inLong(String texto, String erro) {
		long resp = 0;
		boolean test = false;
		do {
			System.out.println(texto);
			try {
				resp = scan.nextLong();
				scan.nextLine();
				test = true;
			} catch (Exception e) {
				scan.nextLine();
				System.out.println(erro);
				test = false;
			}
		} while (!test);
		return resp;
	}
	
	public static long inLong(String texto) {
		return inLong(texto, "Valor inválido!");
	}
	
	public static int inInt(String texto, String erro) {
		int resp = 0;
		boolean test = false;
		do {
			System.out.println(texto);
			try {
				resp = scan.nextInt();
				scan.nextLine();
				test = true;
			} catch (Exception e) {
				scan.nextLine();
				System.out.println(erro);
				test = false;
			}
		} while (!test);
		return resp;
	}
	
	public static int inInt(String texto) {
		return inInt(texto, "Valor inválido!");
	}
	
	public static double inDouble(String texto, String erro) {
		double resp = 0;
		boolean test = false;
		do {
			System.out.println(texto);
			try {
				resp = scan.nextInt();
				scan.nextLine();
				test = true;
			} catch (Exception e) {
				scan.nextLine();
				System.out.println(erro);
				test = false;
			}
		} while (!test);
		return resp;
	}
	
	public static double inDouble(String texto) {
		return inDouble(texto, "Valor inválido!\n");
	}

	public static String pedeNome() {
		return inString("Digite o nome:\n");
	}

	public static long pedeCPF() {
		return inLong("Digite o CPF do cliente:\n");
	}
	
	public static long pedeCNH() {
		return inLong("Digite a CNH do cliente:");
	}
	
	public static long pedeTelefone() {
		 return inLong("Digite o contato (telefone) do cliente:");
	}
	
	public static String pedePlaca() {
		return inString("Digite a placa do veículo:");
	}
	
	public static String pedeModelo() {
		return inString("Digite o modelo do veículo:");
	}
	
	public static String pedeMarca() {
		return inString("Digite a marca do veículo:");
	}
	
	public static int pedeAnoVeiculo() {
		return inInt("Digite o ano do veículo:");
	}
	
	public static int pedePotencia() {
		return inInt("Digite a potência do veículo:");
	}
	
	public static int pedeNLugares() {
		return inInt("Digite o numero de lugares do veículo:");
	}
	
	public static int pedeIdCat() {
		return inInt("Digite o id da categoria:");
	}
	
	public static double pedeValor() {
		return inDouble("Digite o valor:");
	}

}
