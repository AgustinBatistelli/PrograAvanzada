package ConexionTCP.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        ServerSocket servidor = null;
        Socket socket = null; // Cliente
        DataInputStream in;
        DataOutputStream out;
        final int PUERTO = 5000;

        try{
          servidor = new ServerSocket(PUERTO);
          System.out.println("Servidor iniciado");


          while(true){
              socket = servidor.accept(); // Se queda a la espera...

              System.out.println("Cliente conectado");
              in = new DataInputStream(socket.getInputStream());
              out = new DataOutputStream(socket.getOutputStream());

              String mensaje = in.readUTF(); // Se queda a la espera de que el cliente envie algo...
              System.out.println(mensaje);

              out.writeUTF("¡Hola mundo desde el servidor!");

              socket.close(); // Cierro el cliente
              System.out.println("Cliente desconectado");
          }


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
