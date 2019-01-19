package com.example.todoist;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button b1, b2;
    EditText ed1, ed2;
    TextView tx1;
    int counter = 3;

//    public LoginActivity(Intent i) {
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1 = findViewById(R.id.button);
        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText2);
        b2 = findViewById(R.id.button2);
        tx1 = findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();

                if (ed1.getText().toString().equals("asmin") &&
                        ed2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                    tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.RED);
                    counter--;
                    tx1.setText(Integer.toString(counter));
                    if (counter == 0) {
                        b1.setEnabled(false);
                    }
                }

//                for (int i = 0; i < registrationNumber; i++) {
//                    if (password.equals(people[i].getPassword()) &&
//                            username.equals(people[i].getUsername())) {
//                        System.out.println("Welcome to the system " + people[i].getUsername() + "!");
//                        signedIn = true;
//                        register.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                new Handler().postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        Intent i = new Intent(RegisterActivity.this, TasksActivity.class);
//                                        startActivity(i);
//                                        finish();
//                                    }
//                                }, 0);
//                            }
//                        });
//
//                    } else {
//                        signedIn = false;
//                    }
//                }
//                if (!signedIn) {
//                    System.out.println("Username or Password is wrong!, try again");
//                    signin();
//                }
            }

    });

        b2.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
        finish();
    }
    });
}

    public void login() {

        if (ed1.getText().toString().equals("admin") &&
                ed2.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(),
                    "Redirecting...", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();

            tx1.setVisibility(View.VISIBLE);
            tx1.setBackgroundColor(Color.RED);
            counter--;
            tx1.setText(Integer.toString(counter));

            if (counter == 0) {
                b1.setEnabled(false);
            }
        }
    }
}
