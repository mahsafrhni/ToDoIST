package com.example.todoist;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    Button cancel, register;
    EditText username, email, name, family_name, password;
    RadioButton normal, silver, golden;
    TextView tx1;

//    public RegisterActivity(Intent i) {
//
//    }

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

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.getText().toString();
                email.getText().toString();
                name.getText().toString();
                family_name.getText().toString();
                password.getText().toString();
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

