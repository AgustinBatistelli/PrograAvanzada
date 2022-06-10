package conexion;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.net.Socket;

public class Conexion extends Thread{
          
    private Socket socket;
    private DataInputStream entrada;
    private DataOutputStream salida;
    
    public Conexion(Socket socket, DataInputStream entrada, DataOutputStream salida) {
        this.socket = socket;
        this.entrada = entrada;
        this.salida = salida;
    }

    @Override
    public void run() {
        
        System.out.println("Se ha conectado un nuevo cliente");
        String mensaje = null;
        
    	try {
    		do {
    			mensaje = entrada.readUTF();
				System.out.println(mensaje); 
    		}while(!mensaje.contains("/salir"));
    		
    	} catch(Exception e) {
    		e.printStackTrace();
    	}

        
    }
    
}