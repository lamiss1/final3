package com.example.final3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class produit3 extends AppCompatActivity {
    Button achat3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit3);


        achat3 = findViewById(R.id.achat3);
        getSupportActionBar().hide();
        achat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Achat.class);
                startActivity(intent);
            }
        });
    }
}