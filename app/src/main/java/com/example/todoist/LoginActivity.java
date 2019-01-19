package com.example.dena.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {
    Button b1, b2;
    EditText username, password;
    TextView tx1;
    int counter = 3;

    public LoginActivity(Intent i) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1 = findViewById(R.id.button);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        b2 = findViewById(R.id.button2);
        tx1 = findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.getText().toString();
                password.getText().toString();
                try {
                    ClientHandler.Login();
                } catch (UnknownUserException e) {
                    e.printStackTrace();
                }
//                if (username.getText().toString().equals("admin") &&
//                        password.getText().toString().equals("admin")) {
//                    Toast.makeText(getApplicationContext(),
//                            "Redirecting...", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
//
//                    tx1.setVisibility(View.VISIBLE);
//                    tx1.setBackgroundColor(Color.RED);
//                    counter--;
//                    tx1.setText(Integer.toString(counter));
//
//                    if (counter == 0) {
//                        b1.setEnabled(false);
//                    }
//                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
