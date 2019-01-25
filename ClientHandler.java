package com.company;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ClientHandler implements Runnable {
    Socket s;
    //String client;
    static DataInputStream dataInputStream;
    static DataOutputStream dataOutputStream;
    static String username;
    static String password;
    static String name;
    static String family_name;
    static String email;
    String session;
    boolean flag;
    boolean isFlag;
    boolean flag2;
    boolean isFlag2;
    boolean flag3;
    boolean flagV;
    static ArrayList<Tasks> tasks;

    ClientHandler(Socket s) {
        this.s = s;
        //File file = new File("file.txt");

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
                System.out.println("ghabl az read");
                what_to_do = dataInputStream.readUTF();
                System.out.println("bad az read");
                System.out.println(what_to_do);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (what_to_do.equals("register")) {
                try {
                    Register();
                } catch (ExistingUserException e) {
                    e.printStackTrace();
                }
            }
            if (what_to_do.equals("login")) {
                try {
                    Login();
                } catch (UnknownUserException e) {
                    e.printStackTrace();
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
        } while (!what_to_do.equals("Exit"));
    }

    public void Register() throws ExistingUserException {
        try {
            System.out.println("before read");

            username = dataInputStream.readUTF();
            password = dataInputStream.readUTF();
            email = dataInputStream.readUTF();
            name = dataInputStream.readUTF();
            family_name = dataInputStream.readUTF();

            System.out.println(username);
            System.out.println(password);
            System.out.println(email);
            System.out.println(name);
            System.out.println(family_name);

            System.out.println("after read");
        } catch (Exception e) {
            e.printStackTrace();
        }
        flag = true;
        isFlag = true;
        flag2 = true;
        isFlag2 = true;
        flag3 = true;

        if (username.equals(null) || password.equals(null) || name.equals(null) || email.equals(null)) {
            flag3 = false;
            try {
                dataOutputStream.writeUTF("Null");
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw new NullPointerException();
        } else {
            try {
                dataOutputStream.writeUTF("nNull");
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // repeated username
        for (int i = 0; i < Server.users.size(); i++) {
            if (Server.users.get(i).username.equals(username)) {
                flag = false;
                try {
                    dataOutputStream.writeUTF("repeatedUsername");
                    dataOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                throw new ExistingUserException("User Exists");
            }
        } if (flag) {
            try {
                dataOutputStream.writeUTF("nRepeatedUsername");
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //repeated email
        for (int i = 0; i < Server.users.size(); i++) {
            if (Server.users.get(i).email.equals(email)) {
                isFlag2 = false;
                try {
                    dataOutputStream.writeUTF("repeatedEmail");
                    dataOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                throw new ExistingUserException("Email Exists");
            }
        }
        if (isFlag2) {
            try {
                dataOutputStream.writeUTF("nRepeatedEmail");
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        flagV = false;
        if (email.contains("@")) {
            String[] s = email.split("@");
            for (int i = 0; i < s.length; i++) {
                System.out.println(s[i]);
            }
            if (s[1].contains(".")) {
                String[] s2 = s[1].split(Pattern.quote("."));
                if (s2[1].equals("com")) {
                    flagV = true;
                }
            }
        }
        if (flagV) {
            isFlag = false;
            try {
                dataOutputStream.writeUTF("nWrongEmailFormat");
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            isFlag = true;
            try {
                dataOutputStream.writeUTF("wrongEmailFormat");
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (isFlag) {
            //wrongEmail = findViewById(R.id.wrongEmail);
            try {
                throw new WrongEmailFormatException("Your email's format is wrong");
            } catch (WrongEmailFormatException e) {
                e.printStackTrace();
            }
        }
//        //if (password with correct format) {
//        flag2 = false;
//        try {
//            dataOutputStream.writeUTF("nWrongPasswordFormat");
//            dataOutputStream.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //}
//        if (flag2) {
//            try {
//                dataOutputStream.writeUTF("wrongPasswordFormat");
//                dataOutputStream.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        if (flag && isFlag2 && !isFlag /*&& !flag2*/ && flag3) {
            ID id = new ID();
            User personLog = User.search(username);
            if (personLog.isNormal) {
                User user = new NormalUser(id);
                Server.users.set(User.numOfUsers - 1, user);
                user.user_ability();
            }
            if (personLog.isSilver) {
                User user = new SilverUser(id);
                Server.users.set(User.numOfUsers - 1, user);
                user.user_ability();
            }
            if (personLog.isGolden) {
                User user = new GoldenUser(id);
                Server.users.set(User.numOfUsers - 1, user);
                user.user_ability();
            }
        }
    }

    public void Login() throws UnknownUserException {
        try {
            System.out.println("BEFORE");
            username = dataInputStream.readUTF();
            password = dataInputStream.readUTF();
            System.out.println(username);
            System.out.println(password);
            System.out.println("AFTER");


        } catch (IOException e) {
            e.printStackTrace();
        }

        flag = true;
        isFlag = true;
        flag2 = true;

        for (int i = 0; i < Server.users.size(); i++) {
            if (Server.users.get(i).username.equals(username)) {
                flag = false;
            }
            if (Server.users.get(i).password.equals(password)) {
                isFlag = false;
            }
            if (Server.users.get(i).email.equals(email)) {
                flag2 = false;
            }
        }
        if (flag) {
            try {
                dataOutputStream.writeUTF("wrongUsername");
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            throw new UnknownUserException("Username is wrong!");
        } else {
            try {
                dataOutputStream.writeUTF("nWrongUsername");
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (isFlag) {
            try {
                dataOutputStream.writeUTF("wrongPassword");
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                throw new WrongPasswordException("Password is wrong!");
            } catch (WrongPasswordException e) {
                e.printStackTrace();
            }
        } else {
            try {
                dataOutputStream.writeUTF("nWrongPassword");
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (flag2) {
            try {
                dataOutputStream.writeUTF("wrongEmail");
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                throw new UnknownEmailException("Email is wrong");
            } catch (UnknownEmailException e) {
                e.printStackTrace();
            }
        } else {
            try {
                dataOutputStream.writeUTF("nWrongEmail");
                dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if ((flag == false && isFlag == false) || (flag2 == false && isFlag == false)) {

            int i;

            User personLog = User.search(username);

            if (personLog.isNormal) {
                for (i = 0; i < User.numOfUsers; i++) {
                    if (Server.users.get(i).username.equals(username) && Server.users.get(i).password.equals(password)) {
                        ID id = new ID();
                        NormalUser normal = new NormalUser(id);
                        normal.user_ability();
                        Server.users.set(i, normal);
                        User.numOfUsers--;
                    }
                }
            }
            if (personLog.isSilver) {
                for (i = 0; i < User.numOfUsers; i++) {
                    if (Server.users.get(i).username.equals(username) && Server.users.get(i).password.equals(password)) {
                        ID id = new ID();
                        SilverUser silver = new SilverUser(id);
                        silver.user_ability();
                        Server.users.set(i, silver);
                        User.numOfUsers--;
                    }
                }
            }

            if (personLog.isGolden) {
                for (i = 0; i < User.numOfUsers; i++) {
                    if (Server.users.get(i).username.equals(username) && Server.users.get(i).password.equals(password)) {
                        ID id = new ID();
                        GoldenUser golden = new GoldenUser(id);
                        golden.user_ability();
                        Server.users.set(i, golden);
                        User.numOfUsers--;
                    }
                }
            }


            String s = "";

            for (i = 0; i < 30; i++) {
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
