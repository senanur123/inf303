package com.example.mydorm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth= FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()==null)
        {
            Intent loginIntent = new Intent(MainActivity.this,Login.class);
            startActivity(loginIntent);
            Toast.makeText(getApplicationContext(),"Lütfen giriş yapınız.",Toast.LENGTH_SHORT).show();
        }
    }
}