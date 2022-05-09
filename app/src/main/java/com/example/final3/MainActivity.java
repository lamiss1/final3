package com.example.final3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText password, repassword,username;
    Button signup,signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password= findViewById(R.id.password);
        repassword =findViewById(R.id.repassword);

        signin = findViewById(R.id.signin);
        signup = findViewById(R.id.signup);

        DB= new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user= username.getText().toString();
                String pass= password.getText().toString();
                String repass= repassword.getText().toString();


                if (TextUtils.isEmpty(user)|| TextUtils.isEmpty(pass)|| TextUtils.isEmpty(repass))
                { Toast.makeText(MainActivity.this,"All fields Required ", Toast.LENGTH_LONG).show();}

                else{
                    if (pass.equals(repass))
                    {boolean checkusername = DB.checkusername(user);
                        if (checkusername==false){
                            boolean insert= DB.insertDtata(user, pass);
                            if (insert==true){
                                Toast.makeText(MainActivity.this, "registered successfully ",Toast.LENGTH_LONG).show();

                                Intent intent= new Intent( getApplicationContext(),MainActivity2.class);
                                startActivity(intent);
                            } else {Toast.makeText(MainActivity.this,"Registration Failed ",Toast.LENGTH_LONG).show();}


                        }else { Toast.makeText(MainActivity.this,"user already exists",Toast.LENGTH_LONG).show();}



                    }else{ Toast.makeText(MainActivity.this,"Passwords are not matching",Toast.LENGTH_LONG).show();}
                }


            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);

            }
        });

    }
}