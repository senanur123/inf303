package com.example.mydorm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.mydorm.R.id.btn_signupPage;

public class Login extends AppCompatActivity {

    FirebaseAuth mAuth;
    Button callSignUp ;
    Button btnlogin;
    TextInputLayout lgnemail , lgnpassword ;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        lgnemail = findViewById(R.id.login_mail);
        lgnpassword =findViewById(R.id.login_password);
        progressbar =findViewById(R.id.progressbar);
        mAuth = FirebaseAuth.getInstance();
        btnlogin = findViewById(R.id.btn_login);
        callSignUp = findViewById(btn_signupPage);
        // Hatasız.

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = lgnemail.getEditText().getText().toString().trim();
                String password = lgnpassword.getEditText().getText().toString().trim();

                //hatasız.

                if (TextUtils.isEmpty(email)) {
                    lgnemail.setError("Email gereklidir!");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    lgnpassword.setError("Şifre gereklidir!");
                    return;

                }
                progressbar.setVisibility(View.VISIBLE);

                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "Giriş Başarılıdır!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(Login.this, "Hata!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressbar.setVisibility(View.GONE);

                        }
                    }
                });

            }

        });

        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });


    }

}


