package ConexionTCP.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {
        final String HOST = "127.0.0.1"; // Este Host hace referencia a mi maquina
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;

        Socket socket = new Socket(HOST, PUERTO); // Esto puede tirar excepcion si no esta el Server levantado
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        out.writeUTF("¡Hola mundo desde el cliente!");
        String mensaje = in.readUTF();
        System.out.println(mensaje);

        socket.close();
    }
}
