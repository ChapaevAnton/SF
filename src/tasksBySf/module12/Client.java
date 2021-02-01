package tasksBySf.module12;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {

    Socket socket;
    Scanner in;
    PrintStream out;
    ChatServer server;

    public Client(Socket socket, ChatServer server) {
        this.socket = socket;
        this.server = server;
        //Запускаем поток
        new Thread(this).start();
    }

    void receive(String message) {
        out.println(message);
    }

    @Override
    public void run() {
        try {
            //Получаем потоки ввода и вывода
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            //Создаем удобные средства ввода и вывода
            in = new Scanner(is);
            out = new PrintStream(os);
            //Читаем из сети и пишем в сеть
            out.println("Welcome to chat!");
            String input = in.nextLine();
            while (!input.equals("bye")) {
                server.sendAll(input);
                input = in.nextLine();
            }
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
