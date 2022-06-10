package MiniChat.conexion;

import MiniChat.cliente.Cliente;
import MiniChat.cliente.MensajeAServidor;

import java.io.*;

import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Observable;

public class Conexion extends Observable implements Runnable {

	private Socket socket;
	private ObjectInputStream entrada;
	private DataOutputStream salida;

	public Conexion(Socket socket, ObjectInputStream entrada, DataOutputStream salida) {
		this.socket = socket;
		this.entrada = entrada;
		this.salida = salida;
	}

	@Override
	public void run() {

		MensajeAServidor mensaje = null;

		try {
			Cliente nuevoCliente = (Cliente) entrada.readObject();
			System.out.println(nuevoCliente.getNombreUser() + " se ha conectado");
			this.addObserver(nuevoCliente);
			System.out.println(this.countObservers());
			
			do {
				mensaje = (MensajeAServidor) entrada.readObject();
					
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				mensaje.setMensaje("[" + dtf.format(LocalDateTime.now()) + "] " + mensaje.getNombreCliente() + ": " + mensaje.getMensaje());
				
				this.setChanged();
				this.notifyObservers(mensaje.getMensaje());
				this.clearChanged();
			} while (!mensaje.getMensaje().contains("/salir"));

		} catch (EOFException e) {
			System.out.println("");
			System.out.println(mensaje.getNombreCliente() + " se desconecto...");
		} catch (Exception e) {
			if (e.getMessage().contains("Connection reset"))
				System.out.println(mensaje.getNombreCliente() + " se desconecto...");
		}

	}

}