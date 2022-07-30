package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity{
    EditText username,password;
    Button btnlogin;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        username=(EditText) findViewById(R.id.unameL);
        password=(EditText) findViewById(R.id.passL);
        btnlogin=(Button) findViewById(R.id.loginL);
        db=new DBHelper(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            private View view;

            @Override
            public void onClick(View view) {
               this.view = view;
                String user=username.getText().toString();
                String pass=password.getText().toString();
                if(user.equals("")||pass.equals("")){
                    Toast.makeText(Login.this, "Please enter all the details", Toast.LENGTH_LONG).show();
                }
                else{
                    Boolean checkuserpass=db.checkusernamepassword(user,pass);
                    if(checkuserpass){
                        Toast.makeText(Login.this, "Login successful", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(Login.this,Home.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

    }
    public String getUsername(){
        return username.getText().toString();
    }


}