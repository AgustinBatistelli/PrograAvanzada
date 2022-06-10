package  MiniChat.cliente;

import java.io.*;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;


public class Cliente implements Serializable, Observer {

    private int puerto;
    private String ip;
    private String nombreUser;
    
    public Cliente(int puerto, String ip, String user) {  
        this.puerto = puerto;
        this.ip = ip;
        this.nombreUser = user;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public static void main(String[] args) throws IOException {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Ingrese su nombre");
    	String nombreCliente = scanner.nextLine();
    	
        Cliente cliente = new Cliente(10000, "127.0.0.2", nombreCliente);
      
        
        Socket socketCliente = null;
        ObjectOutputStream salida = null;
        DataOutputStream salidaTxt = null;
        InputStreamReader leer = null;
        BufferedReader ingresoTexto = null;
        
        try {
            socketCliente = new Socket("127.0.0.1" , 10000);
              
            salida = new ObjectOutputStream(socketCliente.getOutputStream());

    		salida.writeObject(cliente);
            
            leer = new InputStreamReader(System.in);
            ingresoTexto = new BufferedReader(leer);
            
            System.out.print("Escriba el texto: ");
            String mensajeConsola = ingresoTexto.readLine();

            while(!mensajeConsola.equals("/salir")){
                MensajeAServidor mensaje = new MensajeAServidor(cliente.getNombreUser(), mensajeConsola);
            	salida.writeObject(mensaje);
                System.out.print("Escriba el texto: ");
                mensajeConsola = ingresoTexto.readLine();
            }            
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    	scanner.close();
        socketCliente.close();    
        leer.close();
        salida.close();
        ingresoTexto.close();
    
        
    }

	@Override
	public void update(Observable o, Object arg) {
		System.out.println((String) arg);		
		
	}
}

