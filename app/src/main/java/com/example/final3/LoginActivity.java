package com.example.final3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username ,password;
    Button signin ;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        username= findViewById(R.id.username1);
        password=findViewById(R.id.password1);
        signin= findViewById(R.id.signin1);
        DB= new DBHelper(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= username.getText().toString();
                String pass= password.getText().toString();

                if (TextUtils.isEmpty(user)|| TextUtils.isEmpty(pass)){
                    Toast.makeText(LoginActivity.this,"All fields required ",Toast.LENGTH_LONG).show();
                }else {
                    boolean checkuserpassword = DB.checkusernamepassword(user,pass);
                    if(checkuserpassword==true){
                        Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                        startActivity(intent);
                    }else {  Toast.makeText(LoginActivity.this,"Login Failed",Toast.LENGTH_LONG).show();}


                }
            }
        });

    }

}