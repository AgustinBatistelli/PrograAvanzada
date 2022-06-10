package MiniChat.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;

    public Cliente(String ip, int puerto) throws UnknownHostException, IOException{
        socket = new Socket(ip, puerto);

        //inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());

        Scanner scanner = new Scanner(System.in);
        String mensajeConsola = scanner.nextLine();


        while(!mensajeConsola.equals("/salir")){
             outputStream.writeUTF(mensajeConsola);
             mensajeConsola = scanner.nextLine();
        }

        scanner.close();
        outputStream.writeUTF("El cliente abandono el chat");
        outputStream.close();
        socket.close();
        System.out.println("Me adios!");

    }

    public static void main(String[] args) {
        try {
            new Cliente("localhost", 20000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
