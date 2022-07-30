package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.QuickContactBadge;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText unameR,passR,rpassR;
    Button signup,signin;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        unameR=(EditText) findViewById(R.id.unameR);
        passR=(EditText) findViewById(R.id.passR);
        rpassR=(EditText) findViewById(R.id.rpassR);
        signup=(Button) findViewById(R.id.registerB);
        signin=(Button) findViewById(R.id.loginRB);
        db=new DBHelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=unameR.getText().toString();
                String pass=passR.getText().toString();
                String repass=rpassR.getText().toString();
                if(user.equals("")||pass.equals("")||repass.equals("")){
                    Toast.makeText(MainActivity.this, "Please enter all the details", Toast.LENGTH_LONG).show();
            }else{
                    if(pass.equals(repass)){
                        boolean cuser=db.checkusername(user);
                        if(!cuser){
                            boolean insert =db.inertData(user,pass);
                            if(insert==true){
                                Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_LONG).show();
                                Intent intentt=new Intent(getApplicationContext(),Login.class);
                                startActivity(intentt);
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "user already exists!Please login", Toast.LENGTH_LONG).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Incorrect Password!", Toast.LENGTH_LONG).show();
                    }
                    }
                }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

    }
}