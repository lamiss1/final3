package com.example.final3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Produit extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageButton button ;
    ImageButton button2 ;
    ImageButton button3 ;
    ImageButton button4 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);
        getSupportActionBar().hide();

        drawerLayout= findViewById(R.id.drawer_layout);

        button = findViewById(R.id.next1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),produit1.class);
                startActivity(intent);
            }
        });

        button2 = findViewById(R.id.next2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),produit2.class);
                startActivity(intent);
            }
        });
        button3 = findViewById(R.id.next3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),produit3.class);
                startActivity(intent);
            }
        });
        button4 = findViewById(R.id.next4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),produit4.class);
                startActivity(intent);
            }
        });

    }
    public void ClickMenu (View view){
        MainActivity2.openDrawer(drawerLayout);
    }
    public void clickLogo (View view){
        MainActivity2.closeDrawer(drawerLayout);

    }
    public void ClickEspaceMaman(View view){
        MainActivity2.redirectActivity(this,EspaceMaman.class);

    }

    public void ClickRatee(View view){
        MainActivity2.redirectActivity(this,Ratee.class);
    }
    public void ClickProduit ( View view ){
        recreate();
    }
    public void ClickQ_A(View view){
        MainActivity2.redirectActivity(this,Q_A.class);
    }
    public void ClickHome(View view){
        MainActivity2.redirectActivity(this,MainActivity2.class);
    }
    public void ClickLogout(View view){
        MainActivity2.logout(this);
    }
    public void ClickConseils( View view){
        MainActivity2.redirectActivity(this,Conseils.class);
    }
    public  void ClickRendez_Vous(View view){
        MainActivity2.redirectActivity(this,Rendez_Vous.class);
    }
    public void ClickAlerte(View view){
        MainActivity2.redirectActivity(this,Alerte.class);
    }


    @Override
    protected void onPause() {
        super.onPause();
        MainActivity2.closeDrawer(drawerLayout);
    }


}