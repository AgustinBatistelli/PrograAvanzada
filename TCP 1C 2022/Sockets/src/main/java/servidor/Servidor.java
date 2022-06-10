package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import conexion.Conexion;

public class Servidor{

    private int puerto;
    
    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    public void ingresoSalaDeChat() {
        
        Socket socketCliente;
        
        try {
            
            ServerSocket servidor = new ServerSocket(this.getPuerto());
            System.out.println("Esperando peticiones en puerto: " + this.getPuerto());
            
            while(true) {
                
                socketCliente = servidor.accept();
                DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());
                DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());
                
                Conexion salaDeChat = new Conexion(socketCliente, entrada, salida);
                salaDeChat.start();
            }
        } catch(Exception e) {
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


/*
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
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  

		DataOutputStream salida = null;
		DataInputStream entrada = null;
//		Socket socket = null;
		Socket socket = servidor.accept();
		
		while(true) {
			// Flujos de información
			salida = new DataOutputStream(socket.getOutputStream());
			entrada = new DataInputStream(socket.getInputStream());
			
			LocalDateTime now = LocalDateTime.now();
			
			// El read también es bloqueante, como el accept
			System.out.println(dtf.format(now) + " Cliente \"" 
					 + "\" dice: \"" + entrada.readUTF() + "\"");
			
		}
		

//		entrada.close();
//		salida.close();
//		socket.close();

//		servidor.close();
	}

}
*/