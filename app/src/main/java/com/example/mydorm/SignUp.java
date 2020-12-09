package com.example.mydorm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    Button callLogin;
    Button callSignUp;


    TextInputLayout regFName, regLName, regStudentId, regEmail, regPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        regFName = findViewById(R.id.input_fname);
        regLName = findViewById(R.id.input_fname);
        regStudentId = findViewById(R.id.input_studentid);
        regEmail = findViewById(R.id.input_mail);
        regPassword = findViewById(R.id.input_password);



        callLogin = findViewById(R.id.btn_loginPage);

        callLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });

        callSignUp = findViewById(R.id.btn_signup);
        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}