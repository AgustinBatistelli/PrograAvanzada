package  MiniChat.conexion;

import MiniChat.cliente.MensajeAServidor;

import java.io.*;

import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conexion extends Thread{
          
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
    		String nombreCliente = (String) entrada.readObject();
            System.out.println(nombreCliente + " se ha conectado");
    		do {
    			mensaje = (MensajeAServidor) entrada.readObject();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				System.out.println("[" + dtf.format(LocalDateTime.now()) + "] " + mensaje.getNombreCliente() + ": " + mensaje.getMensaje());
    		}while(!mensaje.getMensaje().contains("/salir"));

    	}catch (EOFException e) {
            System.out.println("");
            System.out.println(mensaje.getNombreCliente() + " se desconecto...");
        }
        catch(Exception e) {
            if(e.getMessage().contains("Connection reset"))
                System.out.println(mensaje.getNombreCliente() + " se desconecto...");
    	}

        
    }
    
}