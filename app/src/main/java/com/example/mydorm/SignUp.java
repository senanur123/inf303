package com.example.mydorm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    FirebaseAuth fAuth;

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

        fAuth = FirebaseAuth.getInstance();

       /* if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        } */


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


                String fname = regFName.getEditText().getText().toString().trim();
                String lname = regLName.getEditText().getText().toString().trim();
                String id = regStudentId.getEditText().getText().toString().trim();
                String mail = regEmail.getEditText().getText().toString().trim();
                String pass = regPassword.getEditText().getText().toString().trim();

                System.err.println(mail);

                fAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"User Created.",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Login.class));
                            
                        } else {
                            Toast.makeText(SignUp.this, "Error: " + task.getException(), Toast.LENGTH_SHORT).show();
                            System.err.println(task.getException());
                        }
                    }
                });


            }
        });


    }
}