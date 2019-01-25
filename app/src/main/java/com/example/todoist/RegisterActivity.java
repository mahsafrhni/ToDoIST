package com.example.dena.todolist;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {

    Button cancel, register;
    EditText username, email, name, family_name, password;
    RadioButton normal, silver, golden;
    RegisterServer registerServer;
    boolean isCorrect;

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
        registerServer = new RegisterServer();

        final String Username = username.getText().toString();
        final String Password = password.getText().toString();
        final String Email = email.getText().toString();
        final String Name = name.getText().toString();
        final String Family_Name = family_name.getText().toString();
        isCorrect = false;



        String read1 = null, read2 = null, read3 = null, read4 = null, read5 = null;
//        while (!isCorrect) {
//            try {
//                read1 = SplashActivity.dataInputStream.readUTF();
//                read2 = SplashActivity.dataInputStream.readUTF();
//                read3 = SplashActivity.dataInputStream.readUTF();
//                read4 = SplashActivity.dataInputStream.readUTF();
//                //read5 = SplashActivity.dataInputStream.readUTF();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (read1.equals("Null")) {
//                isCorrect = false;
//                Toast.makeText(getApplicationContext(), "You must complete all the fields", Toast.LENGTH_SHORT).show();
//            }
//            if (read2.equals("repeatedUsername")) {
//                isCorrect = false;
//                Toast.makeText(getApplicationContext(), "this username is already taken", Toast.LENGTH_SHORT).show();
//            }
//            if (read3.equals("repeatedEmail")) {
//                isCorrect = false;
//                Toast.makeText(getApplicationContext(), "this email is already taken", Toast.LENGTH_SHORT).show();
//            }
//            if (read4.equals("wrongEmailFormat")) {
//                isCorrect = false;
//                Toast.makeText(getApplicationContext(), "Your email's format is wrong", Toast.LENGTH_SHORT).show();
//            }
////            if (read5.equals("wrongPasswordFormat")) {
////                isCorrect = false;
////                Toast.makeText(getApplicationContext(), "Your password's format is wrong", Toast.LENGTH_SHORT).show();
////            }
//            if (read1.equals("nNull") && read2.equals("nRepeatedUsername") && read3.equals("nRepeatedEmail") && read4.equals("nWrongEmailFormat")) {
//                isCorrect = true;
//                Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
//            }
//        }

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerServer.execute(Username, Password, Email, Name, Family_Name);
                if (isCorrect) {
                    startActivity(new Intent(RegisterActivity.this, AddTask.class));
                } else {
                    Toast.makeText(getApplicationContext(), "You need to correct your information first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, StartActivity.class));
            }
        });
    }


    private class RegisterServer extends AsyncTask <String, String, String> {

        String isSuccessful;

        @Override
        protected String doInBackground(String... data) {
            try {
                SplashActivity.dataOutputStream.writeUTF(data[0]);
                SplashActivity.dataOutputStream.flush();
                SplashActivity.dataOutputStream.writeUTF(data[1]);
                SplashActivity.dataOutputStream.flush();
                SplashActivity.dataOutputStream.writeUTF(data[2]);
                SplashActivity.dataOutputStream.flush();
                SplashActivity.dataOutputStream.writeUTF(data[3]);
                SplashActivity.dataOutputStream.flush();
                SplashActivity.dataOutputStream.writeUTF(data[4]);
                SplashActivity.dataOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return isSuccessful;
        }

        @Override
        protected void onPostExecute(String result) {
            //
        }

        @Override
        protected void onPreExecute() {
            //
        }

        @Override
        protected void onProgressUpdate(String... text) {
            //
        }
    }
}
