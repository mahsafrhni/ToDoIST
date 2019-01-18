package com.example.todoist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {

    Button cancel, register;
    EditText username, email, name, family_name, password;
    RadioButton user_type;
    TextView tx1;

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
                finish();
            }
        });
    }
}

