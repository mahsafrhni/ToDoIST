package com.example.todoist;

import android.content.Intent;

import android.os.AsyncTask;

import android.os.Handler;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;

import android.view.View;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import android.widget.ImageView;

import android.widget.TextView;

import android.widget.Toast;

import java.io.IOException;


public class StartActivity extends AppCompatActivity {


    Button log_in, register;

    ImageView imageView;

    boolean flag1, flag2;

    StartServer startServer;


    @Override

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

        log_in = findViewById(R.id.login);

        register = findViewById(R.id.register);

        imageView = findViewById(R.id.imageView);

        startServer = new StartServer();

        flag1 = false;

        flag2 = false;


        log_in.setOnClickListener(new View.OnClickListener() {


            @Override

            public void onClick(View v) {

                startActivity(new Intent(StartActivity.this, LoginActivity.class));

                flag1 = true;

                startServer.execute();

            }

        });


        register.setOnClickListener(new View.OnClickListener() {


            @Override

            public void onClick(View v) {

                startActivity(new Intent(StartActivity.this, RegisterActivity.class));

                flag2 = true;

                startServer.execute();

            }

        });

        Animation animationToLeft = new TranslateAnimation(400, 0, 0, 0);
        animationToLeft.setDuration(12000);
        animationToLeft.setRepeatMode(Animation.RESTART);
        animationToLeft.setRepeatCount(Animation.INFINITE);
        Animation animationToRight = new TranslateAnimation(0, 400, 0, 0);
        animationToRight.setDuration(12000);
        animationToRight.setRepeatMode(Animation.RESTART);
        animationToRight.setRepeatCount(Animation.INFINITE);
        TextView textViewMarqToLeft = (TextView) findViewById(R.id.textViewMarqToLeft);
        TextView textViewMarqToRight = (TextView) findViewById(R.id.textViewMarqToRight);
        textViewMarqToLeft.setAnimation(animationToLeft);
        textViewMarqToRight.setAnimation(animationToRight);
        String textLeft = "MyTaskManager";
        String textRight = "MyTaskManager";
        textViewMarqToLeft.setText(textLeft);
        textViewMarqToRight.setText(textRight);
    }

    private class StartServer extends AsyncTask<String, String, String> {


        String isSuccessful;


        @Override

        protected String doInBackground(String... data) {

            if (flag1) {

                try {

                    SplashActivity.dataOutputStream.writeUTF("login");

                    SplashActivity.dataOutputStream.flush();

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

            if (flag2) {

                try {

                    SplashActivity.dataOutputStream.writeUTF("register");

                    SplashActivity.dataOutputStream.flush();

                    //Log.d("StartActivity", "register");

                } catch (IOException e) {

                    e.printStackTrace();

                }

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
