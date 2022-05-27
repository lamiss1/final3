package com.example.final3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.media2.widget.VideoView;

import android.net.Uri;
import android.widget.MediaController;
import android.widget.Button;
import android.widget.VideoView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Conseils extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Button lirelasuite1;
    Button lirelasuite2;
    Button lirelasuite3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conseils);

        getSupportActionBar().hide();

        drawerLayout = findViewById(R.id.drawer_layout);

        lirelasuite1 = findViewById(R.id.lirelasuite1);
        lirelasuite1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Lirelasuite1.class);
                startActivity(intent);
            }
        });

        lirelasuite2 = findViewById(R.id.lirelasuite2);
        lirelasuite2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Lirelasuite2.class);
                startActivity(intent);
            }
        });
        lirelasuite3 = findViewById(R.id.lirelasuite3);
        lirelasuite3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Lirelasuite3.class);
                startActivity(intent);
            }
        });

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        
       videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoclip));
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();
    }

    public void ClickMenu (View view){
        MainActivity2.openDrawer(drawerLayout);
    }
    public void clickLogo (View view){
        MainActivity2.closeDrawer(drawerLayout);
    }
    public void ClickRatee(View view){
        MainActivity2.redirectActivity(this,Ratee.class);
    }

    public void ClickHome(View view){
        MainActivity2.redirectActivity(this,MainActivity2.class);
    }
    public void ClickEspaceMaman(View view){
        MainActivity2.redirectActivity(this,EspaceMaman.class);
    }
    public void ClickProduit ( View view ){
        MainActivity2.redirectActivity(this,Produit.class);
    }
    public void ClickQ_A(View view){
        MainActivity2.redirectActivity(this,Q_A.class);
    }
    public void ClickLogout(View view){
        MainActivity2.logout(this);
    }
    public void ClickConseils (View view){
        recreate();
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