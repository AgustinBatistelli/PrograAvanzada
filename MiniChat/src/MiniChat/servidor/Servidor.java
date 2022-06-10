package MiniChat.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private ServerSocket server;
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public Servidor(int puerto) throws IOException{
        server = new ServerSocket(puerto);
        String messageIn = "";
        socket = server.accept();

        inputStream = new DataInputStream(socket.getInputStream());
        while(true){
              messageIn = inputStream.readUTF();
              System.out.println("Mensaje: " + messageIn);
        }
    }


    public static void main(String[] args) {
        try {
            new Servidor(20000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
