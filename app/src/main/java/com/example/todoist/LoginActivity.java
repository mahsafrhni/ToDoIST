package com.example.dena.todolist;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    Button login, cancel;
    EditText username, password;
    TextView tx1;
    int counter = 3;
    LoginServer loginServer;
    boolean isCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.login);
        cancel = findViewById(R.id.cancel);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        tx1 = findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);
        loginServer = new LoginServer();

        final String Username = username.getText().toString();
        final String Password = password.getText().toString();
        isCorrect = false;

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginServer.execute(Username, Password);

//                try {
//                    SplashActivity.dataInputStream.readUTF();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

                // if (re)

//                if (username.getText().toString().equals("admin") &&
//                        password.getText().toString().equals("admin")) {
//                    Toast.makeText(getApplicationContext(), "login successful!", Toast.LENGTH_SHORT).show();
//                } else {
//
//                //if (age 3 bar username/email va password e eshtebah vared kard, bargarde ru StartActivity)

                String read1 = null, read2 = null, read3 = null;
                try {
                    read1 = SplashActivity.dataInputStream.readUTF();
                    read2 = SplashActivity.dataInputStream.readUTF();
                    read3 = SplashActivity.dataInputStream.readUTF();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (read1.equals("wrongUsername")) {
                    isCorrect = false;
                    Toast.makeText(getApplicationContext(), "Wrong username", Toast.LENGTH_SHORT).show();
                }
                if (read2.equals("wrongPassword")) {
                    isCorrect = false;
                    Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_SHORT).show();
                }
                if (read3.equals("wrongEmail")) {
                    isCorrect = false;
                    Toast.makeText(getApplicationContext(), "Wrong email", Toast.LENGTH_SHORT).show();
                }
                if (read1.equals("nWrongUsername") && read2.equals("nWrongPassword") && read3.equals("nWrongEmail")) {
                    isCorrect = true;
                    Toast.makeText(getApplicationContext(), "Login successfully", Toast.LENGTH_SHORT).show();
                }

                if (isCorrect) {
                    startActivity(new Intent(LoginActivity.this, AddTask.class));
                } else {
                    Toast.makeText(getApplicationContext(), "You need to enter correct username and password first", Toast.LENGTH_SHORT).show();
                }

//                    tx1.setVisibility(View.VISIBLE);
//                    tx1.setBackgroundColor(Color.TRANSPARENT);
//                    counter--;
//                    tx1.setText(Integer.toString(counter));
//
//                    if (counter == 0) {
//                        startActivity(new Intent(LoginActivity.this, StartActivity.class));
//                        //login.setEnabled(false);
//                    }
//                 }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, StartActivity.class));
            }
        });
    }

    private class LoginServer extends AsyncTask<String, String, String> {

        String isSuccessful;

        @Override
        protected String doInBackground(String... data) {
            try {
                SplashActivity.dataOutputStream.writeUTF(data[0]);
                SplashActivity.dataOutputStream.flush();
                SplashActivity.dataOutputStream.writeUTF(data[1]);
                SplashActivity.dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return isSuccessful;
        }

        @Override
        protected void onPostExecute(String result) {

        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onProgressUpdate(String... text) {

        }
    }
}
