package MiniChat.servidor;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import MiniChat.conexion.Conexion;

public class Servidor {

	private int puerto;

	public Servidor(int puerto) {
		this.puerto = puerto;
	}

	public void ingresoSalaDeChat() {

		Socket socketCliente;

		try {

			ServerSocket servidor = new ServerSocket(this.getPuerto());
			System.out.println("Esperando peticiones en puerto: " + this.getPuerto());

			while (true) {
				socketCliente = servidor.accept();
				ObjectInputStream entrada = new ObjectInputStream(socketCliente.getInputStream());
				DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());

				Conexion salaDeChat = new Conexion(socketCliente, entrada, salida);
				salaDeChat.run();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getPuerto() {
		return puerto;
	}

	public static void main(String[] args) {
		Servidor server = new Servidor(10000);
		server.ingresoSalaDeChat();
	}

}
