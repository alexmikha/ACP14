package week3.client;

import com.google.gson.Gson;
import week3.dto.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by mi on 9/17/16.
 */
public class RunClient {

    public static void main(String[] args) {
        final Gson gson = new Gson();

        try (Socket socket = new Socket("192.168.0.101", 8888);
             PrintWriter pw = new PrintWriter(socket.getOutputStream())) {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            while (true) {
                String jsonServerMessage = bufferedReader.readLine();
                Message serverMessage = gson.fromJson(jsonServerMessage, Message.class);

                System.out.println("server Message");
                System.out.println(serverMessage);

                // String(Json) -> object Message


                System.out.println("input message");
                // get message from the console
                String message = new Scanner(System.in).nextLine();

                String responseFromServer = gson.toJson(new Message("client", message));
                pw.println(responseFromServer);
                pw.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
