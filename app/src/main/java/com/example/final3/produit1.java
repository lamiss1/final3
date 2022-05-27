package com.example.final3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class produit1 extends AppCompatActivity {
    Button achat1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit1);

        getSupportActionBar().hide();

        achat1 = findViewById(R.id.achat1);

        achat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Achat.class);
                startActivity(intent);
            }
        });
    }
}