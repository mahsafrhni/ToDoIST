package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    //static ArrayList<ClientHandler> clientHandlers;
    static ArrayList<User> users;
    static ArrayList<String> session;
    static int[] sn;
    static int numOfClients;

    public static void main(String[] args) throws IOException {
        //clientHandlers = new ArrayList<>();
        users = new ArrayList<>();
        sn = new int[30];
        ServerSocket serverSocket = new ServerSocket(5000);
        Socket socket;
        try {
            while (true) {
                socket = serverSocket.accept();
                System.out.println("Connection established!");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                //clientHandlers.add(clientHandler);
                thread.start();
               // numOfClients++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
