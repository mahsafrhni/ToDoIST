package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Scanner input;
    static DataInputStream dataInputStream;
    static DataOutputStream dataOutputStream;
    static String what_to_do;
    public static void main(String[] args) {
        input = new Scanner(System.in);
        Socket socket = null;
        try {
            socket = new Socket("localHost", 1234);
            //Scanner socketInput = new Scanner(socket.getInputStream());
            //Formatter socketOut = new Formatter(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            do {
                what_to_do = input.next();
                dataOutputStream.writeUTF(what_to_do);
                if (what_to_do.equals("register")) {
                    register();
                }
                if (what_to_do.equals("login")) {
                    login();
                }
                if (what_to_do.equals("logout")) {
                    logout();
                }

            } while (what_to_do.equals("Exit"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void register() {
        String username = input.next();
        String password = input.next();
        try {
            dataOutputStream.writeUTF(username);
            dataOutputStream.writeUTF(password);
            String read = dataInputStream.readUTF();
            System.out.println(read);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void login() {
        String username = input.next();
        String password = input.next();
        try {
            dataOutputStream.writeUTF(username);
            dataOutputStream.writeUTF(password);
            dataInputStream.readUTF();
            String read = dataInputStream.readUTF();
            System.out.println(read);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void logout() {
        String session = input.next();
        try {
            dataOutputStream.writeUTF(session);
            String read = dataInputStream.readUTF();
            System.out.println(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}