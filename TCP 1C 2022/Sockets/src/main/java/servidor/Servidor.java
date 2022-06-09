package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Servidor {
	
	public static void main(String[] args) {
		try {
			new Servidor(20000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Servidor(int puerto) throws IOException {
		ServerSocket servidor = new ServerSocket(puerto);

		System.out.println("Server inicializando...");

		for (int numeroCliente = 1; numeroCliente <= 3; numeroCliente++) {
			Socket socket = servidor.accept();

			// Flujos de información
			DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
			DataInputStream entrada = new DataInputStream(socket.getInputStream());
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();

			// El read también es bloqueante, como el accept
			System.out.println(dtf.format(now) + "Cliente \"" 
			+ numeroCliente + "\" dice: \"" + entrada.readUTF() + "\"");

			// Se cierran recursos
			entrada.close();
			salida.close();
			socket.close();
		}

		servidor.close();
	}

}
