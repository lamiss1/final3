package com.example.final3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class EspaceMaman extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_maman);
        drawerLayout=findViewById(R.id.drawer_layout);
    }
    public void ClickMenu (View view){
        MainActivity2.openDrawer(drawerLayout);
    }
    public void clickLogo (View view){
        MainActivity2.closeDrawer(drawerLayout);

    }
    public void ClickEspaceMaman(View view){
        recreate();
    }
    public void ClickProduit ( View view ){

        MainActivity2.redirectActivity(this,Produit.class);
    }


    public void ClickHome(View view){
        MainActivity2.redirectActivity(this,MainActivity2.class);
    }

    public void ClickLogout(View view){
        MainActivity2.logout(this);
    }
    public void ClickAboutUs (View view){
        MainActivity2.redirectActivity(this,AboutUs.class);
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