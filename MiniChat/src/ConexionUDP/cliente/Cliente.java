package ConexionUDP.cliente;

import java.io.IOException;
import java.net.*;

public class Cliente {
    public static void main(String[] args) throws IOException {
        final int PUERTO_SERVIDOR = 5000;
        byte[] buffer = new byte[1024];

        InetAddress direccionServidor = InetAddress.getByName("localhost");
        DatagramSocket socket = new DatagramSocket(); // Eso puede tirar una exception

        String mensaje = "¡Hola mundo desde el cliente!";
        buffer = mensaje.getBytes();

        DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);
        System.out.println("Envio el datagrama");
        socket.send(pregunta);

        DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
        socket.receive(peticion);

        System.out.println("Recibo peticion");
        mensaje = new String(peticion.getData());
        System.out.println(mensaje);

        socket.close();
    }
}
