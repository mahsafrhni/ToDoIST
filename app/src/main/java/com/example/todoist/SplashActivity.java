package com.example.dena.todolist;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SplashActivity extends AppCompatActivity {
    static DataOutputStream dataOutputStream;
    static DataInputStream dataInputStream;
    static Socket socket;
    TextView splash;
    //private MediaPlayer splashSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splash = findViewById(R.id.splash);

//        // splashSound = MediaPlayer.create(this, R.raw.sound);
//       // splashSound.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, StartActivity.class);
                startActivity(i);

                finish();
            }
        }, 2000);

        new SplashServer().execute();
//            Toast toast = Toast.makeText(getApplicationContext(), "Hello Javatpoint", Toast.LENGTH_SHORT);
//            toast.setMargin(50, 50);
//            toast.show();
    }

    private class SplashServer extends AsyncTask<String, String, String> {

        String isSuccessful;

        @Override
        protected String doInBackground(String... data) {

            try {
                System.out.println("doInBackground called.");
                socket = new Socket("172.20.10.8", 5000);
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());
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
