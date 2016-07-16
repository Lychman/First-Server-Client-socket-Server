import java.net.*;
import java.io.*;

// Created by LychmanIT

public class Client {
    public static void main(String[] args) {
        int serverPort = 61236;
        String address = "127.0.0.1";
	
	String line = null;
	String name = null;
	String message = null;

        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            System.out.println(">Ваш IP: " + address + ", Ваш порт: " + serverPort);
	    System.out.println();
            Socket socket = new Socket(ipAddress, serverPort);

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);
            BufferedReader nameKeyboard = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader lineKeyboard = new BufferedReader(new InputStreamReader(System.in));

            System.out.print(">Введите ваш логин: ");
            name = nameKeyboard.readLine(); 
	    System.out.println();

            while (true) { 
                System.out.print(">Отправьте Ваше сообщение: ");              
		line = lineKeyboard.readLine();
	        System.out.println();
		out.writeUTF(name); 
                out.writeUTF(line); 
                out.flush();
                message = in.readUTF();
                System.out.println(message);
                System.out.println();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
