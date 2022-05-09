package com.example.final3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class AboutUs extends AppCompatActivity {
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        drawerLayout= findViewById(R.id.drawer_layout);

    }
    public void ClickMenu (View view){
        MainActivity2.openDrawer(drawerLayout);
    }
    public void clickLogo (View view){
        MainActivity2.closeDrawer(drawerLayout);

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
    public void ClickLogout(View view){
        MainActivity2.logout(this);
    }
    public void ClickAboutUs (View view){
        recreate();
    }
    public void ClickConseils( View view){
        MainActivity2.redirectActivity(this,Conseils.class);
    }
    public  void ClickRendez_Vous(View view){
        MainActivity2.redirectActivity(this,Rendez_Vous.class);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity2.closeDrawer(drawerLayout);
    }
}