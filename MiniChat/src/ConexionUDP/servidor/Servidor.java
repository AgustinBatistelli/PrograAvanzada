package ConexionUDP.servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class Servidor {
    public static void main(String[] args) throws IOException {
        final int PUERTO = 5000;
        byte[] buffer = new byte[1024];

        System.out.println("Iniciado el servidor UDP");
        DatagramSocket socket = new DatagramSocket(PUERTO); // Eso puede tirar una excepcion

        while(true){
            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
            socket.receive(peticion);

            System.out.println("Recibo la informacion del cliente");
            String mensaje = new String(peticion.getData());
            System.out.println(mensaje);

            int puertoCliente = peticion.getPort();
            InetAddress direccion = peticion.getAddress();

            mensaje =  "¡Hola mundo desde el servidor!";
            buffer = mensaje.getBytes();

            System.out.println("Envio la informacion del cliente");
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);

            socket.send(respuesta);
        }
    }
}
