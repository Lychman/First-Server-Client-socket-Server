
import java.net.*;
import java.io.*;

// Created by LychmanIT

public class Server {
    public static void main(String[] args)    {
        int port = 61236;
        String line = null;
	String name = null;
	String message = null;

        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println(">Ожидаю клиента...");

            Socket socket = ss.accept();
            System.out.println(">Соединение установлено");
            System.out.println();

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            while(true) {
      	        name = in.readUTF();
                line = in.readUTF();
                message = (">" + name + ": " + line);
		System.out.println(message);
                System.out.println(">Отправка...");
                out.writeUTF(message);
                out.flush();
                System.out.println(">Жду следущего сообщения...");
                System.out.println();
            }
        } catch(Exception x) { x.printStackTrace(); }
    }
}
