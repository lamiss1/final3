package com.example.final3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class produit4 extends AppCompatActivity {
             Button achat4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit4);
        getSupportActionBar().hide();


        achat4 = findViewById(R.id.achat4);
        achat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Achat.class);
                startActivity(intent);
            }
        });
    }
}