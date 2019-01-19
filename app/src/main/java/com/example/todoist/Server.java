package com.example.dena.todolist;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<ClientHandler> clientHandlers;
    static  ArrayList<String> username;
    static ArrayList<String> password;
    static ArrayList<String> session;
    static int[] sn;
    public static void main(String[] args) {
        clientHandlers = new ArrayList<>();
        username = new ArrayList<>();
        password = new ArrayList<>();
        session = new ArrayList<>();
        sn = new int[30];
        ServerSocket serverSocket;
        Socket socket;
        try {
            while (true) {
                serverSocket = new ServerSocket(54321);
                socket = serverSocket.accept();
                System.out.println("Connection established!");

                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                clientHandlers.add(clientHandler);
                thread.start();
            }

//            Scanner input = new Scanner(socket.getInputStream());
//            Formatter out = new Formatter(socket.getOutputStream());
//            String next;
//            do {
//                next = input.next();
//                System.out.println("Client said:\t" + next);
//                out.format("Your message received!");
//                out.flush();
//            } while (!next.equals("Exit"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        } finally {
//            try {
//                serverSocket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                socket.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
    }
}
