package com.example.mydorm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    EditText denememail;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        denememail = findViewById(R.id.denememail);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                checkEmail(denememail);
            }
        });
    }
    private  boolean checkEmail(EditText denememail){
        String email = denememail.getText().toString();

        if (email.contains("tau.edu.tr")==true){
            Toast.makeText(this,"Email true",Toast.LENGTH_SHORT).show();

            System.out.println(email.contains("tau.edu.tr")==true);
            return true;
        }
        else{
            Toast.makeText(this,"Email false",Toast.LENGTH_SHORT).show();
            return false;
        }
    }


}