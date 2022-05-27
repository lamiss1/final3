package com.example.final3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class Rendez_Vous extends AppCompatActivity implements UserAdapter.UserClickListener{
    DrawerLayout drawerLayout ;

    RecyclerView rvUsers;
    UserAdapter userAdapter;
    List<UserModel> userModelList= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        drawerLayout=findViewById(R.id.drawer_layout);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rendez_vous);
        rvUsers= findViewById(R.id.rvUsers);
        setData();
        prepareRecyclerView();


    }
    //rdv

    public void setData() {
        userModelList.add(new UserModel("Lamiss","Chekh","93721142"));
        userModelList.add(new UserModel("yassine","haffi","99999999"));
        userModelList.add(new UserModel("Lamia","Chouihi","93721142"));
        userModelList.add(new UserModel("Mohamed","Ben Ali","99999999"));
        userModelList.add(new UserModel("Ahmed","Mohamed","93721142"));
        userModelList.add(new UserModel("yassine","haffi","99999999"));



    }
    public void prepareRecyclerView(){
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvUsers.setLayoutManager(linearLayoutManager);
        preAdapter();

    }
    public void preAdapter(){
        userAdapter= new UserAdapter(userModelList,this,this::selectedUser);
        rvUsers.setAdapter(userAdapter);
    }

    @Override
    public void selectedUser(UserModel userModel) {
        Toast.makeText(this,"selected user"+userModel.getFirstName(),Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this,SelectedUserActivity.class).putExtra("data",userModel));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        if (id == R.id.searchView) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem menuItem= menu.findItem(R.id.searchView);
        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String searchStr= newText;
                userAdapter.getFilter().filter(newText);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }



    public void ClickMenu (View view){
        MainActivity2.openDrawer(drawerLayout);
    }
    public void clickLogo (View view){
        MainActivity2.closeDrawer(drawerLayout);

    }
    public void ClickAboutUs (View view){
        MainActivity2.redirectActivity(this, Ratee.class);
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
    public void ClickRatee(View view){
        MainActivity2.redirectActivity(this,Ratee.class);
    }
    public void ClickQ_A(View view){
        MainActivity2.redirectActivity(this,Q_A.class);
    }
    public void ClickAlerte(View view){
        MainActivity2.redirectActivity(this,Alerte.class);
    }

    public void ClickRendez_Vous (View view){
        recreate(); }
    public void ClickLogout(View view){
        MainActivity2.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity2.closeDrawer(drawerLayout);
    }
}