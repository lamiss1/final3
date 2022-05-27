package com.example.final3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.github.mikephil.charting.charts.BarChart;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;




import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;




import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class MainActivity2 extends AppCompatActivity {

    DrawerLayout drawerLayout;
    BarChart barChart;
    TextView tvR, tvPython, tvCPP, tvJava;
    PieChart pieChart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        drawerLayout= findViewById(R.id.drawer_layout);

        barChart = findViewById(R.id.bar_chart);

        ArrayList<BarEntry> barEntries = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            double value = 0;
            if (i == 1) {
                value = 3.5;
            }
            ;
            if (i == 2) {
                value = 3.3;
            }
            ;
            if (i == 3) {
                value = 3.3;
            }
            ;
            if (i == 4) {
                value = 3.5;
            }
            ;
            if (i == 5) {
                value = 3.3;
            }
            ;
            if (i == 6) {
                value = 3.5;
            }
            ;
            if (i == 7) {
                value = 3.5;
            }
            ;
            if (i == 8) {
                value = 3.6;
            }
            ;
            if (i == 9) {
                value = 3.6;
            }
            ;

            BarEntry barEntry = new BarEntry(i, (float) value);


            barEntries.add(barEntry);



        }
        BarDataSet barDataSet = new BarDataSet(barEntries, "Taux");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setDrawValues(false);

        barChart.setData(new BarData(barDataSet));
        barChart.animateY(3000);


        tvR = findViewById(R.id.tvR);
        tvPython = findViewById(R.id.tvPython);
        tvCPP = findViewById(R.id.tvCPP);
        tvJava = findViewById(R.id.tvJava);
        pieChart = findViewById(R.id.piechart);
        setData2();



    }

    private void setData2()
    {

        tvR.setText(Double.toString(77.99));
        tvPython.setText(Double.toString(77.78));
        tvCPP.setText(Double.toString(77.57));
        tvJava.setText(Double.toString(77.4));

        pieChart.addPieSlice(
                new PieModel(
                        "2017",
                        (float) Double.parseDouble(tvR.getText().toString()),
                        Color.parseColor("#FFA726")));
        pieChart.addPieSlice(
                new PieModel(
                        "2016",
                        (float) Double.parseDouble(tvPython.getText().toString()),
                        Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(
                new PieModel(
                        "2015",
                        (float) Double.parseDouble(tvCPP.getText().toString()),
                        Color.parseColor("#EF5350")));
        pieChart.addPieSlice(
                new PieModel(
                        "2014",
                        (float) Double.parseDouble(tvJava.getText().toString()),
                        Color.parseColor("#29B6F6")));

        pieChart.startAnimation();

        getSupportActionBar().hide();

    }

    public void ClickMenu (View view) {
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome (View view){
        recreate();
    }

    public void ClickQ_A(View view){
        redirectActivity(this,Q_A.class);
    }

    public  void ClickRendez_Vous(View view){
        redirectActivity(this,Rendez_Vous.class);
    }
    public void ClickAlerte(View view ){
        redirectActivity(this,Alerte.class);
    }
    public void ClickEspaceMaman (View view){
        redirectActivity(this,EspaceMaman.class);
    }
    public void ClickProduit(View view){
        redirectActivity(this,Produit.class);
    }
    public void ClickLogout (View view ) {
        logout(this);
    }
    public void ClickConseils(View view){
        redirectActivity(this,Conseils.class);
    }
    public void ClickRatee( View view){
        redirectActivity(this,Ratee.class);

    }



    public static void logout(Activity activity) {
        AlertDialog.Builder builder= new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit(0);

            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });
        builder.show();
    }

    public static void redirectActivity(Activity activity, Class aclass) {
        Intent intent = new Intent(activity,aclass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }




}