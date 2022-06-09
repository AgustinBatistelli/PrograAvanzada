package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	
	private String nombre;
	private boolean conectado = false;
	
	public static void main(String[] args) {
		while(true) {
			try {
				new Cliente("localhost", 20000, "Sebastian");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public Cliente(String ip, int puerto, String nombre) throws UnknownHostException, IOException {
		Socket socket = new Socket(ip, puerto);
		this.nombre = nombre;
		this.conectado = true;

		DataInputStream entrada = new DataInputStream(socket.getInputStream());
		DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

		// Recibir mensaje -> entrada.readUTF());

		Scanner scanner = new Scanner(System.in);
		String mensajeConsola = scanner.nextLine();
		if(mensajeConsola.equals("/salir"))
			desconectar(scanner, entrada, salida, socket);
		else
			salida.writeUTF(mensajeConsola);
	}
	
	public boolean desconectar(Scanner scanner, DataInputStream entrada, DataOutputStream salida, 
			Socket socket) throws IOException {
		scanner.close();
		entrada.close();
		salida.close();
		socket.close();
		this.conectado = false;
		return this.conectado;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isConectado() {
		return conectado;
	}

}
