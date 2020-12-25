package com.example.mydorm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Profil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
    }

    public void profilToHome(View view){
            Intent intent = new Intent(Profil.this, Dashboard.class);
            startActivity(intent);
    }
    public void profilToAds(View view){
        /*
        Intent intent = new Intent(Profil.this, Ads.class);
        startActivity(intent);

         */
    }


}