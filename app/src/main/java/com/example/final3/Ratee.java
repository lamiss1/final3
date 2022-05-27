package com.example.final3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Ratee extends AppCompatActivity {
    DrawerLayout drawerLayout;
    RecyclerView recyclerView;
    FloatingActionButton fbAdd ;
    MainAdapter adapter;

    JSONArray jsonArray = new JSONArray();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ratee);

        getSupportActionBar().hide();

        drawerLayout= findViewById(R.id.drawer_layout);
        recyclerView = findViewById(R.id.recycler_view);


        fbAdd = findViewById(R.id.fb_add);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));

        adapter=new MainAdapter(this,jsonArray);

        recyclerView.setAdapter(adapter);
        fbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(  Ratee.this);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setContentView(R.layout.dialog_main);
                dialog.show();
                RatingBar ratingBar = dialog.findViewById(R.id.rating_bar);
                TextView tvRating = dialog.findViewById(R.id.tv_rating);
                Button btSubmit = dialog.findViewById(R.id.bt_submit);

                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean fromUser) {
                        tvRating.setText(String.format("(%S)",v));
                    }
                });

                btSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String sRating = String.valueOf(ratingBar.getRating());

                        try {

                            jsonArray.put(new JSONObject().put("rating",sRating));
                            recyclerView.setAdapter(adapter);
                            dialog.dismiss();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });


            }
        });


    }
    public void ClickRatee(View view){
        recreate();
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

    public void ClickConseils( View view){
        MainActivity2.redirectActivity(this,Conseils.class);
    }
    public  void ClickRendez_Vous(View view){
        MainActivity2.redirectActivity(this,Rendez_Vous.class);
    }
    public void ClickQ_A(View view){
        MainActivity2.redirectActivity(this,Q_A.class);
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