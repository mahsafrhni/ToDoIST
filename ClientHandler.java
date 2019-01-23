package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    Socket s;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    String username = null;
    String password = null;
    String name;
    String family_name;
    String email;
    String session;
    boolean flag;
    boolean isFlag;
    boolean flag2;
    boolean isFlag2;
    boolean flag3;

    ClientHandler(Socket s) {
        this.s = s;
        try {
            dataInputStream = new DataInputStream(s.getInputStream());
            dataOutputStream = new DataOutputStream(s.getOutputStream());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        String what_to_do = null;
        do {
            try {
                what_to_do = dataInputStream.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (what_to_do.equals("register")) {
                try {
                    Register();
                } catch (ExistingUserException e) {
                    try {
                        dataOutputStream.writeUTF(e.getMessage());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            if (what_to_do.equals("login")) {
                try {
                    Login();
                } catch (UnknownUserException e) {
                    try {
                        dataOutputStream.writeUTF(e.getMessage());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            if (what_to_do.equals("logout")) {
                try {
                    Logout();
                } catch (InvalidSessionException e) {
                    try {
                        dataOutputStream.writeUTF(e.getMessage());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        } while (what_to_do.equals("Exit"));
    }

    public void Register() throws ExistingUserException {
        try {
            username = dataInputStream.readUTF();
            password = dataInputStream.readUTF();
            name = dataInputStream.readUTF();
            family_name = dataInputStream.readUTF();
            email = dataInputStream.readUTF();

        } catch (IOException e) {
            e.printStackTrace();
        }

        flag = true;
        isFlag = true;
        flag2 = true;
        isFlag2 = true;
        flag3 = true;

        if (username.equals(null) || password.equals(null) || name.equals(null) || email.equals(null)) {
            flag3 = false;
        }

        for (int i = 0; i < Server.username.size(); i++) {
            if (Server.username.get(i).equals(username)) {
                flag = false;
                // username e tekrari
                //wrongUsername = findViewById(R.id.wrongUsername);
                throw new ExistingUserException("User Exists");
            }
        }
        for (int i = 0; i < Server.email.size(); i++) {
            if (Server.email.get(i).equals(email)) {
                isFlag2 = false;
                // email e tekrari
                //wrongEmail = findViewById(R.id.wrongEmail);
                throw new ExistingUserException("User Exists");
            }
        }

        //if (email should contains @ and .com) {
        isFlag = false;
        //}
        if (isFlag) {
            //wrongEmail = findViewById(R.id.wrongEmail);
            try {
                throw new WrongEmailFormatException("Your email's format is wrong");
            } catch (WrongEmailFormatException e) {
                e.printStackTrace();
            }
        }
        //if (password with correct format) {
        flag2 = false;
        //}
        if (flag2) {
            //wrongPassword = findViewById(R.id.wrongPassword);
        }
        if (flag && isFlag2 && !isFlag && !flag2 && flag3) {
            try {
                dataOutputStream.writeUTF("you registered successfully");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void Login() throws UnknownUserException {
        try {
            username = dataInputStream.readUTF();
            password = dataInputStream.readUTF();

        } catch (IOException e) {
            e.printStackTrace();
        }
        flag = true;
        isFlag = true;
        flag2 = true;

        for (int i = 0; i < Server.username.size(); i++) {
            if (Server.username.get(i).equals(username)) {
                flag = false;
            }
            if (Server.password.get(i).equals(password)) {
                isFlag = false;
            }
            if (Server.email.get(i).equals(email)) {
                flag2 = false;
            }
        }
        if (flag) {
            throw new UnknownUserException("Username is wrong!");
        }
        if (isFlag) {
            try {
                throw new WrongPasswordException("Password is wrong!");
            } catch (WrongPasswordException e) {
                e.printStackTrace();
            }
        }
        if (flag2) {
            try {
                throw new UnknownEmailException("Email is wrong");
            } catch (UnknownEmailException e) {
                e.printStackTrace();
            }
        }
        String s = "";
        if ((flag == false && isFlag == false) || (flag2 == false && isFlag == false)) {
            for (int i = 0; i < 30; i++) {
                Server.sn[i] = (int) (Math.random() * 10);
                s = s + Integer.toString(Server.sn[i]);
            }
            Server.session.add(s);
            try {
                dataOutputStream.writeUTF(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void Logout() throws InvalidSessionException {
        try {
            session = dataInputStream.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        flag = true;
        for (int i = 0; i < Server.session.size(); i++) {
            if (Server.session.get(i).equals(session)) {
                flag = false;
            }
        }
        if (flag) {
            throw new InvalidSessionException("Invalid session!");
        } else {
            try {
                dataOutputStream.writeUTF("your session logout successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}