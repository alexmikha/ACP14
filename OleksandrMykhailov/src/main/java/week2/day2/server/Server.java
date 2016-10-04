package week2.day2.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mi on 15.09.2016.
 */
public class Server {

    private int id;
    private List<String> list;

    public Server() {
        list = new ArrayList<>();
    }

    public void run() {
        try {

            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server was run");
            while (true) {
                Socket client = serverSocket.accept();
                String clientInfo = String.format("count %d, address %s, port %d\n",
                        id++,
                        client.getInetAddress(),
                        client.getPort());

                System.out.println(clientInfo);
                list.add(clientInfo);

                PrintWriter pw = new PrintWriter(client.getOutputStream());
                pw.printf("Hello from server. Your info %s, time %s", clientInfo, new Date());
                pw.flush();
                pw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

