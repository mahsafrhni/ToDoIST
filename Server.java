package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<ClientHandler> clientHandlers;
    static ArrayList<String> username;
    static ArrayList<String> password;
    static ArrayList<String> email;
    static ArrayList<String> session;
    static int[] sn;

    public static void main(String[] args) throws IOException {
        clientHandlers = new ArrayList<>();
        username = new ArrayList<>();
        password = new ArrayList<>();
        session = new ArrayList<>();
        sn = new int[30];
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket;
        try {
            while (true) {
                socket = serverSocket.accept();
                //System.out.println("Connection established!");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                clientHandlers.add(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
