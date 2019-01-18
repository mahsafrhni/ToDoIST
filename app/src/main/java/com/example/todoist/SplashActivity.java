package com.example.todoist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.todoist.R;

public class SplashActivity extends AppCompatActivity {

    TextView splash;
    //private MediaPlayer splashSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splash = findViewById(R.id.splash);

       // splashSound = MediaPlayer.create(this, R.raw.sound);
       // splashSound.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, StartActivity.class);
                startActivity(i);
                finish();
            }
        },2000);

    }
}
