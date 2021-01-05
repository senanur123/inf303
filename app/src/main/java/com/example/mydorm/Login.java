/*package com.example.mydorm;

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
                            startActivity(new Intent(getApplicationContext(), Dashboard.class));
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


*/

package com.example.mydorm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.example.mydorm.R.id.btn_signupPage;

public class Login extends AppCompatActivity {

    FirebaseAuth mAuth;
    Button callSignUp ;
    Button btnlogin, btnforgot;
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
        btnforgot= findViewById(R.id.password_forgot);
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

        btnforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRecowerPasswordDialog();

            }
        });

    }

    private void showRecowerPasswordDialog() {
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setTitle("Recover Password");
        LinearLayout linearLayout = new LinearLayout(this);
        EditText emailEt =  new EditText(this);
        emailEt.setHint("Email");
        emailEt.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        emailEt.setMinEms(10);
        linearLayout.addView(emailEt);
        linearLayout.setPadding(10,10,10,10);

        builder.setView(linearLayout);

        builder.setPositiveButton("Recover ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String email = emailEt.getText().toString().trim();
                beginRecovery(email);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();

    }

    private void beginRecovery(String email) {
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Login.this,"Email sent", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(Login.this,"Failed!",Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Login.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}