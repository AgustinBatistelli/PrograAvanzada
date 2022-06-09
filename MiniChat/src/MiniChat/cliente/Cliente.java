package MiniChat.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente implements Runnable {
    private int puerto;
    private String mensaje;

    public Cliente(int puerto, String mensaje){
        this.puerto = puerto;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        final String HOST = "127.0.0.1"; // Este Host hace referencia a mi maquina
        DataOutputStream out;

        try{
            Socket socket = new Socket(HOST, puerto); // Esto puede tirar excepcion si no esta el Server levantado
            out = new DataOutputStream(socket.getOutputStream());

            out.writeUTF(mensaje);
            System.out.println(mensaje);

            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
