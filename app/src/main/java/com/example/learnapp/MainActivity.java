package com.example.learnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnLogin,btnSignup;
    EditText edUsername,edEmail,edPassword;

    String username,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnsignup);
        edUsername = findViewById(R.id.username);
        edEmail = findViewById(R.id.email);
        edPassword = findViewById(R.id.password);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(MainActivity.this, ProfileActivity.class);
                username = edUsername.getText().toString().trim();
                email = edEmail.getText().toString().trim();
                password = edPassword.getText().toString().trim();

                if (username.isEmpty()){
                    edUsername.setError("Enter Username");
                }else if (email.isEmpty()){
                    edEmail.setError("Enter Email");
                }
                else if (password.isEmpty()){
                    edPassword.setError("Enter Password");
                }


                go.putExtra("username",username);
                go.putExtra("email",email);
                go.putExtra("password",password);


                startActivity(go);
                finish();
            }
        });
    }
}
