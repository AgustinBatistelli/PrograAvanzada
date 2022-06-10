package cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    private int puerto;
    private String ip;
    private String nombreUser;
    
    public Cliente(int puerto, String ip, String user) {
        this.puerto = puerto;
        this.ip = ip;
        this.nombreUser = user;
    }

    public int getPuerto() {
        return puerto;
    }

    public String getIp() {
        return ip;
    }

    public static void main(String[] args) throws IOException {
        
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Ingrese su nombre");
    	String nombreCliente = scanner.nextLine();
    	
        Cliente cliente = new Cliente(10000, "127.0.0.2", nombreCliente);
        
        
        Socket socketCliente = null;
        DataOutputStream salida = null;
        InputStreamReader leer = null;
        BufferedReader ingresoTexto = null;
        
        try {
            socketCliente = new Socket("127.0.0.1" , 10000);
            salida = new DataOutputStream(socketCliente.getOutputStream());
            leer = new InputStreamReader(System.in);
            ingresoTexto = new BufferedReader(leer);

            
            System.out.print("Escriba el texto: ");
            

            String mensajeConsola = ingresoTexto.readLine();

            while(!mensajeConsola.equals("/salir")){
            	salida.writeUTF(mensajeConsola);
                mensajeConsola = ingresoTexto.readLine();
            }
            salida.writeUTF("/salir " + "user:" + nombreCliente);
            
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    	scanner.close();
        socketCliente.close();    
        leer.close();
        salida.close();
        ingresoTexto.close();
    
        
    }
}

/*
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
		try {
			new Cliente("localhost", 20000, "Sebastian");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Cliente(String ip, int puerto, String nombre) throws UnknownHostException, IOException {
		Socket socket = new Socket(ip, puerto);
		this.nombre = nombre;
		this.conectado = true;

		DataInputStream entrada = new DataInputStream(socket.getInputStream());
		DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

		// Recibir mensaje -> entrada.readUTF());

		Scanner scanner = null;
		while(true) {
			scanner = new Scanner(System.in, "UTF-8");
			
			
			
			String mensajeConsola = scanner.nextLine();
			if(mensajeConsola.equals("/salir")) {
				desconectar(scanner, entrada, salida, socket);			
				break;
			}
			else
				salida.writeUTF(mensajeConsola);
			
		}
		System.out.println("Cliente finalizado");
	}
	
	public boolean desconectar(Scanner scanner, DataInputStream entrada, DataOutputStream salida, Socket socket) 
			throws IOException {
//		scanner.close();
//		entrada.close();
//		salida.close();
//		socket.close();
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
*/