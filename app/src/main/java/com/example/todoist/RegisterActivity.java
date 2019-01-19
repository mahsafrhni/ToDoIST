package com.example.dena.todolist;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RegisterActivity extends AppCompatActivity {

    Button cancel, register;
    EditText username, email, name, family_name, password;
    RadioButton normal, silver, golden;
    TextView tx1;


    TextView wrongUsername, wrongPassword, wrongEmail;


    static Socket s;
    static DataInputStream dataInputStream;
    static DataOutputStream dataOutputStream;
    static String user_type;
    static String session;
    static boolean flag;
    static boolean isFlag;
    static boolean flag2;





    public RegisterActivity(Intent i) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register = findViewById(R.id.register);
        cancel = findViewById(R.id.cancel);
        username = findViewById(R.id.name);
        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        family_name = findViewById(R.id.family_name);
        password = findViewById(R.id.password);
        normal = findViewById(R.id.normal);
        silver = findViewById(R.id.silver);
        golden = findViewById(R.id.golden);


        tx1 = findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);



        username.getText().toString();
        email.getText().toString();
        name.getText().toString();
        family_name.getText().toString();
        password.getText().toString();


        //check data
        flag = true;
        isFlag = true;
        flag2 = true;
        for (int i = 0; i < Server.username.size(); i++) {
            if (Server.username.get(i).equals(username)) {
                flag = false;
                wrongUsername = findViewById(R.id.wrongUsername);
                try {
                    throw new ExistingUserException("User Exists");
                } catch (ExistingUserException e) {
                    e.printStackTrace();
                }
            }
        }
        //if (email should contains @ and .com) {
            isFlag = false;
        //}
        if (isFlag) {
            wrongEmail = findViewById(R.id.wrongEmail);
            try {
                throw new WrongEmailFormatException("Your email's format is wrong");
            } catch (WrongEmailFormatException e) {
                e.printStackTrace();
            }
        }
        if (flag && !isFlag) {
            try {
                dataOutputStream.writeUTF("you registered successfully");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        //if (password with correct format) {
            flag2 = false;
        //}
        if (flag2) {
            wrongPassword = findViewById(R.id.wrongPassword);
        }


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(RegisterActivity.this, StartActivity.class);
                        startActivity(i);
                        finish();
                    }
                }, 0);
            }
        });
    }
}


