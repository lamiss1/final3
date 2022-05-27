package com.example.final3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Achat extends AppCompatActivity  implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achat);
        getSupportActionBar().hide();
        Button btn = findViewById(R.id.confirmer);
        btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"Achat se fait avec succées",Toast.LENGTH_SHORT).show();
    }
}